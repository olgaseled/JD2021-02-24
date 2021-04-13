package by.it.papruga.jd02_01;

public class Pensioneer extends Customer {

    public Pensioneer(int number) {
        super(number);
        this.pensioneer = true;
        this.slowRatio = Config.P_SLOW_RATIO;
    }

    @Override
    public String toString() {
        return "Pensioner " + super.toString();
    }
}
