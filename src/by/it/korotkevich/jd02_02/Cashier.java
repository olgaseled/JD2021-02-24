package by.it.korotkevich.jd02_02;

import java.util.List;
import java.util.Map;

class Cashier implements Runnable {
    private String name;

    Cashier(int number) {
        name = "\tCashier #" + number + " ";
    }

    @Override
    public void run() {
        System.out.println(this + "started service.");
        Map<Good, Double> priceList = GoodsList.getPriceList();
        while (!Manager.storeIsClosed()) {
            Customer customer = QueueOfCustomers.poll();
            if (customer != null) {
                synchronized (customer.getMONITOR()) {
                    System.out.println(this + "is serving " + customer);
                    List<Good> basketContents = Basket.getBasketContents();
                    for (Good basketContent : basketContents) {
                        System.out.println(this+"has added "+basketContent+" to the check. It costs "
                                +priceList.get(basketContent));
                    }
                    System.out.println(this + "finished serving " + customer);
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                Util.sleep(1);
            }
        }
        System.out.println(this + "closed");
    }

    @Override
    public String toString() {
        return name;
    }
}
