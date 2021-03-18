package by.it.seledtsova.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var var1 = new Scalar(9); // переменная вар = любому из потомков (скаляр)
        Scalar var2 = new Scalar("12.1234");
        Var var3 = new Scalar(var2);
        System.out.printf("var1=%s\n", var1); // метод то.стринг из классва скаляр, если этого метода нет, то из абстрактоного класса
        System.out.printf("var2=%s\n", var2);
        System.out.printf("var3=%s\n", var3);


        Var vec4 = new Vector(new double[]{1, 2, 3, 4, 5});
        Var vec5 = new Vector((Vector) vec4);
        Var vec6 = new Vector("{1.0, 2.0, 4.0}");
        System.out.printf("vec4=%s\n", vec4);
        System.out.printf("vec5=%s\n", vec5);
        System.out.printf("vec6=%s\n", vec6);

        double[][] arrayValues = {{1.0, 2.0}, {3.0, 4.0}};
        Var matrix1 = new Matrix(arrayValues);

        Var matrix3 = new Matrix("{{1.0,2.0},{3.0,4.0}}");

        System.out.printf("matr1=%s\n", matrix1);
        System.out.printf("matr1=%s\n", matrix3);

    }
}
