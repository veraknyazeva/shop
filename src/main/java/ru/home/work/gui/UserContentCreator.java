package ru.home.work.gui;

import ru.home.work.shop.domain.ShopProduct;
import ru.home.work.shop.domain.WareHouseProduct;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class UserContentCreator { //Лисков
    private static final String PROMO = " АКЦИЯ! ";
    private static final String COUNT = " шт/кг/л";
    private static final String TOTAL_AMOUNT = "Итого к оплате: ";

    public static void showInformationByFilteredProducts(List<? extends WareHouseProduct> filteredProducts,
                                                         MainWindow mainWindow) {
        mainWindow.getFlexibleUserContentPanel().removeAll();

        filteredProducts.forEach(wareHouseProduct -> {
            JPanel panelForProduct = ContentCreator.createPanelWithGridLayout();
            panelForProduct.setBorder(BorderFactory.createLineBorder(Color.black));

            if (wareHouseProduct instanceof ShopProduct product
                    && product.isPromotion()) {
                panelForProduct.add(ContentCreator.createTextWithRedColor(wareHouseProduct.getPrice() + PROMO));
            } else {
                panelForProduct.add(ContentCreator.createText(String.valueOf(wareHouseProduct.getPrice())));
            }
            panelForProduct.add(ContentCreator.createText(wareHouseProduct.getName()));
            panelForProduct.add(ContentCreator.createText(wareHouseProduct.getProducer()));
            panelForProduct.add(ContentCreator.createAddToBasketButton(wareHouseProduct, mainWindow));

            mainWindow.getFlexibleUserContentPanel().add(panelForProduct);
        });

        mainWindow.getFlexibleUserContentPanel().revalidate();
        mainWindow.getFlexibleUserContentPanel().repaint();
        mainWindow.repaint();
    }

    public static void showBasketInformation(List<? extends WareHouseProduct> wareHouseProducts,
                                             MainWindow mainWindow) {
        mainWindow.getFlexibleUserContentPanel().removeAll();
        double totalPrice = 0;
        for (int i = 0; i < wareHouseProducts.size(); i++) {
            WareHouseProduct product = wareHouseProducts.get(i);
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
