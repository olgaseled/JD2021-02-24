package by.it.kaminskii.jd02_06;

import java.util.Arrays;

class Vector extends Var {

    private final double[] value;

    public double[] getVector() {
        return value;
    }

    @Override
    public Var add(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            Logger.getLogger().log("Запуск операции сложения Вектор + Скаляр");
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
                Logger.getLogger().log(CalcLogOut.ADD + res[i] + "+" + other);
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            Logger.getLogger().log("Запуск операции сложения Вектор + Вектор");
            if (value.length == ((Vector) other).value.length) {
                double[] res = Arrays.copyOf(value, value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i] += ((Vector) other).value[i];
                    Logger.getLogger().log(CalcLogOut.ADD + res[i] + "+" + ((Vector) other).value[i]);
                }
                return new Vector(res);
            } else throw new CalcExeption("Разная длинна массивов");
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            Logger.getLogger().log("Запуск операции вычитания Вектор - Скаляр");
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();
                Logger.getLogger().log(CalcLogOut.SUB + res[i] + "-" + other);
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            Logger.getLogger().log("Запуск операции вычитания Вектор - Вектор");
            if (value.length == ((Vector) other).value.length) {
                double[] res = Arrays.copyOf(value, value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] - ((Vector) other).value[i];
                    Logger.getLogger().log(CalcLogOut.SUB + res[i] + "-" + ((Vector) other).value[i]);
                }
                return new Vector(res);
            } else throw new CalcExeption("Разная длинна массивов");
        } else return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            Logger.getLogger().log("Запуск операции умножения Вектор * Скаляр");
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
                Logger.getLogger().log(CalcLogOut.MUL + res[i] + "*" + other);
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            Logger.getLogger().log("Запуск операции умножения Вектор * Вектор");
            if (value.length == ((Vector) other).value.length) {
                double[] res = Arrays.copyOf(value, value.length);
                double mul = 0;
                for (int i = 0; i < res.length; i++) {
                    mul += res[i] * ((Vector) other).value[i];
                    Logger.getLogger().log(CalcLogOut.MUL + res[i] + "*" + ((Vector) other).value[i]);
                }
                return new Scalar(mul);
            } else throw new CalcExeption("Разная длинна массивов");
        } else return super.mul(other);
    }

    //операция деления
    @Override
    public Var div(Var other) throws CalcExeption {
        if (other instanceof Scalar) {    //1)вектор на скаляр
            Logger.getLogger().log("Запуск операции Деления Вектор / Скаляр");
            if (((Scalar) other).getValue() != 0) {
                Logger.getLogger().log("Проверка значения (>0)");
                double[] res = Arrays.copyOf(value, value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] / ((Scalar) other).getValue();
                    Logger.getLogger().log(CalcLogOut.DIV + res[i] + "/" + other);
                }
                return new Vector(res);
            } else throw new CalcExeption("Деление на ноль");  //если скаляр = 0
        } else return super.mul(other); //2)невозможность деления вектор на вектор || матрицу
    }

    Vector(double[] value) {
        this.value = value;

    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        strVector = strVector.replaceAll("\\{|}|", "").replaceAll(" ", "");
        String[] v = strVector.split(",");
        value = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            value[i] = Double.parseDouble(v[i]);
            System.out.println(value[i]);
        }
    }


    //переопределение метода для вывода вектора

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delim = "";
        for (double element : value) {
            sb.append(delim).append(element);
            delim = ", ";
        }
        sb.append("}");
        Logger.getLogger().log("Result" + sb);
        return sb.toString();
    }
}


//1. Из массива {1.0, 2.0, 4.0} сигнатура конструктора Vector(double[ ] value)
//2. Из такой же точно переменной сигнатура конструктора Vector(Vector vector)
//3. Из строки вида {1.0, 2.0, 4.0} сигнатура конструктора Vector(String strVector)
// Переопределите метод String toString() так, чтобы он возвращал строку вида {1.0, 2.0, 4.0}