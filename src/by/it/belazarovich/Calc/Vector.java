package by.it.belazarovich.Calc;

import java.util.Arrays;
import java.util.StringJoiner;

public class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        this(vector.value);
    }

    public Vector(String strVector) {
        /*  //1.0,2.343,987.0


         */
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
    public Var add(Var other) throws CalkExeption {
        if (other instanceof Scalar) {
            double secondScalar = ((Scalar) other).getValue();
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

    @Override
    public Var sub (Var other) throws CalkExeption {
        if (other instanceof Scalar) {
            double secondScalar = ((Scalar) other).getValue();
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

    @Override
    public Var mul (Var other) throws CalkExeption {
        if (other instanceof Scalar) {
            double secondScalar = ((Scalar) other).getValue();
            double[] resultVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] *= secondScalar;
            }
            return new Vector(resultVector);
        }
        if (other instanceof Vector) {
            double res = 0;
            Arrays.copyOf(value, value.length);
            for (int i = 0; i < this.value.length; i++) {
                res += this.value[i] * ((Vector) other).value[i];
            }
            return new Scalar(res);
        }
        return super.mul(other);
    }
/*
        @Override
        public Var div (Var other){
            if (other instanceof Scalar) {
                double secondScalar = ((Scalar) other).getValue();
                double[] resultVector = Arrays.copyOf(value, value.length);
                for (int i = 0; i < resultVector.length; i++) {
                    resultVector[i] /= secondScalar;
                }
                return new Vector(resultVector);
            } else
                return super.div(other);
        }
        @Override
        public String toString()
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");

        for (Double v : value) {
            stringJoiner.add(v.toString());
        }
        return stringJoiner.toString();
    }}
 */

    @Override
    public Var  div(Var other) throws CalkExeption {
        if (other instanceof Scalar) {
            double divScalar = ((Scalar) other).getValue();
            double[] resultVector = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < resultVector.length; i++) {
                if (divScalar == 0) {
                    return super.div(other);
                }
                resultVector[i] /= divScalar;
            }
            return new Vector(resultVector);
        }

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
