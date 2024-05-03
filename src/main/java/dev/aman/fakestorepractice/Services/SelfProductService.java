package dev.aman.fakestorepractice.Services;

import dev.aman.fakestorepractice.Models.Category;
import dev.aman.fakestorepractice.Models.Product;
import dev.aman.fakestorepractice.Repositories.CategoryRepository;
import dev.aman.fakestorepractice.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService {

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    // constructor
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        return productRepository.findByIdIs(productId);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(String title, Double price, String description, String image, String category) {

        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageURL(image);

        Category categoryFromDB = categoryRepository.findByTitle(category);

        // if category is not present then we have to create a new category in the database
        if (categoryFromDB == null) {
            Category newCategory = new Category();
            newCategory.setTitle(category);
            categoryFromDB = newCategory;
        }

        product.setCategory(categoryFromDB);

        // save the product in the database
        productRepository.save(product);

        return product;
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Product updateProduct(Long productId, String title, Double price, String description, String image, String category) {
        Product product = productRepository.findByIdIs(productId);

        if (product != null) {
            product.setTitle(title);
            product.setPrice(price);
            product.setDescription(description);
            product.setImageURL(image);

            Category cat = categoryRepository.findByTitle(category);

            product.setCategory(cat);
        }

        return productRepository.save(product);
    }

    @Override
    public List<Product> getProductByCategory(String title) {
        return productRepository.findByCategoryTitle(title);
    }
}
