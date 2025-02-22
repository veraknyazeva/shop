package ru.home.work.shop.domain;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private static Basket basket = null;
    private final List<BasketProduct> products = new ArrayList<>();

    private Basket() {

    }

    public static Basket getBasket() {
        if (basket == null) {
            basket = new Basket();
        }
        return basket;
    }
    
    public List<BasketProduct> getProducts() {
        return products;
    }
}
