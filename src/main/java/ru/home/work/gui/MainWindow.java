package ru.home.work.gui;

import ru.home.work.shop.domain.ProductCategory;
import ru.home.work.gui.actions.FilterByProductCategoryAction;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public final static int WIDTH = 1280;
    public final static int HEIGHT = 768;
    private final static String TITLE = "Каталог";
    private static final int INPUT_FIELD_SIZE = 10;
    private static final String SEARCH_BY_PRICE_TEXT = "Искать по цене:";
    private static final String SEARCH_BY_KEY_WORD_TEXT = "Искать по названию:";

    private JPanel contentPane;
    private JPanel controlPanel;
    private JPanel flexibleUserContentPanel;
    private JTextField priceInput;
    private JTextField keyWordInput;

    public MainWindow() {
        super(TITLE);
        initialize();
    }

    private void initialize() {
        setDefaultSettings();

        createMainContent();

        createUserContent();
    }

    private void setDefaultSettings() {
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    private void createMainContent() {
        contentPane = ContentCreator.createMainContentPane();

        controlPanel = ContentCreator.createProductControlPanel();

        JPanel buttonsPanel1 = ContentCreator.createPanelWithGridLayout();
        JButton meat = new JButton(ProductCategory.MEAT.getCategoryName());
        FilterByProductCategoryAction filterByProductCategoryAction = new FilterByProductCategoryAction(this);
        meat.addActionListener(filterByProductCategoryAction);

        JButton poultry = new JButton(ProductCategory.POULTRY.getCategoryName());
        poultry.addActionListener(filterByProductCategoryAction);

        JButton dairy = new JButton(ProductCategory.DAIRY.getCategoryName());
        dairy.addActionListener(filterByProductCategoryAction);

        buttonsPanel1.add(meat);
        buttonsPanel1.add(poultry);
        buttonsPanel1.add(dairy);

        controlPanel.add(buttonsPanel1);

        JPanel buttonsPanel2 = ContentCreator.createPanelWithGridLayout();
        JButton vegetablesAndFruits = new JButton(ProductCategory.VEGETABLES_AND_FRUITS.getCategoryName());
        vegetablesAndFruits.addActionListener(filterByProductCategoryAction);
        JButton sweets = new JButton(ProductCategory.SWEETS.getCategoryName());
        sweets.addActionListener(filterByProductCategoryAction);
        JButton bakery = new JButton(ProductCategory.BAKERY.getCategoryName());
        bakery.addActionListener(filterByProductCategoryAction);

        buttonsPanel2.add(vegetablesAndFruits);
        buttonsPanel2.add(sweets);
        buttonsPanel2.add(bakery);
        controlPanel.add(buttonsPanel2);

        JPanel searchByKeyWordPanel = ContentCreator.createPanelWithGridLayout();
        searchByKeyWordPanel.add(ContentCreator.createText(SEARCH_BY_KEY_WORD_TEXT));
        keyWordInput = ContentCreator.createInputField(INPUT_FIELD_SIZE);
        searchByKeyWordPanel.add(keyWordInput);
        searchByKeyWordPanel.add(ContentCreator.createFilterByKeyWordButtonWithActionListener(this));

        JPanel priceFilterPanel = ContentCreator.createPanelWithGridLayout();
        priceFilterPanel.add(ContentCreator.createText(SEARCH_BY_PRICE_TEXT));
        priceInput = ContentCreator.createInputField(INPUT_FIELD_SIZE);
        priceFilterPanel.add(priceInput);
        priceFilterPanel.add(ContentCreator.createFilterByPriceButtonWithActionListener(this));

        controlPanel.add(searchByKeyWordPanel);
        controlPanel.add(priceFilterPanel);
        controlPanel.add(new JPanel(new FlowLayout()));
        controlPanel.add(new JPanel(new FlowLayout()));
        controlPanel.add(new JPanel(new FlowLayout()));
        controlPanel.add(new JPanel(new FlowLayout()));
        controlPanel.add(new JPanel(new FlowLayout()));
        controlPanel.add(new JPanel(new FlowLayout()));
        contentPane.add(controlPanel);
        this.setContentPane(contentPane);
    }

    private void createUserContent() {
        flexibleUserContentPanel = ContentCreator.createPanelWithBoxLayout();
        contentPane.add(flexibleUserContentPanel);
    }


    @Override
    public JPanel getContentPane() {
        return contentPane;
    }

    public JPanel getControlPanel() {
        return controlPanel;
    }

    public JPanel getFlexibleUserContentPanel() {
        return flexibleUserContentPanel;
    }

    public JTextField getKeyWordInput() {
        return keyWordInput;
    }

    public JTextField getPriceInput() {
        return priceInput;
    }
}
