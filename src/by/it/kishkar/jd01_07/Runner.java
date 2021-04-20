package by.it.kishkar.jd01_07;

public class Runner {

    public static void main(String[] args) {
        //Scalar
        Var v1=new Scalar(3.1415);
        Scalar v2=new Scalar("12.3456");
        Var v3=new Scalar(v2);
        System.out.println(v1);
        System.out.println(v3);
        //Vector
        Var vect1=new Vector(new double[]{1,2,3,4,5});
        System.out.println(vect1);
        Vector vect2=new Vector(new double[]{1,2,3,4,5});
        System.out.println(vect2);
        Var vect3=new Vector(vect2);
        System.out.println(vect3);
        //Matrix
        Var matrix1=new Matrix(new double[][]{{1,2},{3,4}});
        System.out.println(matrix1);

    }

}
