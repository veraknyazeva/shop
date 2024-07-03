package ru.home.work.gui.actions;

import ru.home.work.gui.ContentCreator;
import ru.home.work.gui.UserContentCreator;
import ru.home.work.service.ShopProductsManager;
import ru.home.work.shop.domain.ProductCategory;
import ru.home.work.gui.MainWindow;
import ru.home.work.shop.domain.ShopProduct;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class FilterByProductCategoryAction implements ActionListener {
    private final MainWindow mainWindow;

    public FilterByProductCategoryAction(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String categoryName = e.getActionCommand();
        ProductCategory category = ProductCategory.fromCategoryName(categoryName);

        List<ShopProduct> products = ShopProductsManager.getInstance().getProducts();
        List<ShopProduct> filteredProducts = products.stream()
                .filter(shopProduct -> shopProduct.getCategory().equals(category))
                .toList();

        UserContentCreator.showInformationByFilteredProducts(filteredProducts, mainWindow);
    }
}
