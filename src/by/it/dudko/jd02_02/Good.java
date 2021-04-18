package by.it.dudko.jd02_02;

public class Good implements IGood {

    String name;
    double price;
    StoreCurrency currency;

    public Good(String name, double price, StoreCurrency currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public StoreCurrency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" for %.2f %s", name, price, currency);
    }
}
