package by.it.dudko.jd02_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceList implements IPriceList {

    private final Map<String, Double> priceTable;
    StoreCurrency currency;
    List<String> productList = new ArrayList<>();

    public PriceList(String priceListLines, StoreCurrency currency) {
        priceTable = parseToMap(priceListLines);
        this.currency = currency;
        productList.addAll(priceTable.keySet());
    }

    @Override
    public List<String> getProductsList() {
        return productList;
    }

    @Override
    public StoreCurrency getCurrency() {
        return currency;
    }

    @Override
    public double getCostByName(String product) {
        return priceTable.get(product);
    }

    private Map<String, Double> parseToMap(String priceListLines) {
        Map<String, Double> price = new HashMap<>();
        try (
                BufferedReader reader = new BufferedReader(
                        new StringReader(priceListLines)
                )
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] productInfo = line.trim().split("\\s*:\\s*");
                price.put(productInfo[0], Double.parseDouble(productInfo[1]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return price;
    }
}
