package by.it.kirichenko.jd01_03;

import java.util.Scanner;


public class Helper {
    static double findMin(double[ ] array){
        double minValue = array[0];
        for (double currentElement : array) {
            if(currentElement<minValue){
                minValue=currentElement;
            }
        }
        return minValue;
    }

    static double findMax(double[ ] array){
        double maxValue = array[0];
        for (double currentElement : array) {
            if(maxValue<currentElement){
                maxValue=currentElement;
            }
        }
        return maxValue;
    }

    static void sort(double[ ] array){
        boolean swap;
        int last= array.length-1;
        do{
            swap=false;
            for (int j = 0; j < last; j++) {
                if (array[j] > array[j+1]) {
                    double buffer = array[j];
                    array[j] = array[j+1];
                    array[j+1]=buffer;
                    swap=true;
                }
            }
            last--;
        }
        while(swap);
        printArray(array);
    }

    static void printArray(double[] array){
        for (double value: array){
            System.out.print(value);
        }
        System.out.println();
    }

    ///static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
    static double[ ] mul(double[ ][ ] x, double[ ] y){
        double[] z=new double[x.length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                z[i]=z[i]+x[i][j]*y[j];
            }
        }
        return z;
    }

    static double[ ][ ] mul(double[ ][ ] x, double[ ][ ] y){
        double[][] z=new double[x.length][y[0].length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y[0].length; j++) {
                for (int k = 0; k < y.length; k++) {
                    z[i][j]=z[i][j]+x[i][k]*y[k][j];
                }
            }
        }
        return z;
    }
}
