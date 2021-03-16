package by.it.dudko.jd01_08;

import java.util.StringJoiner;

class Utils {
    static String trimBraces(String strMatrix) {
        return strMatrix.trim().replace(" ", "").replaceAll("(^\\{)|(}$)", "");
    }


    static String[] splitToMatrixRows(String strMatrix) {
        return strMatrix.split("},\\{");
    }


    static String[] splitToRowItems(String strRow) {
        return strRow.split("\\s*,\\s*");
    }

    static String stringifyArray(double[] arr) {
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        for (Double item : arr) {
            stringJoiner.add(item.toString());
        }
        return stringJoiner.toString();
    }
}
