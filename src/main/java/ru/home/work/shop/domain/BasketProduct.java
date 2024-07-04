package ru.home.work.shop.domain;

public class BasketProduct extends ShopProduct {
    private Double totalPrice;

    public BasketProduct() {
    }

    public BasketProduct(Long id, ProductCategory category, String name, String producer, Double price, Integer count, boolean promotion, Double totalPrice) {
        super(id, category, name, producer, price, count, promotion);
        this.totalPrice = totalPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
