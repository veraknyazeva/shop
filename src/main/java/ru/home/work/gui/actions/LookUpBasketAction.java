package ru.home.work.gui.actions;

import ru.home.work.gui.MainWindow;
import ru.home.work.gui.UserContentCreator;
import ru.home.work.service.singleton.ShopProductsManager;
import ru.home.work.shop.domain.Basket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LookUpBasketAction implements ActionListener {
    public static final String BASKET = "Корзина";
    private final MainWindow mainWindow;

    public LookUpBasketAction(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Товары в корзине:");
        Basket.getBasket().getProducts().forEach(shopProduct -> {
            System.out.println(shopProduct.getName() + " кол-во: " + shopProduct.getCount());
        });

        UserContentCreator.showBasketInformation(Basket.getBasket().getProducts(), mainWindow);
    }
}
