package by.it.dudko.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var var1 = new Scalar(9);
        Scalar var2 = new Scalar("12.1234");
        Var var3 = new Scalar(var2);
        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);

        Vector var4 = new Vector(new double[] {1, 2, 3, 5.5});
        Var var5 = new Vector(var4);
        Var var6 = new Vector("{   1.0,2.0 ,  4.0 }");
        System.out.println(var4);
        System.out.println(var5);
        System.out.println(var6);

        Var var7 = new Matrix(new double[][] { { 1.0, 2.0 }, { 3.0, 4.0 } });
        Matrix var8 = new Matrix("{{   1.0,2.0 ,  4.0 },  {   5.0,6.0 , 7.05  },{ 7.0, 8.0 ,  9.0  } } ");
        Var var9 = new Matrix(var8);
        System.out.println(var7);
        System.out.println(var8);
        System.out.println(var9);
    }
}
