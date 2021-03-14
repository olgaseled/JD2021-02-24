/*Создайте в пакете by.it.familiya.jd01_02класс TaskA.
В методе mainвведите10 чисел с консоли в массив arrчерез объект типа Scanner. Пример: Scanner scanner=new Scanner(System.in);
В классе TaskAсоздайте статические методы
static voidstep1(int[] arr)
static voidstep2(int[] arr)
static voidstep3(int[] arr)
и вызовите их из метода main.Эти методырешают такие задачи:
1.Найти самое маленькое и самое большое число массива. Вывести на консоль найденные минимум и максимум в одну строку через пробел.
2.Вывести на консоль те числа, значение которых строго меньше среднегоарифметического(типа double) в этом массиве.
3.Найти и вывести номер (т.е. индекс) самого маленького числа. Если же таких чисел будет несколько, вывести все найденные индексы минимума через пробел в порядке убывания.
 */
package by.it.seledtsova.jd01_02;


import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scanner.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }

    private static void step1 (int[] mas) {
        int min= mas [0];
        int max = mas [0];
        for (int element : mas) {
            if (min > element) min = element;
            if (max < element) max = element;
        }
        System.out.println(min+" "+max);
            }


       private static void step2 (int [] mas) {
        double avg=0;
           for (int element: mas) {
               avg=avg+element;
           }
           avg=avg/mas.length;
           for (int element : mas) {
               if (element<avg)
                   System.out.print(element+ " ");
           }
    }

    private static void step3 (int [] mas ) {
        int min=mas [0];
        for (int element: mas ) {
        if (min > element) min = element;
        }
        for (int i= mas.length-1; i>=0 ; i--) {
        if (mas[i]==min)
        System.out.print(i+ " ");
}
    }
}