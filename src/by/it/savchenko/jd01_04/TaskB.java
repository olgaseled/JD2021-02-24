package by.it.savchenko.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String [] worker = new String[n];
        int [][]salaries = new int[n][4];
        for (int i = 0; i < worker.length; i++) {
            String d = scanner.next();
            worker[i] = d;
       }

        for (int i = 0; i < worker.length; i++) {
          System.out.println("Введите зарплату для " + worker[i]);
            for (int j = 0; j < salaries.length+1; j++) {
                int salary = scanner.nextInt();
                salaries[i][j] = salary;
                System.out.println(salary);

            }

        }
//
        }

    }


//            //System.out.println("Зарплата Петрова" + x);
//       }
//        String [][] salary = new String[n][4];
//       for (int i = 0; i < salary.length; i++) {
//           int salarya = scanner.nextInt();
//           System.out.println(worker[i]);
//
//        }
//
//
//
//
//    }
//}
