package by.it.khrolovich.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> res = new ArrayList<>();
        int posZero = 0;
        System.out.println();
        while (true) {
            String word = scanner.next();
            if (word.equals("end")) {
                break;
            }
            Integer integer = Integer.valueOf(word);
            if (integer < 0) {
                res.add(integer);
            } else if (integer == 0) {
                res.add(posZero, integer);//вставляем в эту же позицию -> разъедется
            } else if (integer > 0) {
                res.add(posZero++, integer);
            }
        }
        System.out.println(res);
    }
}
