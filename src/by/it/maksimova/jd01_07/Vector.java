package by.it.maksimova.jd01_07;

import java.util.StringJoiner;

public class Vector extends Var {
    private final double[] value;

    Vector(double[] value) {
        this.value = value;
    }
    Vector(String strVector) {
        // 1. Удалить из строки скобки
        // 2. Удалить из строки пробелы
String string = strVector
        .replace("{", "")
        .replace("}", "")
        .replace(" ", "");

        // 3. Сделать сплит по запятой - будет масссив строк
        String [] strArray = string.split("[,]");
        // 4. Получить массив чисел (как в 3 задании)
        double [] numberArray= new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            numberArray[i]=Double.parseDouble(strArray[i]);
        }
        // 5. Можно заполнить value вектора
        this.value = numberArray;
    }

    Vector(Vector otherVector) {
        this.value= otherVector.value;
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
     /*
        StringBuilder strVector = new StringBuilder("{");
        String delimiter = "";
        for (int v : value) {
            strVector.append(delimiter).append(v);
            delimiter = ", ";
        }
        strVector.append("}");
        */



