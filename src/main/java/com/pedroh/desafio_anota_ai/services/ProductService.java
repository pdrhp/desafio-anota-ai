package com.pedroh.desafio_anota_ai.services;


import com.pedroh.desafio_anota_ai.domain.category.Category;
import com.pedroh.desafio_anota_ai.domain.category.CategoryDTO;
import com.pedroh.desafio_anota_ai.domain.category.exceptions.CategoryNotFoundException;
import com.pedroh.desafio_anota_ai.domain.product.Product;
import com.pedroh.desafio_anota_ai.domain.product.ProductDTO;
import com.pedroh.desafio_anota_ai.domain.product.exceptions.ProductNotFoundException;
import com.pedroh.desafio_anota_ai.repositories.CategoryRepository;
import com.pedroh.desafio_anota_ai.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private CategoryService categoryService;
    private ProductRepository productRepository;

    public ProductService(CategoryService categoryService, ProductRepository productRepository) {
        this.categoryService = categoryService;
        this.productRepository = productRepository;
    }

    public Product create(ProductDTO productDTO) {
        Product newProduct = new Product(productDTO);

        Category category = this.categoryService.getById(productDTO.categoryId()).orElseThrow(CategoryNotFoundException::new);

        newProduct.setCategory(category);

        this.productRepository.save(newProduct);

        return newProduct;
    }

    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    public Product update(String id , ProductDTO productDTO) {


        Product product = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);

        this.categoryService.getById(productDTO.categoryId()).ifPresent(product::setCategory);

        if(!productDTO.title().isEmpty()) product.setTitle(productDTO.title());
        if(!productDTO.description().isEmpty()) product.setDescription(productDTO.description());
        if(productDTO.price() != null) product.setPrice(productDTO.price());

        this.productRepository.save(product);

        return product;
    }

    public void delete(String id) {
        Product product = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);


        this.productRepository.delete(product);
    }






}
