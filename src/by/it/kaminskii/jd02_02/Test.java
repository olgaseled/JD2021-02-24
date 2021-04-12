package by.it.kaminskii.jd02_02;/* created by Kaminskii Ivan
 */

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<String> testList = new LinkedList<>();
        for (String key : price().keySet()) {
            testList.add(key);
        }
        String testString = testList.get(3);
        System.out.println(testList.get(Helper.randomValue(1,4)));
        System.out.println(testList);
    }
    static Map<String,Double> price(){
        Map<String,Double> price = new HashMap<>(10,0.75f);
        price.put("Bread",1.5);
        price.put("Oil",6.5);
        price.put("Chichen",1.0);
        price.put("Pasta",10.0);
        price.put("Herring",9.0);
        price.put("Buckwheat",3.7);
        price.put("Bacon",3.5);
        price.put("Ham",8.0);
        price.put("Broccoli",5.0);
        price.put("Cabbage",3.1);
        return price;
    }
}
