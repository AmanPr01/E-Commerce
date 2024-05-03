package dev.aman.fakestorepractice.Services;

import dev.aman.fakestorepractice.Models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long productId);

    List<Product> getProducts();

    Product createProduct(String title,
                  Double price,
                  String description,
                  String image,
                  String category);

    void deleteProduct(Long productId);

    Product updateProduct(Long productId,
                          String title,
                          Double price,
                          String description,
                          String image,
                          String category);

    List<Product> getProductByCategory(String category);
}
