package ru.home.work.service.loader;

import ru.home.work.shop.domain.ProductCategory;

public class Product {
    private Long id;
    private String category;
    private String name;
    private String producer;
    private Double price;
    private Integer count;
    private boolean promotion;

    public Product(){

    }
    public Product(Long id, String category, String name, String producer, Double price, Integer count, boolean promotion) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.count = count;
        this.promotion = promotion;
    }

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getProducer() {
        return producer;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getCount() {
        return count;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }
}
