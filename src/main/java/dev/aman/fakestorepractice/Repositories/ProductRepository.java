package dev.aman.fakestorepractice.Repositories;

import dev.aman.fakestorepractice.Models.Product;
import dev.aman.fakestorepractice.Repositories.Projections.ProductWithIdAndTitle;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product save(Product product);

    List<Product> findAll();

    Product findByIdIs(Long id);

    @Transactional
    void deleteById(Long id);

    List<Product> findByCategoryTitle(String title);

    // HQL (Hibernate Query Language) queries
    @Query("select product from Product product where product.category.title = :title and product.id = :productId")  // product which we are using are from model class
    Product getProductWithParticularName(@Param("title") String title, @Param("productId") Long productId);

    // we are trying to get id and title of products of given category.
    @Query("select product.title as title, product.id as id from Product product where product.category.id = :categoryId")
    List<ProductWithIdAndTitle> getTitleOfProductOfGivenCategory(@Param("categoryId") Long categoryId);
}





