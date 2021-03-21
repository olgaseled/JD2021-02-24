package by.it.kishkar.jd01_09;


import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    public double[] getValue () {return value;}

    Vector(double[] value) {
        this.value = value;

    }

    Vector(String str) {
        String[] strArray = str.trim().replaceAll("\\s+", "")
                .replace("{", "")
                .replace("}", "")
                .split(",");
        value = new double[strArray.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(strArray[i]);
        }

    }

    Vector(Vector vector) {
        this.value = vector.value;

    }

    public Vector(double resultVectorSumm) {
        super();
    }

    @Override  //СЛОЖЕНИЕ
    public Var add(Var other) {
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

    @Override   //ВЫЧИТАНИЕ
    public Var sub(Var other) {
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

    @Override   //ДЕЛЕНИЕ
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double secondScalar = ((Scalar) other).getValue();
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
        }
        return super.div(other);
    }

    @Override   //УМНОЖЕНИЕ
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double secondScalar = ((Scalar) other).getValue();
            double[] resultVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] *= secondScalar;
            }
            return new Vector(resultVector);
        }

        if (other instanceof Vector) {
            double[] secondVector = ((Vector) other).value;
            double[] resultVector = Arrays.copyOf(value, value.length);
            double resultVectorSummMul = 0;
            for (int i = 0; i < resultVector.length; i++) {
                resultVectorSummMul += resultVector[i] * secondVector[i];
            }
            return new Scalar(resultVectorSummMul);
        }
        return super.mul(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String del = "";
        for (double element : value) {
            sb.append(del).append(element);
            del = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
