package org.example.day12_product_inventory.service;

import org.example.day12_product_inventory.entity.Product;
import org.example.day12_product_inventory.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product updateProductPartially(Long id, Map<String, Object> updates) {
        Product product = productRepository.findById(id).orElseThrow();
       return productRepository.save(product);

    }
}
