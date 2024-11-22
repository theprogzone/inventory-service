package com.ecommerce.inventory_service.controller;

import com.ecommerce.inventory_service.dto.InventoryDTO;
import com.ecommerce.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createInventory(@RequestBody InventoryDTO inventoryDTO) {
        inventoryService.createInventory(inventoryDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateInventory(@RequestBody InventoryDTO inventoryDTO) {
        inventoryService.updateQuantity(inventoryDTO);
    }

    @GetMapping("/{skuCode}")
    @ResponseStatus(HttpStatus.OK)
    public InventoryDTO updateInventory(@PathVariable("skuCode") String skuCode) {
        return inventoryService.getInventory(skuCode);
    }
}
