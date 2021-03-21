package by.it.khrolovich.jd01_09;

import java.util.Arrays;
import java.util.StringJoiner;

public class Vector extends Var {
    private final double[] value;

    public double[] getValue() {
        return value;
    }

    /*  public Vector(double[] value) {
            this.value = value;
        }*/
    //если извне массив поменяется, то здесь ничего не поменятся, будет копия
    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    /*  public Vector(Vector otherVector) {
          this.value = otherVector.value;
      }*/
    //2ой вариант
    public Vector(Vector otherVector) {
        this(otherVector.value);
    }

    public Vector(String s) {
        String[] split = s.trim().replaceAll("\\s+", "")
                .replace("{", "").replace("}", "").split(",");


        double[] arrayOfS = new double[split.length];

        for (int i = 0; i < split.length; i++) {
            arrayOfS[i] = Double.parseDouble(split[i]);
        }
        this.value = arrayOfS;
    }


    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {

            double secondScalar = ((Scalar) other).getValue();
            double[] resultVector = Arrays.copyOf(value, value.length);

            /*for (int i = 0; i < value.length; i++) {
                value[i]+=secondScalar;
            }*/
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] += secondScalar;
            }
            return new Vector(resultVector);
        }
        //далее если InstanceOf Vector
        if (other instanceof Vector) {
            double[] secondVector = ((Vector) other).value;
            double[] resultVector = Arrays.copyOf(value, value.length);
            if (resultVector.length != secondVector.length){
                return super.add(other);
            }
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] += secondVector[i];
            }
            return new Vector(resultVector);
            //или одной строкой
        }
        //нельзя складывать вектор с матрицей
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] resultVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] -= ((Scalar) other).getValue();
            }
            return new Vector(resultVector);
        }
        if (other instanceof Vector) {
            double[] secondVector = ((Vector) other).value;
            double[] resultVector = Arrays.copyOf(value, value.length);
            if (resultVector.length != secondVector.length){
                return super.add(other);
            }
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] -= secondVector[i];
            }
            return new Vector(resultVector);
        }

        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {

            double[] resultVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] *= ((Scalar) other).getValue();
            }
            return new Vector(resultVector);
        }
        if (other instanceof Vector) {
            double[] currentVector = Arrays.copyOf(value, value.length);
            double[] secondVector = ((Vector) other).value;
            if (currentVector.length != secondVector.length){
                return super.add(other);
            }
            double sum = 0;
            for (int i = 0; i < currentVector.length; i++) {
                sum += currentVector[i] * secondVector[i];

            }
            return new Scalar(sum);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
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
