package by.it.zmushko.jd01_07;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Var var1 = new Scalar(9);
        Scalar var2 = new Scalar("123.123");
        Var var3 = new Scalar(var2);
        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);
        double[] array = {1, 2, 3};
        Vector vec4 = new Vector(array);
        Var vec5 = new Vector(vec4);
        Var vec6 = new Vector("{1.0, 2.0, 4.0}"); //str
        System.out.println(vec4);
        System.out.println(vec5);
        System.out.println(vec6);
        double[][] doubleArray = {{1.0, 2.0}, {3.0, 4.0}};
        Matrix matrix1 = new Matrix(doubleArray);
        Var matrix2 = new Matrix(matrix1);
        Var matrix3 = new Matrix("{{ 1.0, 2.0}, {3.0, 4.0}}");
        System.out.println(matrix1);
        System.out.println(matrix2);
        System.out.println("Test Matrix");
        System.out.println(matrix3);
    }
}
