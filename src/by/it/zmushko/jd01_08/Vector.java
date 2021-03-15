package by.it.zmushko.jd01_08;

import java.util.Arrays;

public class Vector extends Var {

    private final double[] values;

    Vector(double[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    Vector(Vector strVector) {
        this(strVector.values);
    }

    Vector(String strVector) {
        String changeString = strVector.replaceAll("[{}]", "").replaceAll(" ", "");
        String[] tempStringArray = changeString.split(",");
        double[] tempDoubleArray = new double[tempStringArray.length];
        for (int i = 0; i < tempStringArray.length; i++) {
            tempDoubleArray[i] = Double.parseDouble(tempStringArray[i]);
        }
        values = tempDoubleArray;
    }

    @Override
    public String toString() {
        return Arrays.toString(values).replace("[", "{").replace("]", "}");
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double secondScalar = ((Scalar) other).getValue();
            double[] resultVector = Arrays.copyOf(values, values.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] += secondScalar;
            }
            return new Vector(resultVector);
        }
        return super.add(other);
    }
}
