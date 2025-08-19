package org.example.day12_product_inventory.repository;

import org.example.day12_product_inventory.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
