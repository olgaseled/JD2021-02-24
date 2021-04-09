package by.it.kirichenko.jd02_03;

import java.util.HashMap;
import java.util.Map;

public class Product {
    private Map<String, String> specificProduct = new HashMap<>();

    Product(String name, String price){
        specificProduct.put(name, price);
    }

    Map getProduct(String name) {
        return this.specificProduct;
    }

    void setProduct(String name, String price) {
        specificProduct.put(name, price);
    }
}
