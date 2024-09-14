package com.pedroh.desafio_anota_ai.domain.category.exceptions;


public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException() {}


    public CategoryNotFoundException(String message) {
        super(message);
    }

    public CategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
