package dev.aman.fakestorepractice.Controllers;

import dev.aman.fakestorepractice.DTOs.FakeStoreProductDTO;
import dev.aman.fakestorepractice.Models.Product;
import dev.aman.fakestorepractice.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    private RestTemplate restTemplate;

    @Autowired
    public ProductController(@Qualifier("selfProductService") ProductService productService, RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }

    // getting single products from productId
    @GetMapping("/product/{id}")
    public Product getSingleProduct(@PathVariable("id") Long productId) {
        return productService.getSingleProduct(productId);
    }

    // getting all the products
    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    // creating a new product
    @PostMapping("/products")
    public Product createProduct(@RequestBody FakeStoreProductDTO request) {
        return productService.createProduct(
                request.getTitle(),
                request.getPrice(),
                request.getDescription(),
                request.getImage(),
                request.getCategory()
        );
    }

    // deleting a product
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") Long productId) {
        productService.deleteProduct(productId);
    }

    // patch/update the product
    @PatchMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long productId, @RequestBody FakeStoreProductDTO request) {
        return productService.updateProduct(
                productId,
                request.getTitle(),
                request.getPrice(),
                request.getDescription(),
                request.getImage(),
                request.getCategory()
        );
    }
}






