package dev.aman.fakestorepractice.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Product extends BaseModel {

    private String title;

    private Double price;

    private String description;

    private String imageURL;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Category category;


}
