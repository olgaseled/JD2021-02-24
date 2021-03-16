package by.it.papruga.jd01_08;


import java.util.Arrays;
import java.util.StringJoiner;

public class Vector extends Var {

    private  double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector otherVector) {
        this.value = otherVector.value;
    }

   public Vector(String strVector) {

        String Clean = strVector.replaceAll("[\\{|\\} ]", "");

       String[] num = Clean.split( "[,]");
       double [] mas = new double [num.length];

        for (int i = 0; i < num.length; i++) {
            mas [i] = Double.parseDouble(num[i]);
        }
        this.value = mas;

    }

    @Override
    public Var add(Var other) {

        if (other instanceof Scalar) {

            double [] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {

                res [i]=res[i]+((Scalar)other).getValue();
            }
            return  new Vector(res);
        }
        else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]+((Vector)other).value[i];
            }
            return new Vector(res);
        }
        else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) {

        if (other instanceof Scalar) {

            double [] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {

                res [i]=res[i]-((Scalar)other).getValue();
            }
            return  new Vector(res);
        }
        else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]-((Vector)other).value[i];
            }
            return new Vector(res);
        }
        else

        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {

        if (other instanceof Scalar) {

            double [] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {

                res [i]=res[i]*((Scalar)other).getValue();
            }
            return  new Vector(res);
        }
        else if (other instanceof Vector) {
            double sum=0;
            for (int i = 0; i < value.length; i++) {
                sum+=value[i]*((Vector) other).value[i];
            }
            return new Scalar(sum);
        }
        else

        return super.mul(other);
    }

    @Override
    public Var div(Var other) {

        if (other instanceof Scalar) {

            double [] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {

                res [i]=res[i]/((Scalar)other).getValue();
            }
            return  new Vector(res);
        }
        
        return super.div(other);
    }

    @Override
    public String toString() {
        // {1.0, 3.5, 5.8}

        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        for (Double v : value) {
            stringJoiner.add(v.toString());
        }

        return stringJoiner.toString();

    }
}
