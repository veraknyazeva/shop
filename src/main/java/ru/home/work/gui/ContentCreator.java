package ru.home.work.gui;

import ru.home.work.gui.actions.AddToBasketAction;
import ru.home.work.gui.actions.FilterByKeyWordAction;
import ru.home.work.gui.actions.FilterByPriceAction;
import ru.home.work.gui.actions.LookUpBasketAction;
import ru.home.work.shop.domain.ShopProduct;
import ru.home.work.shop.domain.WareHouseProduct;

import javax.swing.*;
import java.awt.*;

public class ContentCreator {
    private static final String PAY = "Оплатить";

    public static JPanel createMainContentPane() {
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));
//        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.setLayout(new GridLayout());
        return contentPane;
    }

    public static JPanel createProductControlPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createCompoundBorder());
        return panel;
    }

    public static JPanel createPanelWithGridLayout() {  //DRY
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout());
        return panel;
    }

    public static Component createText(String text) { //DRY
        TextField textField = new TextField(text);
        textField.setEditable(false);
        return textField;
    }

    public static JTextField createInputField(int size) {
        return new JTextField(size);
    }

    public static Component createFilterByPriceButtonWithActionListener(MainWindow mainWindow) {
        JButton filterByPriceButton = new JButton(FilterByPriceAction.SEARCH);
        filterByPriceButton.addActionListener(new FilterByPriceAction(mainWindow));
        return filterByPriceButton;
    }

    public static Component createFilterByKeyWordButtonWithActionListener(MainWindow mainWindow) {
        JButton filterByPriceButton = new JButton(FilterByKeyWordAction.SEARCH);
        filterByPriceButton.addActionListener(new FilterByKeyWordAction(mainWindow));
        return filterByPriceButton;
    }

    public static JButton createAddToBasketButton(WareHouseProduct shopProduct, MainWindow mainWindow) {
        JButton addToBasket = new JButton(AddToBasketAction.ADD_TO_BASKET);
        addToBasket.addActionListener(new AddToBasketAction(mainWindow, shopProduct));
        return addToBasket;
    }

    public static JPanel createPanelWithBoxLayout() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        return panel;
    }

    public static Component createTextWithRedColor(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.RED);
        return label;
    }

    public static Component createBasketButton(MainWindow mainWindow) {
        JButton basket = new JButton(LookUpBasketAction.BASKET);
        basket.addActionListener(new LookUpBasketAction(mainWindow));
        return basket;
    }

    public static Component createOrderButton() {
        JButton basket = new JButton(PAY);
        return basket;
    }
}
