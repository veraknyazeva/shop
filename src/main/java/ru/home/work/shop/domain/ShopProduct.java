package ru.home.work.shop.domain;

import java.util.Objects;

public class ShopProduct extends WareHouseProduct {
    private ProductCategory category;
    private boolean promotion;

    public ShopProduct() {
        super();
    }

    public ShopProduct(Long id, ProductCategory category, String name, String producer, Double price, Integer count, boolean promotion) {
        super(id, name, producer, price, count);
        this.category = category;
        this.promotion = promotion;
    }

    public ProductCategory getCategory() {
        return category;
    }


    public boolean isPromotion() {
        return promotion;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    @Override
    public String toString() {
        return "ShopProduct{" +
                "id=" + getId() +
                ", category=" + category +
                ", name='" + getName() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopProduct that = (ShopProduct) o;
        return Objects.equals(getId(), that.getId()) && category == that.category && Objects.equals(getName(), that.getName()) && Objects.equals(getProducer(), that.getProducer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), category, getName(), getProducer());
    }
}
