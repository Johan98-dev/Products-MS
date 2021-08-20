package com.misiontic_DW5_G5.products_ms.model;

import javax.persistence.*;

@Entity
@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="product_name")
    private String productName;
    @Column(name="product_category")
    private String category;
    @Column(name="product_stock")
    private int stock;
    @Column(name="product_price")
    private int price;


    public Product() {
    }

    public Product(String productName, String category, int stock, int price) {
        this.productName = productName;
        this.category = category;
        this.stock = stock;
        this.price = price;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
