package ru.home.work.gui.actions;

import ru.home.work.gui.MainWindow;
import ru.home.work.gui.UserContentCreator;
import ru.home.work.shop.domain.ShopProduct;
import ru.home.work.shop.domain.ShopProductsManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FilterByKeyWordAction implements ActionListener {

    public static final String SEARCH = "Найти";
    private final MainWindow mainWindow;

    public FilterByKeyWordAction(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String keyWord = mainWindow.getKeyWordInput().getText();
        if (keyWord != null && !keyWord.isBlank()) {
            List<ShopProduct> filteredProducts = new ArrayList<>();
            List<ShopProduct> listOfProducts = ShopProductsManager.getInstance().getProducts();
            for (int i = 0; i < listOfProducts.size(); i++) {
                ShopProduct product = listOfProducts.get(i);
                if (product.getName().toUpperCase().contains(keyWord.toUpperCase()) ||
                        product.getProducer().toUpperCase().contains(keyWord.toUpperCase())) {
                    filteredProducts.add(product);
                }
            }
            UserContentCreator.showInformationByFilteredProducts(filteredProducts, mainWindow);
        }
    }
}
