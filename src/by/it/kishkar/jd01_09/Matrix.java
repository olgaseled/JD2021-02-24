package by.it.kishkar.jd01_09;

import by.it.kishkar.jd01_07.Var;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {

        this.value=value;
    }


    Matrix(Matrix matrix) {
        this.value= matrix.value;

    }


    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{{");
        String del="";
        for (double i = 1; i <=2 ; i++) {
            sb.append(del).append(i);
            del=", ";
        }
        sb.append("},{");
        del="";
        for (double j = 3; j <=4 ; j++) {
            sb.append(del).append(j);
            del=", ";

        }
        sb.append("}}");

        return sb.toString();
    }
}
