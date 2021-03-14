package by.it.savchenko.jd01_07;

class Runner {
    public static void main(String[] args) {
        Var v1 = new Scalar(3.1415);
        Var v2 = new Scalar("111.22");
        Var v3 = new Vector(new double []{1,2,4});
        Var v4 = new Vector("1,2,4");
        Var v5 = new Matrix("{1,2},{3,4}");
        Var v6 = new Matrix(new double[][]{{1,2},{3,4}});

        System.out.print(v1+"\n"+v2+"\n"+v3+"\n"+v4+"\n"+v5+"\n"+v6);
    }
}
