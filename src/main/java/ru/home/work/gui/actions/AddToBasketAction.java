package ru.home.work.gui.actions;

import ru.home.work.gui.MainWindow;
import ru.home.work.shop.domain.Basket;
import ru.home.work.shop.domain.ShopProduct;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddToBasketAction implements ActionListener {
    public static final String ADD_TO_BASKET = "Добавить в корзину";
    private static final String PUT_IN_BASKET = "Положили в корзину: ";
    private static final String THE_PRODUCT_IS_OUT = "Продукт закончился! :( ";
    private final MainWindow mainWindow;
    private final ShopProduct shopProduct;

    public AddToBasketAction(MainWindow mainWindow, ShopProduct shopProduct) {
        this.mainWindow = mainWindow;
        this.shopProduct = shopProduct;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (shopProduct.getCount() > 0) {
            ShopProduct shopProductForBasket = new ShopProduct();
            shopProductForBasket.setName(shopProduct.getName());
            shopProductForBasket.setCategory(shopProduct.getCategory());
            shopProductForBasket.setProducer(shopProduct.getProducer());
            shopProductForBasket.setPromotion(shopProduct.isPromotion());
            shopProductForBasket.setPrice(shopProduct.getPrice());
            shopProductForBasket.setId(shopProduct.getId());

            List<ShopProduct> basketProducts = Basket.getBasket().getProducts();

            if (basketProducts.isEmpty()) {

                shopProductForBasket.setCount(1);
                basketProducts.add(shopProductForBasket);

            } else {
                if (basketProducts.contains(shopProductForBasket)) {
                    int index = basketProducts.indexOf(shopProductForBasket);
                    ShopProduct product = basketProducts.get(index);
                    Integer count = product.getCount();
                    count++;
                    product.setCount(count);

                    basketProducts.set(index, product);
                } else {
                    shopProductForBasket.setCount(1);
                    basketProducts.add(shopProductForBasket);
                }
            }
            Integer count = shopProduct.getCount();
            count--;
            shopProduct.setCount(count);
            System.out.println(PUT_IN_BASKET + shopProductForBasket.getName());
        } else {
            JOptionPane.showMessageDialog(mainWindow, THE_PRODUCT_IS_OUT);
        }
    }
}
