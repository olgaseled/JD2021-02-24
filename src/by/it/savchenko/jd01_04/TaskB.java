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
//        System.out.println("3\n" +
//                "Ivanov\n" +
//                "Petrov\n" +
//                "Sidorov\n" +
//                "11 11 13 15\n" +
//                "15 16 17 18 \n" +
//                "19 20 11 12 \n"+
//                "178"
//                +"14"+"833");
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
