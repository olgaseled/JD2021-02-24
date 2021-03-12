package by.it.kishkar.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main (String [] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("введите размер матрицы");
        int n=scanner.nextInt();
        int [][] arr=new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] =new int[n];
        }
        

    }
}
