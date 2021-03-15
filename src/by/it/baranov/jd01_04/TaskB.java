package by.it.baranov.jd01_04;

import java.util.Scanner;

public class TaskB {




    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        String[] name = new String[s];
        for (int i = 0; i < name.length; i++) { name[i] = sc.next();

        }



           // System.out.println(Arrays.deepToString(lastNames));
            // Создаем двумерный массив
            Integer[][] graph;
            graph = new Integer[s][4];







            // Цикл по первой размерности (первые квадратные скобки)
            for (int i = 0; i < graph.length; i++) {System.out.print("Vvedite zarplatu");
                System.out.print(" "); System.out.print(name[i]); System.out.println();
                // Цикл по второй размерности (вторые квадратные скобки)
                for (int j = 0; j < graph[0].length; j++)

                    graph[i][j] = sc.nextInt();}


                    ;

            //System.out.println(" Vvedite zarplatu Petrov");
            //graph[i][j] = String.valueOf(scanner.nextInt());}}








            //System.out.println(Arrays.deepToString(graph));



            System.out.println();
            System.out.format("%-12s%-12s%-12s%-12s%-12s\n", name[0], graph[0][0], graph[0][1], graph[0][2], graph[0][3]);
            System.out.format("%-12s%-12s%-12s%-12s%-12s\n",name[1],graph[1][0],graph[1][1],graph[1][2],graph[1][3]);
            System.out.format("%-12s%-12s%-12s%-12s%-12s\n",name[2],graph[2][0],graph[2][1],graph[2][2],graph[2][3]);

           int sum;
           int res;
           sum=0;
           res=0;



        for (int i = 0; i < graph.length; i++) {
             sum = 0;
            //System.out.format("%7s: ", name[i]);
            for (int j = 0; j < graph[0].length; j++) {
                System.out.println( graph[i][j]);
                sum += graph[i][j];
               res += graph[i][j];;}

                System.out.println("sum"+sum);
            System.out.println("Total"+ res);}}}






