package com.example.jpa.api.service;

import com.example.jpa.data.domain.Category;
import com.example.jpa.data.domain.Product;
import com.example.jpa.data.repository.CategoryRepository;
import com.example.jpa.data.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.jpa.data.repository.specs.ProductSpecs.isCategory;
import static com.example.jpa.data.repository.specs.ProductSpecs.isEqualsTitle;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    private final CategoryRepository categoryRepository;

    public List<Product> getProduct() {
        return repository.findAll();
    }

    public List<Product> getProductByTitle(String title, String categoryTitle) {
        Category category = categoryRepository.findByTitle(categoryTitle);
        return repository.findAll(isEqualsTitle(title).or(isCategory(category)));
    }

}
