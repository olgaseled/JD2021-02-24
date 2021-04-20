package by.it.savchenko.jd02_04;

import java.util.Arrays;
import java.util.StringJoiner;

public class Vector extends by.it.savchenko.jd02_04.Var {


    public double[] getValue() {
        return value;
    }

    public final double[] value;


    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        this(vector.value);
    }


    public Vector(String strVector) {
        //1.0,2.343,987.0
        String[] strArray = strVector.trim()
                .replaceAll("\\s+", "")
                .replace("{", "")
                .replace("}", "")
                .split(",");
        value = new double[strArray.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(strArray[i]);
        }
    }

    @Override
    public by.it.savchenko.jd02_04.Var add(by.it.savchenko.jd02_04.Var other) throws CalcException {
        if (other instanceof by.it.savchenko.jd02_04.Scalar) {
            double secondScalar = ((by.it.savchenko.jd02_04.Scalar) other).getValue();
            double[] resultVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] += secondScalar;
            }
            return new Vector(resultVector);
        }

        if (other instanceof Vector) {
            double[] secondVector = ((Vector) other).value;
            double[] resultVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] += secondVector[i];
            }
            return new Vector(resultVector);
        }
        return super.add(other);
    }

    public by.it.savchenko.jd02_04.Var sub(by.it.savchenko.jd02_04.Var other) throws CalcException {
        if (other instanceof by.it.savchenko.jd02_04.Scalar) {
            double secondScalar = ((by.it.savchenko.jd02_04.Scalar) other).getValue();
            double[] resultVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] -= secondScalar;
            }
            return new Vector(resultVector);
        }

        if (other instanceof Vector) {
            double[] secondVector = ((Vector) other).value;
            double[] resultVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] -= secondVector[i];
            }
            return new Vector(resultVector);
        }
        return super.sub(other);
    }

    public by.it.savchenko.jd02_04.Var mul(by.it.savchenko.jd02_04.Var other) throws CalcException {
        if (other instanceof by.it.savchenko.jd02_04.Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((by.it.savchenko.jd02_04.Scalar) other).getValue();
            }
            return new Vector(res);
        }
        if (other instanceof Vector) {
            double sum = 0;
            for (int i = 0; i < value.length; i++) {
                sum += value[i] * ((Vector) other).value[i];
            }
            return new by.it.savchenko.jd02_04.Scalar(sum);
        }
        return super.sub(other);
    }

    public by.it.savchenko.jd02_04.Var div(by.it.savchenko.jd02_04.Var other) throws CalcException {
        if (other instanceof by.it.savchenko.jd02_04.Scalar) {
            double secondScalar = ((by.it.savchenko.jd02_04.Scalar) other).getValue();
            double[] resultVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] /= secondScalar;
            }
            return new Vector(resultVector);
        }

        if (other instanceof Vector) {
            double[] secondVector = ((Vector) other).value;
            double[] resultVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] /= secondVector[i];
            }
            return null;//TODO div Vector by zero
        }
        return super.div(other);
    }


    @Override
    public String toString() {
        // {1.0, 3.5, 5.8}


        StringBuilder strVector = new StringBuilder("{");
        String delimiter = "";
        for (double v : value) {
            strVector.append(delimiter).append(v);
            delimiter = ", ";
        }
        strVector.append("}");


        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        for (Double v : value) {
            stringJoiner.add(v.toString());
        }
        return stringJoiner.toString();
    }
}
