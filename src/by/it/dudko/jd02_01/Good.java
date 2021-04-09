package by.it.dudko.jd02_01;

public class Good {

    String name;
    double price;
    StoreCurrency currency;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Good(String name, double price, StoreCurrency currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" for %.2f %s", name, price, currency);
    }
}
