package by.it.papruga.jd01_07;

public class Runner {

    public static void main(String[] args) {

        Var var1 = new Scalar(9);
        Scalar var2 = new Scalar("12.1234");
        Var var3 = new Scalar(var2);

        System.out.printf("var1=%s\n", var1);
        System.out.printf("var2=%s\n", var2);
        System.out.printf("var3=%s\n", var3);

        Var var4 = new Vector(new double[]{1.0, 2.0, 4.0});
        Vector var5 = new Vector("{1.0, 2.0, 4.0}");
        Var var6 = new Vector(var5);

        System.out.printf("var4=%s\n", var4);
        System.out.printf("var5=%s\n", var5);
        System.out.printf("var6=%s\n", var6);

        Var var7 = new Matrix(new double[][]{{1.0, 2.0}, {3.0, 4.0}});
        Matrix var8 = new Matrix("{{1,2},{3,4}}");
        Var var9 = new Matrix(var8);

        System.out.printf("var7=%s\n", var7);
        System.out.printf("var8=%s\n", var8);
        System.out.printf("var9=%s\n", var9);

    }
}
