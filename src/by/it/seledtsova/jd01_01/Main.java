package by.it.seledtsova.jd01_01;

public class Main {

    public static void main(String[] args) {
        Hello hello=new Hello ();
        hello.printSlogan();
        hello.setSlogan ("Привет мир");
        hello.printSlogan() ;
	// write your code here
   Args argObject=new Args(args);
    argObject.printArgs();}
}
