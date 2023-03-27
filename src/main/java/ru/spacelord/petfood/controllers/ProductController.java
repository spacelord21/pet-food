package ru.spacelord.petfood.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.spacelord.petfood.domain.Product;
import ru.spacelord.petfood.services.ProductService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "http://45.80.69.21:3000"})
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/get-product={id}")
    public Product getProductById(@PathVariable(name = "id") Long id) {
        return productService.productById(id);
    }
}
