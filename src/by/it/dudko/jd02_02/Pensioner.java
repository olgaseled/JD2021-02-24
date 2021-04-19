package by.it.dudko.jd02_02;

public class Pensioner extends Customer {
    public Pensioner(int number) {
        super(number);
        this.pensioner = true;
        this.slowRatio = Config.PENSIONERS_SLOW_RATIO;
    }

    @Override
    public String toString() {
        return this.getName().replace("Customer", "Customer \u262D");
    }
}
