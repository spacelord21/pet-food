package ru.spacelord.petfood.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spacelord.petfood.dao.ProductRepository;
import ru.spacelord.petfood.domain.Product;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final FeedbackService feedbackService;

    @Autowired
    public ProductService(ProductRepository productRepository, FeedbackService feedbackService) {
        this.productRepository = productRepository;
        this.feedbackService = feedbackService;
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public Product productById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
