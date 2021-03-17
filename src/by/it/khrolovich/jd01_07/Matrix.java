package by.it.khrolovich.jd01_07;

import java.util.StringJoiner;

public class Matrix extends Var {
    private final double[][] value;

    public Matrix(double[][] doubles) {
        this.value = doubles;
    }

    public Matrix(Matrix otherMatrix) {
        this.value = otherMatrix.value;
    }

    public Matrix(String s) {

        s = s.trim().replaceAll("\\s+", "");//нет пробелов
        s = s.replace("{{", "").replace("}}", "");
        String[] Rows = s.split("\\}\\,\\{");

        double[][] MatrisOfS = new double[Rows.length][];
        int i = 0;
        for (String s1 : Rows) {
            String[] Collumns = s1.split(",");

            MatrisOfS[i] = new double[Collumns.length];

            for (int j = 0; j < Collumns.length; j++) {
                MatrisOfS[i][j] = Double.parseDouble(Collumns[j]);
            }
            i++;
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
