package by.it.kaminskii.new_project_jd_02;

import java.util.Arrays;

class Vector extends Var {
    private final double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        strVector = strVector.replaceAll("\\{|\\}|", "").replaceAll(" ", "");
        String[] v = strVector.split(",");
        value = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            value[i] = Double.parseDouble(v[i]);
            System.out.println(value[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delim = "";
        for (double element : value) {
            sb.append(delim).append(element);
            delim = ", ";
        }
        sb.append("}");
        return sb.toString();
    }

    //КОНЕЦ ПЕРВОГО БЛОКА


    //Начало калькулятора

    @Override
    public Var add(Var other) {
        double[] res = Arrays.copyOf(value, value.length);
        if (other instanceof Scalar) {
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]+ ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
//        else if(other instanceof Vector){
//            double
//            if()
//        }
        return null;
    }

    @Override
    public Var sub(Var other) {
        return null;
    }

    @Override
    public Var mul(Var other) {
        return null;
    }

    @Override
    public Var div(Var other) {
        return null;
    }
}


//1. Из массива {1.0, 2.0, 4.0} сигнатура конструктора Vector(double[ ] value)
//2. Из такой же точно переменной сигнатура конструктора Vector(Vector vector)
//3. Из строки вида {1.0, 2.0, 4.0} сигнатура конструктора Vector(String strVector)
// Переопределите метод String toString() так, чтобы он возвращал строку вида {1.0, 2.0, 4.0}