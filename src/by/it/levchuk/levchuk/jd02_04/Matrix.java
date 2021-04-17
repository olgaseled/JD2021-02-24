package by.it.levchuk.levchuk.jd02_04;
/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.Arrays;

public class Matrix extends Var {

    private final double[][] value;

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = res[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector)
            return super.add(other);
        else if (other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).value.length) {
                double[][] res = new double[value.length][0];
                for (int i = 0; i < value.length; i++) {
                    res[i] = Arrays.copyOf(value[i], value[i].length);
                }
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res.length; j++) {
                        res[i][j] = res[i][j] + ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(res);
            } else return super.add(other);
        } return super.sub(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        return super.div(other);
    }

    public Matrix(double[][] value) {
        this.value = new double[value.length][0];
        for (int i = 0; i < value.length; i++) {
            this.value[i] = Arrays.copyOf(value[i], value[i].length);
        }
    }

    public Matrix(String strValue) {
        this(new double[][]{{1, 2}, {3, 4}});
    }

    @Override
    public String toString() {
        return Arrays.deepToString(value)
                .replace('[', '{')
                .replace(']', '}');
    }
}

