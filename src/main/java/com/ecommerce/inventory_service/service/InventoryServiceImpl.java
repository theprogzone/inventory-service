package com.ecommerce.inventory_service.service;

import com.ecommerce.inventory_service.dto.InventoryDTO;
import com.ecommerce.inventory_service.model.Inventory;
import com.ecommerce.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public InventoryDTO getInventory(String skuCode) {
        Optional<Inventory> inventoryOptional = inventoryRepository.findBySkuCode(skuCode);
        if (inventoryOptional.isPresent()) {
            Inventory inventory = inventoryOptional.get();
            InventoryDTO inventoryDTO = new InventoryDTO();
            BeanUtils.copyProperties(inventory, inventoryDTO);
            return inventoryDTO;
        }
        return null;
    }

    @Override
    public void updateQuantity(InventoryDTO inventoryDTO) {
        Optional<Inventory> inventoryOptional = inventoryRepository.findBySkuCode(inventoryDTO.getSkuCode());
        if (inventoryOptional.isPresent()) {
            Inventory inventory = inventoryOptional.get();
            inventory.setQuantity(inventoryDTO.getQuantity());
            inventoryRepository.save(inventory);
        }
    }

    @Override
    public void createInventory(InventoryDTO inventoryDTO) {
        Inventory inventory = new Inventory();
        BeanUtils.copyProperties(inventoryDTO, inventory);
        inventoryRepository.save(inventory);
    }
}
