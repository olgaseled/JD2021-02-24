package by.it.kaminskii.jd02_01;/* created by Kaminskii Ivan
 */

import jdk.jshell.execution.Util;

class Customer extends Thread implements ICustomer {

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "enter to the store");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "Started choose goods");
//        int timeOut = Util.
//        System.out.println(this + "Finished choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + "Leave the store");
    }

    public Customer(int number) {
        super("Customer #" + number + " ");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
