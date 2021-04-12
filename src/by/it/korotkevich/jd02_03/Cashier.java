package by.it.korotkevich.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Cashier implements Runnable {
    private String name;

    private Context context;

    Cashier(int number, Context context) {
        name = "\tCashier #" + number + " ";
        this.context = context;
    }

    @Override
    public void run() {
        System.out.println(this + "started service.");
        Map<Good, Double> priceList = GoodsList.getPriceList();
        while (!context.getManager().storeIsClosed()) {
            Customer customer = context.getQueueOfCustomers().poll();
            if (customer != null) {
                synchronized (customer.getMONITOR()) {
                    System.out.println(this + "is serving " + customer);
                    printCustomerCheck(customer.basket, customer);
                    System.out.println(this + "finished serving " + customer);
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                Thread.onSpinWait();
                Util.sleep(1);
            }
        }
        System.out.println(this + "closed");
    }

    private void printCustomerCheck(Basket basket, Customer customer) {
        ArrayList<Good> basketContents = basket.getBasketContents();
        double fullPrice = 0;
        for (Good good : basketContents) {
            System.out.println(this + "adds " + good + " to the check. It costs: "
                    + GoodsList.priceList.get(good) + ".");
            fullPrice += GoodsList.priceList.get(good);
        }
        System.out.printf("Total check sum for %s is: %.2f\n", customer, fullPrice);
    }

    @Override
    public String toString() {
        return name;
    }
}
