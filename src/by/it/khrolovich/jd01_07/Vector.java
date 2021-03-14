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


        Pattern compile = Pattern.compile("[0-9]\\.?");
        Matcher matcher = compile.matcher(s);
        int i = 0;

        while (matcher.find()){
            i++;
        }
        double[] arrayOfS = new double[i];
        int j = 0;
        int start = 0;
        while (matcher.find(start)){
            arrayOfS[j] = Double.parseDouble(matcher.group());
            j++;
            start = matcher.end();
        }


        this.value = arrayOfS;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");

       for (Double v : value) {
            stringJoiner.add(v.toString());
        }

        return stringJoiner.toString();


    }


}
