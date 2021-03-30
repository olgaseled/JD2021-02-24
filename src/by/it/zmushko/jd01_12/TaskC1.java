package by.it.zmushko.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        HashMap<Object, Object> firstMap = new HashMap<>();
        HashMap<Object, Object> secondResultMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int key = 0;
        while (true){
            String text = scanner.next();
            if (text.equals("end")){
                break;
            }
            key++;
            firstMap.put(key, text);
        }
        System.out.println(firstMap);
        for (Map.Entry<Object, Object> next : firstMap.entrySet()) {
            if (!secondResultMap.containsValue(next.getValue())) {
                secondResultMap.put(next.getKey(), next.getValue());
            }
        }
        System.out.println(secondResultMap);
    }
}
