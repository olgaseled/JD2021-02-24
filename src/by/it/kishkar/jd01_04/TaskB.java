package by.it.kishkar.jd01_04;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        String[] name = new String[n];
        for (int i = 0; i < name.length; i++) {
            name[i]= sc.next();
        }
        int[][] salary= new int[n][4];
        for (int i = 0; i < salary.length; i++) {
            System.out.println("Ввод зп для " + name[i]);
            for (int j = 0; j < salary[0].length; j++) {
                salary[i][j] = sc.nextInt();
            }

        }
        int[] sum =new int[n];
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < salary[0].length; j++) {
                sum[i] += salary[i][j];
            }
        }
        double total= (int) 0.0000;
        for (int i = 0; i < sum.length; i++) {
                            total +=sum[i];


        }
        double totalq= (double) (total/n/4);

        System.out.println ("-".repeat(65));
       System.out.format("%-12s%-12s%-12s%-12s%-12s%-12s", "Фамилия","Квартал1", "квартал2", "Квартал3","Квартал4", "Итого");
        System.out.println ("\n"+"-".repeat(65));
        System.out.format("%8s:    %-12d%-12d%-12d%-12d%-12d\n", name[0], salary[0][0], salary[0][1], salary[0][2], salary[0][3], sum[0]);
        System.out.format("%8s:    %-12d%-12d%-12d%-12d%-12d\n", name[1], salary[1][0], salary[1][1], salary[1][2], salary[1][3], sum[1]);
        System.out.format("%8s:    %-12d%-12d%-12d%-12d%-12d\n", name[2], salary[2][0], salary[2][1], salary[2][2], salary[2][3], sum[2]);
        System.out.println ("-".repeat(65));
        System.out.println(total);
        System.out.printf("%.4f", totalq);
    }

}
