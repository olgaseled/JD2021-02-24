package by.it.seledtsova.jd01_08;

import java.util.Arrays;

public class Vector extends Var {

    private final double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) { // 1 конструктор на вход принимает некоторый массив
        this.value = value;
    }

    Vector(Vector stringVector) {
        this.value = stringVector.value;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{"); // создали стринг билдер и обьявили, что первый разделитель у нас пустой
        String delimiter = ""; //  первый разделитель будет пустой
        for (double element : value) {          // переберем все элементы в массиве  value
            sb.append(delimiter).append(element); // будем печатать сразу разделитель , а за ним элемент
            delimiter = ", ";               // после первого числа разделитель заменим на запятую  и пробел
        }                                   // в итоге все след элементу будут размедять запятой с пробелом
        sb.append("}");
        return sb.toString();
    }

    @Override
    protected double[] getValues() {
        return new double[0];
    }

    public Vector(String stringValue) {
        String[] arrayString = stringValue.replaceAll("[{} ]+", "").trim().split(",");
        double[] result = new double[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            result[i] = Double.parseDouble(arrayString[i]);
        }
        this.value = result;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue(); // к каждому элементу этого массива добавим скаляр и добавили геттер для велью
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length); // если к вектору прибавляется тоже вектор
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        return super.add(other); //к вектору прибавить матрицу нельзя. поэтому будет сообщение об ошибке
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double sum=0;
            for (int i = 0; i < value.length ; i++) {
              sum+=value[i]*((Vector)other).value[i];
                }
                return new Scalar(sum);
            }
            return super.sub(other);
        }


    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
            return super.div(other);

        }
    }









