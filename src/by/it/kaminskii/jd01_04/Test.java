package by.it.kaminskii.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

    }
        static void buildOneDimArray(String line) {
            double[] array = InOut.getArray(line);
            double start = array[0];
            double last = array[array.length - 1];
            InOut.printArray(array, "V", 5);
            Helper.sort(array);
            InOut.printArray(array, "V", 4);
            for (int i = 0; i < array.length; i++) {
                if (array[i] == start) {
                    System.out.println("Index of first element=" + i);
                    break;
                }
            }
        }
        static void quickSort(int[] array, int min, int max){
            if (array.length == 0)
                return;
            if(min >= max)
                return;
            int mid = min + (max - min) / 2;
            int main = array[mid];

        }
    }












//        Scanner sc=new Scanner(System.in);
//        int n = sc.nextInt();
//        String[] name = new String[n];
//        for (int i = 0; i < name.length; i++) {
//            name[i]= sc.next();
//        }
//        int[][] salary= new int[n][4];
//        for (int i = 0; i < salary.length; i++) {
//            System.out.println("Введите зарплату для " + name[i]);
//            for (int j = 0; j < salary[0].length; j++) {
//                salary[i][j] = sc.nextInt();
//            }
//        }
//        int[] salarySumm =new int[n];
//        for (int i = 0; i < salarySumm.length; i++) {
//            for (int j = 0; j < salary[0].length; j++) {
//                salarySumm[i]+= salary[i][j] ;
//            }
//        }
//        System.out.println("-".repeat(100) + '\n' + "Фамилия  Квартал1  Квартал2  Квартал3  Квартал4  Итого");
//        System.out.println("-".repeat(100));
//        for (int i = 0; i < salary.length; i++) {
//            System.out.printf("%10s" , name[i]+':'+ " ");
//            for (int j = 0; j < salary[0].length; j++) {
//                System.out.printf("%-10d" ,salary[i][j]);
//            }
//            System.out.printf("%-10s%s" ,salarySumm[i], '\n');
//        }
//        int result = 0;
//        for (int i = 0; i <salarySumm.length; i++) {
//            result += salarySumm[i];
//
//
//        }double middle =(double) result / ((double) salary.length * salary[0].length);
//        System.out.printf("%100s%s%10s%10d%s%10s%10.4f%n" ,"-".repeat(100),'\n', "Итого",result,'\n',"Средняя",middle);
//
//        }
//    }
