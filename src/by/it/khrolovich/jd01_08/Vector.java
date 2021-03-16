package by.it.khrolovich.jd01_08;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {
    private final double[] value;

    private double getValue() {
        return 0;
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
            //проверили, значит имеем право кастить - приводить типы
            // double otherValue = ((Scalar) other).value;//value не доступно, надо геттер
            double secondScalar = ((Scalar) other).getValue();

            double[] resultVector = Arrays.copyOf(value, value.length);

            /*for (int i = 0; i < value.length; i++) {
                value[i]+=secondScalar;
            }*/
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] += secondScalar;
            }
            return new Vector(resultVector);
            //или одной строкой
        }
        //далее если InstanceOf Vector
        if (other instanceof Vector) {
            //проверили, значит имеем право кастить - приводить типы
            //double otherValue = ((Scalar) other).value;//value не доступно, надо геттер
            double secondScalar = ((Vector) other).getValue();

            double[] resultVector = Arrays.copyOf(value, value.length);

            /*for (int i = 0; i < value.length; i++) {
                value[i]+=secondScalar;
            }*/
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] += secondScalar;
            }
            return new Vector(resultVector);
            //или одной строкой
        }
        return other.add(this);
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
