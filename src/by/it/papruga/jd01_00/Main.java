package by.it.papruga.jd01_00;

public class Main {

    public static void main(String[] args) {

        Hello hello= new Hello();
        hello.printSlogan();
        hello.setSlogan("Привет Мир");
        hello.printSlogan();

        Args ArgObject=new Args (args);
        ArgObject.printArgs();

    }
}
