package by.it.dudko.jd02_01;

public class Customer extends Thread implements ICustomer {

    public Customer(int number) {
        super(String.format("Customer #%d", number));
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enters the store");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started choosing goods");
        int actionTime = CustomerUtil.getRandom(500, 2000);
        CustomerUtil.sleep(actionTime);
        System.out.println(this + " finished choosing goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + " leaves the store");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
