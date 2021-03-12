package by.it.baranov.jd01_04;

import java.util.Scanner;

public class TaskB {


    private static Object pbsv;

    public static void main(String[] args) {
            // Объявим коснтанту для размера массива




            Scanner scanner = new Scanner(System.in);

            String[] lastNames;
            int v;


            Scanner in = new Scanner(System.in);
            v= in.nextInt();
            int m = 0;
            lastNames=new String[v];
            for (int i = 0; i < lastNames.length; i++) {lastNames[i] = scanner.nextLine();}
            // Цикл по второй размерности (вторые квадратные скобки)



           // System.out.println(Arrays.deepToString(lastNames));
            // Создаем двумерный массив
            String[][] graph;
            graph = new String[3][4];






            System.out.print("Vvedite zarplatu");
            System.out.print(" ");
            System.out.println(lastNames[0]);


            // Цикл по первой размерности (первые квадратные скобки)
            for (int i = 0; i < graph.length; i++) {
                // Цикл по второй размерности (вторые квадратные скобки)
                for (int j = 0; j < graph[i].length; j++) {

                    graph[i][j] = String.valueOf(scanner.nextInt());}
                break;}

            System.out.print("Vvedite zarplatu");
            System.out.print(" ");
            System.out.println(lastNames[1]);

            // Цикл по первой размерности (первые квадратные скобки)
            for (int i = 1; i < graph.length; i++) {
                // Цикл по второй размерности (вторые квадратные скобки)
                for (int j = 0; j < graph[i].length; j++) {

                    graph[i][j] = String.valueOf(scanner.nextInt());}
                break;}

            System.out.print("Vvedite zarplatu");
            System.out.print(" ");
            System.out.println(lastNames[2]);

            // Цикл по первой размерности (первые квадратные скобки)
            for (int i = 2; i < graph.length; i++) {
                // Цикл по второй размерности (вторые квадратные скобки)
                for (int j = 0; j < graph[i].length; j++) {

                    graph[i][j] = String.valueOf(scanner.nextInt());}
                break;}
            //System.out.println(" Vvedite zarplatu Petrov");
            //graph[i][j] = String.valueOf(scanner.nextInt());}}








            //System.out.println(Arrays.deepToString(graph));



            System.out.println();
            System.out.format("%-12s%-12s%-12s%-12s%-12s\n", lastNames[0], graph[0][0], graph[0][1], graph[0][2], graph[0][3]);
            System.out.format("%-12s%-12s%-12s%-12s%-12s\n",lastNames[1],graph[1][0],graph[1][1],graph[1][2],graph[1][3]);
            System.out.format("%-12s%-12s%-12s%-12s%-12s\n",lastNames[2],graph[2][0],graph[2][1],graph[2][2],graph[2][3]);

           int sum;

           // for (int i = 0; i < graph.length;) { sum=0;
                // Цикл по второй размерности (вторые квадратные скобки)
               // for (int j = 0; j < graph[i].length; j++) { sum =sum+ graph[0][j];

                  //  System.out.println("sum " + sum);

            }}



