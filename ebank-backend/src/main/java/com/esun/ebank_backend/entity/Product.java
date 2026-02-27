package com.esun.ebank_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Product")
@Data // 自動產生 Getter/Setter
public class Product {

    @Id
    @Column(name = "ProductID")
    private String productId;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "Price")
    private Integer price;

    @Column(name = "Quantity")
    private Integer quantity;
}