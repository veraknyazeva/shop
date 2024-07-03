package ru.home.work.service.loader;

import ru.home.work.shop.domain.ShopProduct;

import java.util.List;

public interface ProductsLoader {
    List<ShopProduct> loadProducts();
}
