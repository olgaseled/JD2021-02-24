package by.it.dudko.jd01_08;

import java.util.Objects;

public class Runner {

    private static void print(Var var) {
        if (Objects.nonNull(var)) {
            System.out.println(var);
        }
    }

    public static void main(String[] args) {
        Var s = new Scalar(3.0);
        Var s2 = new Scalar("4.0");
        Var v = new Vector(new double[]{1, 2, 3}); // закомментируйте вектор и/или
        Var m = new Matrix("{{1,2,3},{4,5,6},{7,8,9}}");// матрицу, если вы их не реализовали
        /* Уровень сложности A (калькулятор) */
        Var resultAddition = s.add(s2);
        print(resultAddition); //выведет в консоль 7.0
        print(s.sub(s)); //выведет в консоль 0.0
        print(s.mul(s)); //выведет в консоль 9.0
        print(s.div(s)); //выведет в консоль 1.0
    }
}
