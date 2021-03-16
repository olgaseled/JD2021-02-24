package by.it.papruga.jd01_08;

import java.util.Arrays;

public class Matrix extends Var {

    private double[][] value;

    public Matrix (double [][] value){

        this.value = new double [value.length][0];
        for (int i = 0; i < value.length; i++) {
            this.value[i]= Arrays.copyOf(value[i], value[i].length);

        }
    }
}
