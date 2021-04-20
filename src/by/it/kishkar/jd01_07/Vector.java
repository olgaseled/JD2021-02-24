package by.it.kishkar.jd01_07;

import java.util.Arrays;

class Vector extends Var{

        private double [] value;

        Vector (double[] value) {
             this.value=value;

        }

        Vector (String str) {
           String[] strArray= str.trim().replaceAll("\\s+", "")
                   .replace("{", "")
                   .replace("}", "")
                   .split(",");
           value = new double[strArray.length];
            for (int i = 0; i < value.length; i++) {
                value[i]=Double.parseDouble(strArray[i]);
            }

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
