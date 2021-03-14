package by.it.khrolovich.jd01_07;

public class Runner {
    public static void main(String[] args) {
        //Scalar scalar = new Scalar(9);
        Var var1 = new Scalar(9);
        Scalar var2 = new Scalar("3.13");//?
        Var var3 = new Scalar(var2);

        System.out.printf("var1=%s\n", var1);
        System.out.printf("var2=%s\n", var2);
        System.out.printf("var3=%s\n", var2);

        Var vec4 = new Vector(new double[]{1, 2, 3, 4, 5});
        System.out.printf("vec4=%s\\n", vec4);
    }
}

