package dev.aman.fakestorepractice.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Category extends BaseModel {

    private String title;

    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Product> products;
}





