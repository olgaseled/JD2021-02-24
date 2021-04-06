package by.it.maksimova.jd02_01;

public class Buyer extends Thread implements IBuyer {

    public Buyer(int number) {
        super("Buyer " + number+" ");
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "entered the Market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started choosing goods");
        int timeForChoosingGoods = Utils.getRandom(500, 2000);
        Utils.sleep(timeForChoosingGoods);
        System.out.println(this + "finished choosing goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + "leaves the Market");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}

