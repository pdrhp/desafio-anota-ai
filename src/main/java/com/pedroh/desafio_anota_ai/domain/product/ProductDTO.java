package com.pedroh.desafio_anota_ai.domain.product;

import com.pedroh.desafio_anota_ai.domain.category.Category;

public record ProductDTO(String title, String description, String ownerId, Integer price, String categoryId) { }
