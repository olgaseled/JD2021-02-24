package by.it.seledtsova.jd01_07;

import java.util.StringJoiner;

public class Vector extends Var{


    private final double[] value;
    Vector(double[] value) { //мы создали двух потомков и он наследуется от класca var
        this.value = value;
    }

    Vector (Vector stringVector){
        this.value= stringVector.value;
    }


    @Override
    public String toString() {

        // {1.0, 3.5, 5.8}

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
    }
}

