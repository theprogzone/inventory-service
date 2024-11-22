package com.ecommerce.inventory_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "T_INVENTORY")
@Getter
@Setter
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SKU_CODE")
    private String skuCode;

    @Column(name = "QUANTITY")
    private Integer quantity;
}
