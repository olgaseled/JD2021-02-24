package by.it.kirichenko.jd02_02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StoreWindow {
    private static final Map<String, Double> listProduct = new HashMap<>();

    public static void addProduct(String name, Double price) {
        listProduct.put(name, price);
    }

    public static  Map<String, Double> getRandomProduct() {
        int randomNumberProduct = Util.getRandom(0, listProduct.size() - 1);
        Iterator<Map.Entry<String, Double>> iterator = listProduct.entrySet().iterator();
        int i = 0;
        Map<String, Double> product= new HashMap<>();
        while (iterator.hasNext()) {
            Map.Entry<String, Double> entry = iterator.next();
            if(i++==randomNumberProduct){
                product.put(entry.getKey(), entry.getValue());
                break;
            }
        }
        return product;
    }

    public Double getProductPrice(String name) {
        return listProduct.get(name);
    }

    public Map<String, Double> getListProduct() {
        return listProduct;
    }
}
