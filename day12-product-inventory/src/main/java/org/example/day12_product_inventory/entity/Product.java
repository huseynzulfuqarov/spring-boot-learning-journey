package org.example.day12_product_inventory.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String productName;
    @Column(length = 1000)
    private String productDescription;
    @Column(nullable = false)
    private BigDecimal productPrice;
    private Integer productStock;
    private String productCategory;

    private LocalDateTime productCreateDate;
    private LocalDateTime productUpdateDate;

    public Product() {}

    @PrePersist
    protected void onCreate() {
        productCreateDate = LocalDateTime.now();
        productUpdateDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        productUpdateDate = LocalDateTime.now();
    }
}
