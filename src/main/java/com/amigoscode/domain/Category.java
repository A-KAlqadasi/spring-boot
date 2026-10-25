package com.amigoscode.domain;

import com.amigoscode.common.results.Result;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

    @OneToMany(mappedBy = "category")
    private List<Product> products ;
    protected Category () {

    }

    private Category(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Result<Category> create(UUID id, String name) {

        return Result.success(new Category(id, name));
    }
}
