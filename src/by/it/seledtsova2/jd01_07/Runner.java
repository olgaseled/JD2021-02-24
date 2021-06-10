package by.it.seledtsova2.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var var1 = new Scalar(87);
        Var var2 = new Scalar(3.1415);
        Var var3 = new Scalar((Scalar) var2);
        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);

        Var vec1=new Vector(new double[]{1.0,2.0,4.0});
        Var vec2=new Vector((Vector) vec1);
        Var vec3=new Vector("{1.0, 2.0,4.0}");
        System.out.println(vec1);
        System.out.println(vec2);
        System.out.println(vec3);

    }
}
