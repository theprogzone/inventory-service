package com.ecommerce.inventory_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryDTO {

    private Long id;

    private String skuCode;

    private Integer quantity;
}
