package org.example.day12_product_inventory.repository;

import org.example.day12_product_inventory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
