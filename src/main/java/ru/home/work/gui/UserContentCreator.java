package ru.home.work.gui;

import ru.home.work.shop.domain.ShopProduct;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class UserContentCreator {
    private static final String PROMO = " АКЦИЯ! ";
    private static final String COUNT = " шт/кг/л";
    private static final String TOTAL_AMOUNT = "Итого к оплате: ";

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
            panelForProduct.add(ContentCreator.createAddToBasketButton(shopProduct, mainWindow));

            mainWindow.getFlexibleUserContentPanel().add(panelForProduct);
        });

        mainWindow.getFlexibleUserContentPanel().revalidate();
        mainWindow.getFlexibleUserContentPanel().repaint();
        mainWindow.repaint();
    }

    public static void showBasketInformation(List<ShopProduct> basketProducts, MainWindow mainWindow) {
        mainWindow.getFlexibleUserContentPanel().removeAll();
        double totalPrice = 0;
        for (int i = 0; i < basketProducts.size(); i++) {
            ShopProduct product = basketProducts.get(i);
            double priceForProduct = product.getPrice() * product.getCount();

            JPanel panelForProduct = ContentCreator.createPanelWithGridLayout();
            panelForProduct.setBorder(BorderFactory.createLineBorder(Color.GREEN));

            panelForProduct.add(ContentCreator.createText(product.getName()));
            panelForProduct.add(ContentCreator.createText(product.getCount() + COUNT));
            panelForProduct.add(ContentCreator.createText(String.valueOf(priceForProduct)));
            totalPrice += priceForProduct;

            mainWindow.getFlexibleUserContentPanel().add(panelForProduct);
        }
        JPanel panelForOrder = ContentCreator.createPanelWithGridLayout();
        panelForOrder.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        panelForOrder.add(ContentCreator.createText(TOTAL_AMOUNT));
        panelForOrder.add(ContentCreator.createTextWithRedColor(String.valueOf(totalPrice)));
        panelForOrder.add(ContentCreator.createOrderButton());
        mainWindow.getFlexibleUserContentPanel().add(panelForOrder);

        mainWindow.getFlexibleUserContentPanel().revalidate();
        mainWindow.getFlexibleUserContentPanel().repaint();
        mainWindow.repaint();
    }
}
