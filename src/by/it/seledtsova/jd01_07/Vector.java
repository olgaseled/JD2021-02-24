package by.it.seledtsova.jd01_07;

import java.util.StringJoiner;

public class Vector extends Var {

    private final double[] value;

    Vector(double[] value) { // 1 конструктор на вход принемает некоторый массив
        this.value = value;
    }

    Vector(Vector stringVector) {
        this.value = stringVector.value;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{"); // создали стринг билдер и обьявили, что первый разделитель у нас пустой
        String delimiter = ""; //  первый разделитель будет пустой
        for (double element:value) {          // переберем все элементы в массиве  value
            sb.append(delimiter).append(element); // будем печатать сразу разделитель , а за ним элемент
            delimiter = ", ";               // после первого числа разделитель заменим на запятую  и пробел
        }                                   // в итоге все след элементу будут размедять запятой с пробелом
        sb.append("}");
        return sb.toString();
    }

    public Vector(String stringValue) {
        String[] arrayString = stringValue.replaceAll("[{} ]+", "").trim().split(",");
        double[] result = new double[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            result[i]=Double.parseDouble(arrayString[i]);
        }
        this.value = result;

    }
}







