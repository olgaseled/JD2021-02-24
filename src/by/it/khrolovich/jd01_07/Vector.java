package by.it.khrolovich.jd01_07;

import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {
    private final double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector otherVector) {
        this.value = otherVector.value;
    }

    public Vector(String s) {

        String[] split = s.trim().replaceAll("\\s+", "")
                .replace("{", "").replace("}", "").split(",");


        double[] arrayOfS = new double[split.length];

        for (int i = 0; i < split.length; i++) {
            arrayOfS[i] = Double.parseDouble(split[i]);
        }
        this.value = arrayOfS;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");

        for (double v : value) {
            stringJoiner.add(Double.toString(v));//TODO посмотреть второй вариант
        }

        return stringJoiner.toString();

    }

}
