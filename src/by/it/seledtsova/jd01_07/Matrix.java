package by.it.seledtsova.jd01_07;

import java.util.Arrays;

public class  Matrix extends Var {

    private final double[][] arrayValues;

    @Override
    public String toString() {
        return "Matrix{" +
                "arrayValue=" + Arrays.toString(arrayValues) +
                '}';
    }

    Matrix (double[][] arrayValue ) { // 1 конструктор на вход принемает некоторый массив
        this.arrayValues= arrayValue;

    }

    Matrix(Matrix matrix) {
        this.arrayValues = matrix.arrayValues;
    }


}

