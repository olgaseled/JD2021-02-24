package by.it.zmushko.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        int posMyZero = 0;
        while (true) {
            String next = scanner.next();
            if (next.equals("end")) {
                break;
            }
            Integer integer = Integer.valueOf(next);
            if (integer > 0) {
             list.add(posMyZero++, integer);
            } else if (integer == 0) {
                list.add(posMyZero, integer);
            } else {
                list.add(integer);
            }
        }
        System.out.println(list);
    }
}
