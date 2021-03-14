package by.it.khrolovich.jd01_07;

public class Runner {
    public static void main(String[] args) {
        //Scalar scalar = new Scalar(9);
        //1. Scalar
        Var var1 = new Scalar(9);
        Scalar var2 = new Scalar("3.13");//?
        Var var3 = new Scalar(var2);

        System.out.printf("var1=%s\n", var1);
        System.out.printf("var2=%s\n", var2);
        System.out.printf("var3=%s\n", var2);
        //2.Vector
        Vector vec1 = new Vector(new double[]{1, 2, 3, 4, 5});
        Var vec2 = new Vector(vec1);
        Var vec3 = new Vector("{1, 2, 3, 4, 5}");

        System.out.printf("vec4=%s\n", vec1);
        System.out.printf("vec5=%s\n", vec2);
        System.out.printf("vec6=%s\n", vec3);

        Matrix matrix1 = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        Var matrix2 = new Matrix(matrix1);
        Var matrix3 = new Matrix("{{1,2},{3,4}}");

        System.out.printf("matrix1=%s\n", matrix1);
        System.out.printf("matrix2=%s\n", matrix2);
        System.out.printf("matrix3=%s\n", matrix3);
    }
}

