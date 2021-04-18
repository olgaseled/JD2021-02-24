package by.it.kaminskii.jd02_03;/* created by Kaminskii Ivan
 */

import java.util.HashMap;
import java.util.Map;

class Good extends Thread {
    static Map<String,Double> price(){
        Map<String,Double> price = new HashMap<>(10,0.75f);
        price.put("Bread",1.5);
        price.put("Oil",6.5);
        price.put("Chichen eggs",1.0);
        price.put("Pasta",10.0);
        price.put("Herring",9.0);
        price.put("Buckwheat",3.7);
        price.put("Bacon",3.5);
        price.put("Ham",8.0);
        price.put("Broccoli",5.0);
        price.put("Cabbage",3.1);
        return price;
    }

static void fillPrice(Map<String,Double> price) {
    price.put("one",1.5);
    price.put("two",6.5);
    price.put("three",1.0);
    price.put("four",10.0);
    price.put("five",9.0);
    price.put("six",3.7);
    price.put("seven",3.5);
    price.put("eight",8.0);
    price.put("nine",5.0);
    price.put("tehn",3.1);
}
}

