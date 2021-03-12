package by.it.levchuk.levchuk.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var var1=new Scalar(9);
        Var var2=new Scalar(12.1234);
        Var var3=new Scalar(var2);
        System.out.printf("var1=5s\n", var1);
        System.out.println(var1);
        System.out.println(var2);
    }
}
