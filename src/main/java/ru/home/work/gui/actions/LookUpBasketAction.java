package ru.home.work.gui.actions;

import ru.home.work.gui.MainWindow;
import ru.home.work.gui.UserContentCreator;
import ru.home.work.shop.domain.Basket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LookUpBasketAction implements ActionListener {
    public static final String BASKET = "Корзина";
    public static final String PRODUCT_IN_BASKET = "Товары в корзине:";
    public static final String COUNT = " кол-во: ";
    private final MainWindow mainWindow;

    public LookUpBasketAction(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(PRODUCT_IN_BASKET);
        Basket.getBasket().getProducts().forEach(shopProduct -> {
            System.out.println(shopProduct.getName() + COUNT + shopProduct.getCount());
        });

        UserContentCreator.showBasketInformation(Basket.getBasket().getProducts(), mainWindow);
    }
}
