package dev.aman.fakestorepractice.Repositories;

import dev.aman.fakestorepractice.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByTitle(String title);

    Category save(Category category);

    Category findByid(Long id);
}
