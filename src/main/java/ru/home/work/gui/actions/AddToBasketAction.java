package ru.home.work.gui.actions;

import ru.home.work.gui.MainWindow;
import ru.home.work.shop.domain.Basket;
import ru.home.work.shop.domain.BasketProduct;
import ru.home.work.shop.domain.ShopProduct;
import ru.home.work.shop.domain.WareHouseProduct;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddToBasketAction implements ActionListener {
    public static final String ADD_TO_BASKET = "Добавить в корзину";
    private static final String PUT_IN_BASKET = "Положили в корзину: ";
    private static final String THE_PRODUCT_IS_OUT = "Продукт закончился! :( ";
    private final MainWindow mainWindow;
    private final WareHouseProduct shopProduct;

    public AddToBasketAction(MainWindow mainWindow, WareHouseProduct shopProduct) {
        this.mainWindow = mainWindow;
        this.shopProduct = shopProduct;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (shopProduct.getCount() > 0) {
            BasketProduct basketProduct = new BasketProduct();
            basketProduct.setName(shopProduct.getName());
            basketProduct.setProducer(shopProduct.getProducer());
            basketProduct.setPrice(shopProduct.getPrice());
            basketProduct.setId(shopProduct.getId());

            List<BasketProduct> basketProducts = Basket.getBasket().getProducts();

            if (basketProducts.isEmpty()) {

                basketProduct.increase();
                basketProducts.add(basketProduct);

            } else {
                if (basketProducts.contains(basketProduct)) {
                    int index = basketProducts.indexOf(basketProduct);
                    BasketProduct product = basketProducts.get(index);
                    product.increase();

                    basketProducts.set(index, product);
                } else {
                    basketProduct.setCount(1);
                    basketProducts.add(basketProduct);
                }
            }
            shopProduct.decrease();
            System.out.println(PUT_IN_BASKET + basketProduct.getName());
        } else {
            JOptionPane.showMessageDialog(mainWindow, THE_PRODUCT_IS_OUT);
        }
    }
}
