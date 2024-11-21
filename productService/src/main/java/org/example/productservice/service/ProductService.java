package org.example.productservice.service;

import org.example.productservice.entity.Product;
import lombok.RequiredArgsConstructor;
import org.example.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(String prId, Product productDetails) {
        Product product = productRepository.findById(prId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setPrPrice(productDetails.getPrPrice());
        product.setPrName(productDetails.getPrName());
        product.setPrCategory(productDetails.getPrCategory());


        return productRepository.save(product);
    }

    public void deleteProduct(String prId) {
        productRepository.deleteById(prId);
    }
}
