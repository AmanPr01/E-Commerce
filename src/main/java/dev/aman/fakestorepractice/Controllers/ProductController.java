package dev.aman.fakestorepractice.Controllers;

import dev.aman.fakestorepractice.Commons.AuthenticationCommons;
import dev.aman.fakestorepractice.DTOs.FakeStoreProductDTO;
import dev.aman.fakestorepractice.DTOs.UserDTO;
import dev.aman.fakestorepractice.Exceptions.InvalidTokenException;
import dev.aman.fakestorepractice.Models.Product;
import dev.aman.fakestorepractice.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;
    private RestTemplate restTemplate;
    private AuthenticationCommons authenticationCommons;

    @Autowired
    public ProductController(@Qualifier("productServiceImplFakeStore") ProductService productService,
                             RestTemplate restTemplate,
                             AuthenticationCommons authenticationCommons) {
        this.productService = productService;
        this.restTemplate = restTemplate;
        this.authenticationCommons = authenticationCommons;
    }

    // getting single products from productId
    @GetMapping("/product/{id}/{token}")
    public Product getSingleProduct(@PathVariable("id") Long productId, @PathVariable("token") String token) throws InvalidTokenException {

        UserDTO userDTO = authenticationCommons.validateToken(token);

        if (userDTO == null) {
            // Token is null
            throw new InvalidTokenException("Invalid token passed. Please login first to get the Product details");
        }

        // Token is valid, make a call to Product Service to fetch the product.
        return productService.getSingleProduct(productId);
    }

    // getting all the products
    @Cacheable(value = "products")
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






