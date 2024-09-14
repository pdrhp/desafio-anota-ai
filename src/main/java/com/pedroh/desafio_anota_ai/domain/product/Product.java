package com.pedroh.desafio_anota_ai.domain.product;


import com.pedroh.desafio_anota_ai.domain.category.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    private String Id;
    private String title;
    private String description;
    private String ownerId;
    private Integer price;
    private Category category;


    public Product(ProductDTO productDto){
        this.title = productDto.title();
        this.description = productDto.description();
        this.ownerId = productDto.ownerId();
        this.price = productDto.price();
    }
}
