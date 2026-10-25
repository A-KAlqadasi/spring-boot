package com.amigoscode.domain;

import com.amigoscode.common.errors.ApplicationErrors;
import com.amigoscode.common.results.Result;
import com.amigoscode.common.results.Results;
import com.amigoscode.common.results.markers.Updated;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {
    @Id
    private UUID id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @Column(nullable = true, length = 20)
    private String sku;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getSku() {
        return sku;
    }

    public UUID getId(){
        return id;
    }

    public String getName() {
        return name;
    }


    public BigDecimal getPrice() {
        return price;
    }

    protected Product() {
        // Required by the JPA
    }

    private Product(UUID id, String name, BigDecimal price, String sku, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sku = sku;
        this.category = category;
    }

    public static Result<Product> create(UUID id, String name, BigDecimal price, String sku, Category category) {
        if (id == null) {
            return Result.failure(ApplicationErrors.PRODUCT_ID_REQUIRED);
        }

        if (name.isBlank()) {
            return Result.failure(ApplicationErrors.PRODUCT_NAME_REQUIRED);
        }

        if (price.compareTo(BigDecimal.ZERO) <= 0){
            return Result.failure(ApplicationErrors.PRICE_SHOULD_NOT_BE_NEGATIVE);
        }

        return Result.success(new Product(id, name, price, sku, category));
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Result<Updated> update(String name, BigDecimal price, String sku, Category category) {

        if (name.isBlank()) {
            return Result.failure(ApplicationErrors.PRODUCT_NAME_REQUIRED);
        }

        if (price.compareTo(BigDecimal.ZERO) <= 0){
            return Result.failure(ApplicationErrors.PRICE_SHOULD_NOT_BE_NEGATIVE);
        }

        setName(name);
        setPrice(price);
        setSku(sku);
        setCategory(category);

        return Result.success(Results.UPDATED);
    }
}
