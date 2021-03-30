package by.it.maksimova.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int pos = 0;
        while (true) {
            String str = scanner.next();
            if (str.equals("end")) {
                break;
            }
                Integer number = Integer.valueOf(str);
                if (number < 0) {
                    list.add(number);
                } else if (number == 0) {
                    list.add(pos, number);
                } else if (number > 0) {

                    list.add(pos++, number); // почему pos++ перемещает число в начало списка?
                }
            }

        System.out.println(list);
        }

    }

