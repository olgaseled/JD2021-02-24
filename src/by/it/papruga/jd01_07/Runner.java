package by.it.papruga.jd01_07;

public class Runner {

    public static void main(String[] args) {

        Var var1 = new Scalar(9);
        Scalar var2 = new Scalar("12.1234");
        Var var3 = new Scalar(var2);
        System.out.printf("var1=%s\n",var1);
        System.out.printf("var2=%s\n",var2);
        System.out.printf("var3=%s\n",var3);

    }
}
