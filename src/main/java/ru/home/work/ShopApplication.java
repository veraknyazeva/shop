package ru.home.work;

import ru.home.work.gui.MainWindow;
import ru.home.work.service.singleton.ShopProductsManager;
import ru.home.work.shop.domain.Basket;

public class ShopApplication {
    public static void start() {
        ShopProductsManager.getInstance();
        Basket.getBasket();

        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
    }
}
