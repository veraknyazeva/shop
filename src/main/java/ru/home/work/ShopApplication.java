package ru.home.work;

import ru.home.work.gui.MainWindow;
import ru.home.work.service.ShopProductsManager;

public class ShopApplication {
    public static void start() {
        System.out.println(ShopProductsManager.getInstance().getProducts());

        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);

//        ProductsLoader productsLoader = new CsvProductsLoader(new ProductsParser());
//        System.out.println(productsLoader.loadProducts());
    }
}
