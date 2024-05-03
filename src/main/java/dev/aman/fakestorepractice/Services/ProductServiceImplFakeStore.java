package dev.aman.fakestorepractice.Services;

import dev.aman.fakestorepractice.DTOs.FakeStoreProductDTO;
import dev.aman.fakestorepractice.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("productServiceImplFakeStore")
public class ProductServiceImplFakeStore implements ProductService {

    RestTemplate restTemplate;

    @Autowired
    public ProductServiceImplFakeStore(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {

        // First we need to call the url of fake store through rest template in fakeStoreProductDTO
        // getting the response from fake store URL(which in JSON) and saving those in the FakestoreDTO class to convert to java pojo.

        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + productId, FakeStoreProductDTO.class);

        // return the product to the controller

        // assert fakeStoreProductDTO != null;
        return fakeStoreProductDTO.toProduct();
    }

    @Override
    public List<Product> getProducts() {

        FakeStoreProductDTO[] fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDTO[].class);

        List<Product> products = new ArrayList<>();

        for (FakeStoreProductDTO product : fakeStoreProductDTO) {
            products.add(product.toProduct());
        }

        return products;
    }

    @Override
    public Product createProduct(String title, Double price, String description, String image, String category) {

        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(title);
        fakeStoreProductDTO.setPrice(price);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setImage(image);
        fakeStoreProductDTO.setCategory(category);

        FakeStoreProductDTO response = restTemplate.postForObject("https://fakestoreapi.com/products", fakeStoreProductDTO, FakeStoreProductDTO.class);

        if (response == null) {
            return new Product();
        }

        return response.toProduct();
    }

    @Override
    public void deleteProduct(Long productId) {

        restTemplate.delete("https://fakestoreapi.com/products/" + productId);
    }

    @Override
    public Product updateProduct(Long productId, String title, Double price, String description, String image, String category) {

        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setId(productId);
        fakeStoreProductDTO.setTitle(title);
        fakeStoreProductDTO.setPrice(price);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setImage(image);
        fakeStoreProductDTO.setCategory(category);

        FakeStoreProductDTO response = restTemplate.patchForObject("https://fakestoreapi.com/products/" + productId, fakeStoreProductDTO, FakeStoreProductDTO.class);

        if (response == null) {
            return new Product();
        }

        return response.toProduct();
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        return List.of();
    }
}













