package ru.home.work.shop.domain;

public enum ProductCategory {
    MEAT("МЯСО"),
    POULTRY("ПТИЦА"),
    DAIRY("МОЛОЧНЫЕ ПРОДУКТЫ"),
    VEGETABLES_AND_FRUITS("ОВОЩИ И ФРУКТЫ"),
    SWEETS("СЛАДКОЕ"),
    BAKERY("ВЫПЕЧКА");
    private final String categoryName;

    ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public static ProductCategory fromCategoryName(String category) {
        return switch (category) {
            case "МЯСО" -> ProductCategory.MEAT;
            case "ПТИЦА" -> ProductCategory.POULTRY;
            case "МОЛОЧНЫЕ ПРОДУКТЫ" -> ProductCategory.DAIRY;
            case "ОВОЩИ И ФРУКТЫ" -> ProductCategory.VEGETABLES_AND_FRUITS;
            case "СЛАДКОЕ" -> ProductCategory.SWEETS;
            case "ВЫПЕЧКА" -> ProductCategory.BAKERY;
            default -> null;
        };
    }

    public String getCategoryName() {
        return categoryName;
    }
}
