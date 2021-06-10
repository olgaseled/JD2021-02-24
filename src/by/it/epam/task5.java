package by.it.epam;

import java.util.Scanner;

/*
Ввести число от 1 до 12. Вывести на консоль
название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.
 */
public class task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberMonth = scanner.nextInt();
        if (numberMonth>=1 && numberMonth<=12) {
            switch (numberMonth) {
                case 1:
                    System.out.println("January");
                    break;
                case 2:
                    System.out.println("February");
                    break;
                case 3:
                    System.out.println("Match");
                    break;
                case 4:
                    System.out.println("April");
                    break;
                case 5:
                    System.out.println("May");
                    break;
                case 6:
                    System.out.println("June");
                    break;
                case 7:
                    System.out.println("July");
                    break;
                case 8:
                    System.out.println("August");
                    break;
                case 9:
                    System.out.println("September");
                    break;
                case 10:
                    System.out.println("October");
                    break;
                case 11:
                    System.out.println("November");
                    break;
                case 12:
                    System.out.println("December");
                    break;
            }
        } else
              System.out.println("The month does not exist");
            }

        }


