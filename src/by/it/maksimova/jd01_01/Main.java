package by.it.maksimova.jd01_01;

public class Main {

    public static void main(String[] args) {

        Hello hello=new Hello();
        hello.pringSlogan();
        hello.setSlogan("Привет мир");
        hello.pringSlogan();

        Args argObject=new Args (args);
        argObject.pringArgs();
    }
}
