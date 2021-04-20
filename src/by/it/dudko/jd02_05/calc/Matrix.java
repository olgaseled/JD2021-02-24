package by.it.dudko.jd02_05.calc;

import java.util.StringJoiner;



public class Matrix extends Var {

    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = Utils.copyMatrix(matrix.value);
    }

    public Matrix(String strMatrix) throws CalcException {
        this.value = Utils.castAsMatrixOfDoubles(strMatrix);
    }

    public double[][] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] result = Utils.copyMatrix(this.value);
            double addendum = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] += addendum;
                }
            }
            return new Matrix(result);
        }
        if (other instanceof Matrix) {
            double[][] addendum = ((Matrix) other).value;
            double[][] result = Utils.copyMatrix(this.value);
            if (result.length != addendum.length ||
                    result[0].length != addendum[0].length) {
                throw new CalcException(Language.INSTANCE.get(Messages.INCOHERENT_MATRICES));
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] += addendum[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            return this.add(other.mul(new Scalar("-1")));
        }
        if (other instanceof Matrix) {
            double[][] result = Utils.copyMatrix(this.value);
            double[][] subtraction = ((Matrix) other).value;
            if (result.length != subtraction.length ||
                    result[0].length != subtraction[0].length) {
                throw new CalcException(Language.INSTANCE.get(Messages.INCOHERENT_MATRICES));
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] -= subtraction[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] result = Utils.copyMatrix(this.value);
            double multiplier = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] *= multiplier;
                }
            }
            return new Matrix(result);
        }
        if (other instanceof Matrix) {
            double[][] left = this.value;
            double[][] right = ((Matrix) other).value;
            if (left[0].length != right.length) {
                throw new CalcException(Language.INSTANCE.get(Messages.INCOHERENT_MATRICES));
            }
            double[][] result = new double[left.length][right[0].length];
            for (int i = 0; i < left.length; i++) {
                for (int j = 0; j < right[0].length; j++) {
                    for (int k = 0; k < right.length; k++) {
                        result[i][j] = result[i][j] + left[i][k] * right[k][j];
                    }
                }
            }
            return new Matrix(result);
        }
        if (other instanceof Vector) {
            double[][] left = this.value;
            double[] right = ((Vector) other).getValue();
            if (left[0].length != right.length) {
                throw new CalcException(Language.INSTANCE.get(Messages.INCOHERENT_MATRICES));
            }
            double[] result = new double[left.length];
            for (int i = 0; i < left.length; i++) {
                for (int j = 0; j < right.length; j++) {
                    result[i] += left[i][j] * right[j];
                }
            }
            return new Vector(result);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        return super.div(other);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        for (double[] item : value) {
            stringJoiner.add(Utils.stringifyArray(item));
        }
        return stringJoiner.toString();
    }

}
