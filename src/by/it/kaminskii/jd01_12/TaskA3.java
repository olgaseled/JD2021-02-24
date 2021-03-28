package by.it.kaminskii.jd01_12;/* created by Kaminskii Ivan
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> res = new ArrayList<>();
        int pos = 0;
        while (true) {
            String word = scanner.next();
            if (word.equals("end")) {
                break;
            }
            Integer value = Integer.valueOf(word);
            if (value < 0) {
                res.add(value);
            } else if (value == 0) {
                res.add(pos, value);
            } else {
                res.add(pos++, value);
            }
        }
        System.out.println(res);
    }
}