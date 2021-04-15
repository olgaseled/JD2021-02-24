package by.it.kaminskii.new_project_jd_02;/* created by Kaminskii Ivan
 */

import java.util.HashMap;
import java.util.Map;

public class TestPrice {
   static Map<String, Double> priseList() {
        Map<String, Double> price = new HashMap<>(10, 0.75f);
        price.put("Bread", 1.5);
        price.put("Oil", 6.5);
        price.put("Chichen eggs", 1.0);
        price.put("Pasta", 10.0);
        price.put("Herring", 9.0);
        price.put("Buckwheat", 3.7);
        price.put("Bacon", 3.5);
        price.put("Ham", 8.0);
        price.put("Broccoli", 5.0);
        price.put("Cabbage", 3.1);
        return price;
    }
}
