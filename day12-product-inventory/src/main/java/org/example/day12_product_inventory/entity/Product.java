package org.example.day12_product_inventory.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    @Column(nullable = false)
    private String productName;
    @Column(length = 1000)
    private String productDescription;
    @Column(nullable = false)
    private BigDecimal productPrice;
    private Integer productStock;
    private String productCategory;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime productCreateDate;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
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
