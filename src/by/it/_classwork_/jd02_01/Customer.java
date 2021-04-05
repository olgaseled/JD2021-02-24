package by.it._classwork_.jd02_01;

class Customer extends Thread implements ICustomer {

    public Customer(int number) {
        super("Customer #" + number + " ");
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "goes to the store");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started choose goods");
        int timeout = Util.getRandom(500, 2000);
        Util.sleep(timeout);
        System.out.println(this + "finished choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + "leaves the store");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
