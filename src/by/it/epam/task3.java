package by.it.epam;

import java.util.Arrays;

/*
3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
 */
public class task3 {
    public static void main(String[] args) {
        int[] arrayInt = new int[10];
        for (int i = 0; i < arrayInt.length; i++) {

            arrayInt[i] = (int) (Math.random() * 10);
               }
        System.out.println(Arrays.toString(arrayInt));
        for (int i = 0; i < arrayInt.length; i++) {
            System.out.println(arrayInt[i]);

        }
    }

}
