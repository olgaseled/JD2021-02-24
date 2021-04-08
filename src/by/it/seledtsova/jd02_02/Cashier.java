package by.it.seledtsova.jd02_02;

public class Cashier implements Runnable{

    private final int number; // имя нашего кассира

    public Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this+"opened");

        System.out.println(this+"closed");
    }

    @Override
    public String toString() {
        return "\tCashier№"+number+" ";
    }
}
