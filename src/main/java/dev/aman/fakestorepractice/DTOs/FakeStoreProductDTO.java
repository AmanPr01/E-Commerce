package dev.aman.fakestorepractice.DTOs;

import dev.aman.fakestorepractice.Models.Category;
import dev.aman.fakestorepractice.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {

    private Long id;

    private String title;

    private Double price;

    private String description;

    private String image;

    private String category;

    public Product toProduct() {

        Product product = new Product();

        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageURL(image);

        Category cat = new Category();
        cat.setTitle(category);

        product.setCategory(cat);

        return product;
    }
}
