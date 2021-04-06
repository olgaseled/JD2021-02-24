package by.it.zmushko.jd01_12;

import java.util.HashMap;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int justCounter = 1;
        while (true) {
            String myText = scanner.next();
            String finalText = myText.replaceAll("[.,;:]", "");
            if (finalText.equals("end")) {
                break;
            }
            mapWithoutClonableElem(map, justCounter, finalText);
        }
        System.out.println(map);
    }

    private static void mapWithoutClonableElem(HashMap<String, Integer> map, int justCounter, String finalText) {
        if (!map.containsKey(finalText)) {
            map.put(finalText, justCounter);
        } else {
            int changeVal = map.get(finalText);
            changeVal++;
            map.put(finalText, changeVal);
        }
    }
}
