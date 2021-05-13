package by.it.zadachaKniga;

import java.util.Arrays;

public class zad21 {
    public static void main(String[] args) {

        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
        }
        System.out.println(Arrays.toString(array));
        int maxElement=array[0];
        int minElement=array[0];
        int indexMax=0;
        int indexMin=0;
        int sumBetweenMinMax = 0;
        for (int i = 0; i < array.length; i++) {
            if (maxElement < array[i]) {
                maxElement = array[i];
                indexMax = i;
            }
        }
            System.out.println("Max element = " + maxElement + " ,it index = " + indexMax);

        for (int i = 0; i < array.length; i++) {
              if (minElement > array[i]) {
                  minElement = array[i];
                 indexMin = i;
            }
        }
        System.out.println("Min element= " + minElement + " ,it index = " + indexMin);
        if (indexMin < indexMax) {
                for (int i = indexMin; i <= array[indexMax]; i++) {
                    sumBetweenMinMax = sumBetweenMinMax + array[i];
                }
                System.out.println(sumBetweenMinMax);

            } else if (indexMax < indexMin) {
                for (int i = indexMax; i <= array[indexMin]; i++) {
                    sumBetweenMinMax = sumBetweenMinMax+ array[i];
                }
                System.out.println(sumBetweenMinMax);
              }

            }
        }







