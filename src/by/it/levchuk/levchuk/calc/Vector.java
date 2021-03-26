package by.it.levchuk.levchuk.calc;

import java.util.Arrays;

public class Vector extends Var {
    private final double[] values;

    Vector(double[] values) {
        this.values = values;
    }

    Vector(Vector strVector) {
        this.values = strVector.values;
    }

    Vector(String strVector) {
        String[] strArray = strVector.trim()
                .replaceAll("\\s+", "")
                .replace("{", "")
                .replace("}", "")
                .split(",");
        values = new double[strArray.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Double.parseDouble(strArray[i]);
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(values, values.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(values, values.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).values[i];
            }
            return new Vector(res);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(values, values.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(values, values.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).values[i];
            }
            return new Vector(res);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(values, values.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        if (other instanceof Vector) {
            if (this.values.length == ((Vector) other).values.length) {
                double sum = 0;
                for (int i = 0; i < this.values.length; i++) {
                    sum = sum + this.values[i] * ((Vector) other).values[i];
                }
                return new Scalar(sum);
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(values, values.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return Arrays.toString(values).replace("[", "{").replace("]", "}");
    }
}