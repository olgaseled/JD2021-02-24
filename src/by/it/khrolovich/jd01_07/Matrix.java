package by.it.khrolovich.jd01_07;

import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    private final double[][] value;

    public Matrix(double[][] doubles) {
        this.value = doubles;
    }

    public Matrix(Matrix otherMatrix) {
        this.value = otherMatrix.value;
    }

    public Matrix(String s) {
        double[][] MatrisOfS = new double[2][2];
        //s = s.replaceAll("\\s*\\{\\s*\\{\\s*", "");
        //s = s.replaceAll("\\s*\\}\\s*\\}\\s*", "");
        String[] split = s.split("\\s*\\}\\s*\\,\\s*\\{\\s*");
        int j = 0;//count of rows
        for (String s1 : split) {
            Pattern compile = Pattern.compile("[0-9]\\.?");
            Matcher matcher = compile.matcher(s1);
            int i = 0;//count of columns
            while (matcher.find()) {
                i++;
            }
            MatrisOfS[j] = new double[i];
            i = 0;
            int start = 0;
            while (matcher.find(start)) {
                MatrisOfS[j][i] = Double.parseDouble(matcher.group());
                i++;
                start = matcher.end();
            }
            j++;
        }


        this.value = MatrisOfS;
    }

    @Override
    public String toString() {

        StringJoiner stringJoiner2 = new StringJoiner(", ", "{", "}");
        for (double[] doubles : value) {
            StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
            for (Double v1 : doubles) {
                stringJoiner.add(v1.toString());
            }
            stringJoiner2.add(stringJoiner.toString());

        }

        return stringJoiner2.toString();
    }
}
