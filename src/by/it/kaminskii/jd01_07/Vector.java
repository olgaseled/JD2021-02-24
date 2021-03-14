package by.it.kaminskii.jd01_07;

import java.util.Arrays;

class Vector extends Var {
    private final double[ ] value;

    Vector(double[] value) {
        this.value = value;
    }
    Vector(Vector vector){
        this.value = vector.value;
    }
    Vector(String strVector){
        strVector= strVector.replaceAll("\\{|\\}", " ");
        strVector= strVector.replaceAll(" ", "");
        String[] v = strVector.split(",");
        value = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            value[i]=Double.parseDouble(v[i]);
            System.out.println(value[i]);
        }
    }


    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{");
        String delim = "";
        for(double element:value){
            sb.append(delim).append(element);
            delim=", ";
        }
        sb.append("}");
        return sb.toString();
    }
}


//1. Из массива {1.0, 2.0, 4.0} сигнатура конструктора Vector(double[ ] value)
//2. Из такой же точно переменной сигнатура конструктора Vector(Vector vector)
//3. Из строки вида {1.0, 2.0, 4.0} сигнатура конструктора Vector(String strVector)
// Переопределите метод String toString() так, чтобы он возвращал строку вида {1.0, 2.0, 4.0}