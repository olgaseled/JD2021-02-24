package by.it.khrolovich.jd01_07;

import java.util.Arrays;
import java.util.StringJoiner;

public class Vector extends Var {
    private final double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    @Override
    public String toString() {
                /*
        StringBuilder strVector = new StringBuilder("{");
        String delimiter = "";
        for (int v : value) {
            strVector.append(delimiter).append(v);
            delimiter = ", ";
        }
        strVector.append("}");
        */
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        for (Double v : value) {
            stringJoiner.add(v.toString());
        }

        return stringJoiner.toString();

        //{1.0, 3.6, 5.5}
        //StringBuilder strVector = new StringBuilder("{");//строковое представление вектора
        //String delimiter = "";
        //for (int v : value) {
        //   strVector.append(delimiter).append(v);
        //    delimiter  =", ";
        //}
        //strVector.append("}");

        //return  strVector.toString();


        //return "Vector{" +
        //       "value=" + Arrays.toString(value) +
        //       '}';
    }
}
