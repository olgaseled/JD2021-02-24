package by.it.korotkevich.jd02_01;

class Customer extends Thread implements ICustomer {

    public Customer(int number) {
        super("Customer #" + number + " ");
    }

    @Override
    public void run() {
        enterMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterMarket() {
        System.out.println(this + "entered the store.");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "is choosing goods.");
        int timeout = Util.getRandom(500, 2000);
        Util.sleep(timeout);
        System.out.println(this + "finished choosing goods.");
    }

    @Override
    public void goOut() {
        System.out.println(this + "leaves the store.");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
