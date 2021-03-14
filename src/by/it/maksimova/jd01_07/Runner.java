package by.it.maksimova.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var var1 = new Scalar(3.1415);
        Scalar var2 = new Scalar("3.1415");
        Var var3 = new Scalar(var2);
        System.out.printf("var1=%s\n", var1);
        System.out.printf("var2=%s\n", var2);
        System.out.printf("var3=%s\n", var3);

        Var var4 = new Vector(new double [] {1.0, 2.0, 3.0});
        System.out.printf("var4=%s\n", var4);
        Var var5 = new Vector("{1.0, 2.0, 3.0}");
        System.out.printf("var5=%s\n", var5);
    }
}
