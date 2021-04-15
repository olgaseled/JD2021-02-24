package by.it.zmushko.jd02_02;

import java.util.HashMap;

public class Products {

    public Products() {
        Products.groceryList();
    }

    static HashMap<String, Double> products = new HashMap<>();

    static void groceryList(){
        products.put("Milk", 2.12);
        products.put("Bread", 3.42);
        products.put("Beer", 5.21);
        products.put("Gun", 242.34);
        products.put("Cigarette", 6.23);
        products.put("Chocolate", 4.53);
        products.put("Ammo", 24.234);
        products.put("C4", 250.23);
    }

}
