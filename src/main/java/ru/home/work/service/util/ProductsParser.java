package ru.home.work.service.util;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import ru.home.work.service.loader.Product;
import ru.home.work.shop.domain.ShopProduct;

import java.io.File;
import java.io.FileReader;
import java.util.List;

public class ProductsParser {
    private static final String[] COLUMN_MAPPING = {"id", "category", "name", "producer", "price", "count", "promotion"};
    private static final String FILE_NAME = "products.csv";
    private final File CSV = new File(this.getClass().getClassLoader().getResource(FILE_NAME).getFile());

    public List<Product> loadProducts() {
        return parseProductsCSV(COLUMN_MAPPING, CSV);
    }

    public static List<Product> parseProductsCSV(String[] columnMapping, File csvFile) {
        List<Product> goods = null;
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            ColumnPositionMappingStrategy<Product> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Product.class);
            strategy.setColumnMapping(columnMapping);
            CsvToBean<Product> csv = new CsvToBeanBuilder<Product>(reader)
                    .withMappingStrategy(strategy)
                    .build();
            goods = csv.parse();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return goods;
    }
}
