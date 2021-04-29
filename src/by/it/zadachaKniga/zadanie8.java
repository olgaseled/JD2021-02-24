package by.it.zadachaKniga;

public class zadanie8 {
    public static void main(String[] args) {
        int a = 124571;
        int n = a % 10;
        if (n == 1) {
            System.out.println(a + " рубль");
        } else if (n == 2 || n == 3 || n == 4) {
            System.out.println(a + " рубля");
        } else if (n == 5 || n == 6 || n == 7 || n == 8 || n == 9 || n == 0) {
            System.out.println(a + " рублей");
        }
    }


}

