package by.it.maksimova.jd02_04;

import java.util.Arrays;

public class Matrix extends Var {
    private final double [][] value;

    public Matrix(double[][] value){
        this.value=new double[value.length][0];
        for (int i = 0; i < value.length; i++) {
            this.value[i]= Arrays.copyOf(value[i], value[i].length);
        }
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "value=" + Arrays.toString(value) +
                '}';
    }
    public Matrix (String strValue){
        this (new double[][]{{1,2},{3,4}});
    }
}
