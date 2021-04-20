package by.it.kishkar.jd02_01;

class Buyer extends Thread implements IBuyer{
    public Buyer (int number) {
        super("Buyer # " + number);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" entered to store");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" started choose goods");
        System.out.println(this+" finished choose goods");
       int timeout = Helper.getRandom(500, 2000);
       Helper.sleep (timeout);
    }

    @Override
    public void goOut() { System.out.println(this+ " left from the store");
    }
}
