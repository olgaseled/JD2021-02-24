package by.it.levchuk.levchuk.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var var1 = new Scalar(3.1415);
        Scalar var2 = new Scalar("3.1415");
        Var var3 = new Scalar(var2);

        System.out.printf("var1=%s\n", var1);
        System.out.printf("var2=%s\n", var2);
        System.out.printf("var3=%s\n", var3);
    }
}
