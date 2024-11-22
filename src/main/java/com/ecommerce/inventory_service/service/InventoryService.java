package com.ecommerce.inventory_service.service;

import com.ecommerce.inventory_service.dto.InventoryDTO;

public interface InventoryService {

    InventoryDTO getInventory(String skuCode);

    void updateQuantity(InventoryDTO inventoryDTO);

    void createInventory(InventoryDTO inventoryDTO);
}
