package by.it.kishkar.jd01_07;

import java.util.Arrays;

class Vector extends Var{

        private double [] value;

        Vector (double[] value) {
             this.value=value;

        }

        Vector (String str) {
            value=new double[] {1, 2, 4}; //Не уверен что правильно, вроде как я присваиваю значение массиву

        }

    Vector (Vector vector){
        this.value= vector.value;

    }

    @Override
    public String toString() {
       StringBuilder sb=new StringBuilder("{");
       String del="";
        for (double element : value) {
            sb.append(del).append(element);
            del=", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
