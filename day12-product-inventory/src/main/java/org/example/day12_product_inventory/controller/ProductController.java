package org.example.day12_product_inventory.controller;

import org.example.day12_product_inventory.entity.Product;
import org.example.day12_product_inventory.repository.ProductRepository;
import org.example.day12_product_inventory.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) BigDecimal maxPrice) {
        return productService.getAllProducts(category, maxPrice);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping()
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @PatchMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return productService.updateProductPartially(id, updates);
    }
}
