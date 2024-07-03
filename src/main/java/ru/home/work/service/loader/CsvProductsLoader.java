package ru.home.work.service.loader;

import ru.home.work.service.util.ProductsParser;
import ru.home.work.shop.domain.ProductCategory;
import ru.home.work.shop.domain.ShopProduct;

import java.util.ArrayList;
import java.util.List;

public class CsvProductsLoader implements ProductsLoader {
    private final ProductsParser productsParser;

    public CsvProductsLoader(ProductsParser productsParser) {
        this.productsParser = productsParser;
    }

    @Override
    public List<ShopProduct> loadProducts() {
        List<Product> products = productsParser.loadProducts();
        return mapProductsToShopProducts(products);
    }

    private List<ShopProduct> mapProductsToShopProducts(List<Product> products) {
        List<ShopProduct> shopProducts = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            ShopProduct shopProduct = new ShopProduct();
            shopProduct.setId(product.getId());
            shopProduct.setCount(product.getCount());
            shopProduct.setName(product.getName());
            shopProduct.setPrice(product.getPrice());
            shopProduct.setProducer(product.getProducer());
            shopProduct.setPromotion(product.isPromotion());

            String category = product.getCategory();
            ProductCategory shopCategory = ProductCategory.valueOf(category);

            shopProduct.setCategory(shopCategory);
            shopProducts.add(shopProduct);
        }
        return shopProducts;
    }
}
