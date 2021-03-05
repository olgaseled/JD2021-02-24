package by.it.levchuk.levchuk;

public class Main {

    public static void main(String[] args) {
        Hello hello=new Hello();
        hello.printslogan();
        hello.setSlogan("Привет мир");
        hello.printslogan();


        Args argObject=new Args(args);
        argObject.printArgs();
        // write your code here
    }
}
