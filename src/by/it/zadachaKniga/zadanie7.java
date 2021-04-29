package by.it.zadachaKniga;

public class zadanie7 {
    public static void main(String[] args) {
        int a = 4;
        int b = 5;
        double r = 10;
        double sRound = (r*r * 3.14);
        double sSquare = a * b;
        if (sRound >= sSquare) {
            System.out.println("real");

        } else {
            System.out.println("unreal");
        }
        System.out.println(sRound);
        System.out.println(sSquare);
    }
}
