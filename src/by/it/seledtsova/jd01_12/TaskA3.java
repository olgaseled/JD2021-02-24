package by.it.seledtsova.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> result = new ArrayList<>();
        int posZero = 0;
        while (true) {
            String word = scanner.next(); // слова будут вводися, пока не будет слово "end"
            if (word.equals("end")) { //сравнении объектов между собой
                break;
            }
            Integer integer = Integer.valueOf(word); // будм сравнивать по значению
            if (integer < 0) {
                result.add(integer);
            } else if (integer == 0) {
                result.add(posZero, integer);
            } else {
                result.add(posZero++, integer);
            }
        }
            System.out.println(result);
        }
    }



