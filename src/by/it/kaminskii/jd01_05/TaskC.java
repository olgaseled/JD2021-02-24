package by.it.kaminskii.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double[] array = new double[40];
        for (int i = 0; i < 40; i++) {
            for (double x = 5.33; x < 10; x += 0.9) {
                double z = pow(x * x + 4.5, 1.0 / 3);
                array[i] = z;
                System.out.printf("array[%2d] = %4f\n",i,array[i]);
                if(i!=39)
                    i++;
            }

        }
        int size = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]>3.5){
                size++;
            }
        }
        double[] arraysize =new double[size];
        for (int i = 0; i < arraysize.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[j]>3.5){
                    arraysize[i]=array[j];
                    continue;
                }
            }
        }
    }

    private static void step2() {
        int n = 0;
        int[] A = new int[31];

        for (int i = 0; i < A.length; i++) {

            double num = round(Math.random() * (450 - 103) + 1) + 103;
            A[i] = (int) num;
            System.out.print("элемент" + i + " " + A[i] + " ");
            //double l = ((A[i] * 10) / 100);
            if (((A[i] * 10) / 100) > i) {
                n++;
            }
        }
        int[] B = new int[n];
         for (int j = 0; j < B.length;){
             for (int i = 0; i < A.length; i++){
                if (((A[i] * 10) / 100) > i) {
                    B[j] = A[i];
                    System.out.println("элемент B" + j + " " + B[j] + " ");
                    j++;
                    continue;
                }
                continue;
            }
        }
        System.out.println("╔═══════════╦═══════════╦═══════════╦═══════════╦═══════════╗");
        for (int i = 0; i < A.length; i++){
            {for (int j = 0; j < 5; j++){
                System.out.printf("║ A[%-2d]=%-4d",i,A[i]);
                //("║ B[" + i + "]=" + B[i]+"  ");
            }
                System.out.println("║");
                if(i !=(A.length-1))
                    System.out.println("╠═══════════╬═══════════╬═══════════╬═══════════╬═══════════╣");
            }
        }
        System.out.println("╚═══════════╩═══════════╩═══════════╩═══════════╩═══════════╝");

         System.out.println("╔═══════════╦═══════════╗");
        for (int i = 0; i < B.length; i++){
            {for (int j = 0; j < 2; j++){
                System.out.printf("║ B[%-2d]=%-4d",i,B[i]);
                        //("║ B[" + i + "]=" + B[i]+"  ");
            }
                System.out.println("║");
                if(i !=(B.length-1))
                    System.out.println("╠═══════════╬═══════════╣");
            }
        }
        System.out.print("╚═══════════╩═══════════╝");
    }
}
