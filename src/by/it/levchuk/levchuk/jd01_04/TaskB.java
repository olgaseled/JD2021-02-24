package by.it.levchuk.levchuk.jd01_04;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.Scanner;

public class TaskB extends Stat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantityOfWorkers = scanner.nextInt();
        String[] name = new String[quantityOfWorkers];
        for (int i = 0; i < name.length; i++) {
            name[i] = scanner.next();
        }

        int[][] wPay = new int[quantityOfWorkers][QUARTER];
        for (int i = 0; i < wPay.length; i++) {
            System.out.println("Введите зарплату для " + name[i]);
            for (int j = 0; j < wPay[i].length; j++) {
                wPay[i][j] = scanner.nextInt();
            }
        }

        System.out.println("-".repeat(SYMBOL));
        System.out.printf("%-7s  %-10s%-10s%-10s%-10s%-5s%n",
                "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("-".repeat(Stat.SYMBOL));
        for (int i = 0; i < name.length; i++) {
            System.out.printf("%7s: %-10d%-10d%-10d%-10d%-5d%n",
                    name[i], wPay[i][0], wPay[i][1], wPay[i][2], wPay[i][3],
                    wPay[i][0] + wPay[i][1] + wPay[i][2] + wPay[i][3]);
        }

        System.out.println("-".repeat(Stat.SYMBOL));

        int totalWages = 0;
        for (int[] wages : wPay) {
            for (int i : wages) {
                totalWages = totalWages + i;
            }
        }
        System.out.printf("%-7s  %-10d%n", "Итого", totalWages);
        System.out.printf("%-7s  %-10.4f", "Средняя", (double) totalWages / (wPay.length * wPay[0].length));
    }
}
