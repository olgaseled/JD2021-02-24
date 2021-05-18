package by.it.epam;

import java.util.Scanner;

// 1. Приветствовать любого пользователя при вводе его имени через командную строку.
public class task2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();
        System.out.println("Good morning");
    }

}
