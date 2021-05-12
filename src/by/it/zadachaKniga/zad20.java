package by.it.zadachaKniga;

import java.util.Arrays;

public class zad20 {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = ((int) (Math.random() * 20 + 1));
        }
            System.out.println(Arrays.toString(array));
            int max=0;
            int index=0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] > max) {
                    max=array[i];
                    index=i;
                }
            }
            System.out.println("Max element= "+max);
        System.out.println("Index of max element is number "+index);
        }
    }

