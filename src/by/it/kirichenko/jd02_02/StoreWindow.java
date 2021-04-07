package by.it.kirichenko.jd02_02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StoreWindow {
    private static final Map<String, Double> listProduct = new HashMap<>();

    public static void addProduct(String name, Double price) {
        listProduct.put(name, price);
    }

    public static  String getRandomProduct() {
        int randomNumberProduct = Util.getRandom(0, listProduct.size() - 1);
        Iterator<Map.Entry<String, Double>> iterator = listProduct.entrySet().iterator();
        int i = 0;
        String nameProduct="";
        while (iterator.hasNext()) {
            Map.Entry<String, Double> entry = iterator.next();
            if(i++==randomNumberProduct){
                nameProduct=entry.getKey();
                break;
            }
        }
        return nameProduct;
    }

    public Double getProductPrice(String name) {
        return listProduct.get(name);
    }

    public Map<String, Double> getListProduct() {
        return listProduct;
    }
}
