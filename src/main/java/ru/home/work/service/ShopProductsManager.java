package ru.home.work.service;

import ru.home.work.service.loader.CsvProductsLoader;
import ru.home.work.service.loader.ProductsLoader;
import ru.home.work.service.util.ProductsParser;
import ru.home.work.shop.domain.ShopProduct;

import java.util.List;

public class ShopProductsManager {
    private static ShopProductsManager instance = null;
    private final List<ShopProduct> products;


    private ShopProductsManager(ProductsLoader loader) {
        this.products = loader.loadProducts();
    }

    public static ShopProductsManager getInstance() {
        if (instance == null) {
            instance = new ShopProductsManager(new CsvProductsLoader(new ProductsParser()));
        }
        return instance;
    }

    public List<ShopProduct> getProducts() {
        return products;
    }
}
