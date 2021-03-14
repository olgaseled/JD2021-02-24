package by.it.runcov.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var var1 = new Scalar(3.1415);
        Scalar var2 = new Scalar(3.1415);
        Var var3 = new Scalar(var2);
        System.out.printf("var1=%s\n", var1);
        System.out.printf("var2=%s\n", var2);
        System.out.printf("var3=%s\n", var3);
        Var vec1 = new Vector(new double[]{1, 2, 4});
        Vector vec2 = new Vector(new double[]{1, 2, 4});
        System.out.printf("vec1=%s\n", vec1);
        System.out.printf("vec2=%s\n", vec2);
    }
}
