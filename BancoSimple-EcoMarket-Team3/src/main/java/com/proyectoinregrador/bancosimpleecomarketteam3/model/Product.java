package com.proyectoinregrador.bancosimpleecomarketteam3.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false, unique = true)
    private String product_name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "product_user", nullable = false)
    private User product_User;

    @ManyToMany
    @JoinTable(
            name = "product_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id")
    )
    private List<Categories> productCategories;

    public Product() {
    }

    public Product(Long id, String name, String description, Integer price, Integer stock, User product_User, List<Categories> productCategories) {
        this.id = id;
        this.product_name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.product_User = product_User;
        this.productCategories = productCategories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return product_name;
    }

    public void setName(String name) {
        this.product_name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public User getProduct_User() {
        return product_User;
    }

    public void setProduct_User(User product_User) {
        this.product_User = product_User;
    }

    public List<Categories> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<Categories> productCategories) {
        this.productCategories = productCategories;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + product_name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", product_User=" + product_User +
                ", productCategories=" + productCategories +
                '}';
    }
}
