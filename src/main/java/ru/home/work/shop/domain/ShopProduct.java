package ru.home.work.shop.domain;

import java.util.Objects;

public class ShopProduct {
    private Long id;
    private ProductCategory category;
    private String name;
    private String producer;
    private Double price;
    private Integer count;
    private boolean promotion;

    public ShopProduct() {

    }

    public ShopProduct(Long id, ProductCategory category, String name, String producer, Double price, Integer count, boolean promotion) {
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

    public ProductCategory getCategory() {
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

    public void setCategory(ProductCategory category) {
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

    @Override
    public String toString() {
        return "ShopProduct{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopProduct that = (ShopProduct) o;
        return Objects.equals(id, that.id) && category == that.category && Objects.equals(name, that.name) && Objects.equals(producer, that.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, name, producer);
    }
}
