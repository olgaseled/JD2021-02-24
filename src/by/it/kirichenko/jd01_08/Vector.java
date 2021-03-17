package by.it.kirichenko.jd01_08;

import java.util.Arrays;
import java.util.StringJoiner;

public class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector otherVector) {
        this.value = otherVector.value;
    }

    public Vector(String str) {
        String[] arrayStr = str
                .replace("{","")
                .replace("}","")
                .replace(" ","")
                .split(",");
        double[] arrayDouble= new double[arrayStr.length];
        for (int i = 0; i < arrayStr.length; i++) {
            arrayDouble[i]=Double.parseDouble(arrayStr[i]);
        }
        this.value=arrayDouble;
    }
	
	@Override
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

    @Override
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
        return super.add(other);
    }

    @Override
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
            double[] secondVector = Arrays.copyOf(((Vector) other).value,((Vector) other).value.length);
            double[] resultVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] *= secondVector[i];
            }
            double result=0;
            for (double rV : resultVector) {
                result+=rV;
            }
            return new Scalar(result);
        }
        return super.add(other);
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Scalar){
            double secondScalar = ((Scalar) other).getValue();
            if (secondScalar==0){
                return null; //TODO div by zero
            }
            double[] resultVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] /= secondScalar;
            }
            return new Vector(resultVector);
        }
        if (other instanceof Vector){
            return null; //TODO не возможная операция вектор / вектор
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
