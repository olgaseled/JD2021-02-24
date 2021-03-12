package by.it.seledtsova.jd01_04;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        buildOneDimArray(s);
    }

    static void printMulTable() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);//формирует из строки line массив вещественных чисел
        double start = array[0];
        double finish = array[array.length - 1];
        InOut.printArray(array, "V", 5); //выводит в 5 колонок этот массив с названием Vи индексами (тоже InOut)
        Helper.sort(array); // сортирует этот массив по возрастанию (см. Helper.sortв jd01_03Задание B)
        InOut.printArray(array, "V", 4); //еще раз выводит его (см. InOut), но уже в 4
        for (int i = 0; i < array.length; i++) {
            if (array[i] == start) {
                System.out.println("Index of first element=" + i);//Index of first element=2
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == finish) {
                System.out.println("Index of last element=" + i);//Index of last element=7
                break;
            }
        }
    }
}



