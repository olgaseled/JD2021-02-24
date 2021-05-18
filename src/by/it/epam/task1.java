package by.it.epam;

import java.util.Scanner;

/*
2.Отобразить в окне консоли аргументы командной строки в обратном порядке.
 */
public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String consoleEnter = scanner.nextLine();
StringBuilder stringBuilder=new StringBuilder(consoleEnter);
        System.out.println(stringBuilder.reverse().toString());
    }
}
