package by.it.seledtsova.zadacha;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Array1 {
        public static void main(String[] args) {
                ArrayList<String> arrayList = new ArrayList<>();
                Scanner scanner = new Scanner(System.in);
                // -4 -9
                while (true) {
                        String word = scanner.next();
                        arrayList.add(word);
                        if (word.equals("-9")) {
                                break;
                        }
                }
                ArrayList<Double> result = new ArrayList<Double>();
                for (String s : arrayList) {
                        result.add(Double.parseDouble(s));
                }
                Iterator<Double> iterator = result.iterator();
                double sum = 0;
                while (iterator.hasNext()){
                        Double element = iterator.next();
                        sum = sum + element;
                }
                double squareRoot = Math.sqrt(sum);
                System.out.println(result);
                System.out.println(sum);
                System.out.println(squareRoot);
        }
}



