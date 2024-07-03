package ru.home.work.gui.actions;

import ru.home.work.gui.MainWindow;
import ru.home.work.gui.UserContentCreator;
import ru.home.work.service.ShopProductsManager;
import ru.home.work.shop.domain.ShopProduct;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FilterByPriceAction implements ActionListener {

    public static final String SEARCH = "Поиск";
    private static final Double PRICE_LEFT_BORDER = 10.00;
    private final MainWindow mainWindow;

    public FilterByPriceAction(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String enteredText = mainWindow.getPriceInput().getText();
        if (enteredText != null && !enteredText.isBlank()) {
            try {
                double enteredPrice = Double.parseDouble(enteredText);
                List<ShopProduct> products = ShopProductsManager.getInstance().getProducts();
                double min = enteredPrice - PRICE_LEFT_BORDER;
                double max = enteredPrice;
                List<ShopProduct> filteredByPriceProducts = products.stream()
                        .filter(shopProduct -> shopProduct.getPrice().equals(enteredPrice) ||
                                (shopProduct.getPrice() <= max && shopProduct.getPrice() >= min)
                        )
                        .toList();

                UserContentCreator.showInformationByFilteredProducts(filteredByPriceProducts, mainWindow);
            } catch (Exception ex) {

            }
        }
    }
}
