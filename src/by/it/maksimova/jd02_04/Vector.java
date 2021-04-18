package by.it.maksimova.jd02_04;

import java.util.Arrays;
import java.util.StringJoiner;

public class Vector extends Var {
    public double[] getValue() {
        return value;
    }

    private final double[] value;

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Vector(String strVector) {
        // 1. Удалить из строки скобки
        // 2. Удалить из строки пробелы
        String string = strVector
                .replace("{", "")
                .replace("}", "")
                .replace(" ", "");

        // 3. Сделать сплит по запятой - будет масссив строк
        String[] strArray = string.split("[,]");
        // 4. Получить массив чисел (как в 3 задании)
        double[] numberArray = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            numberArray[i] = Double.parseDouble(strArray[i]);
        }
        // 5. Можно заполнить value вектора
        this.value = numberArray;
    }

    Vector(Vector otherVector) {
        this.value = otherVector.value;
    }


    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] resultVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] = resultVector[i] + ((Scalar) other).getValue();
            }
            return new Vector(resultVector);
        } else if (other instanceof Vector) {
            double[] resultVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] = resultVector[i] + ((Vector) other).value[i];
            }
            return new Vector(resultVector);
        } else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] resultVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] = resultVector[i] - ((Scalar) other).getValue();
            }
            return new Vector(resultVector);
        } else if (other instanceof Vector) {
            double[] resultVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] = resultVector[i] - ((Vector) other).value[i];
            }
            return new Vector(resultVector);
        } else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] resultVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] = resultVector[i] * ((Scalar) other).getValue();
            }
            return new Vector(resultVector);
        } else if (other instanceof Vector) {
            double sum = 0;
            for (int i = 0; i < value.length; i++) {
                sum += value[i] * ((Vector) other).value[i];
            }
            return new Scalar(sum);
        } else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] resultVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] = resultVector[i] * (1 / ((Scalar) other).getValue());
            }
            return new Vector(resultVector);
        } else if (other instanceof Vector) {
            double sum = 0;
            for (int i = 0; i < value.length; i++) {
                sum += value[i] / ((Vector) other).value[i];
            }
            return new Scalar(sum);
        } else
            return super.div(other);
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



