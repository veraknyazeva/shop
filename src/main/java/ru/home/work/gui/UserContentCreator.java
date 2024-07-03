package ru.home.work.gui;

import ru.home.work.shop.domain.ShopProduct;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class UserContentCreator {
    private static final String PROMO = " АКЦИЯ! ";

    public static void showInformationByFilteredProducts(List<ShopProduct> filteredProducts, MainWindow mainWindow) {
        mainWindow.getFlexibleUserContentPanel().removeAll();

        filteredProducts.forEach(shopProduct -> {
            JPanel panelForProduct = ContentCreator.createPanelWithGridLayout();
            panelForProduct.setBorder(BorderFactory.createLineBorder(Color.black));
            if (shopProduct.isPromotion()) {
                panelForProduct.add(ContentCreator.createTextWithRedColor(shopProduct.getPrice() + PROMO));
            } else {
                panelForProduct.add(ContentCreator.createText(String.valueOf(shopProduct.getPrice())));
            }
            panelForProduct.add(ContentCreator.createText(shopProduct.getName()));
            panelForProduct.add(ContentCreator.createText(shopProduct.getProducer()));
            panelForProduct.add(ContentCreator.createAddToBasketButton());

            mainWindow.getFlexibleUserContentPanel().add(panelForProduct);
        });

        mainWindow.getFlexibleUserContentPanel().revalidate();
        mainWindow.getFlexibleUserContentPanel().repaint();
        mainWindow.repaint();
    }
}
