package by.it.zadachaKniga;


import java.util.Arrays;

public class zad18 {
    public static void main(String[] args) {
        int [] array =new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i]= (int)( Math.random()*20+1);

        }
        System.out.println(Arrays.toString(array));
        System.out.println(array[9]);
    }

}
