package by.it.levchuk.levchuk.jd02_03;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.ArrayList;

public class Cashier implements Runnable {
    private String name;

    private Conditions conditions;

    public Cashier(int number, Conditions conditions) {
        name = "\tКассир № " + number + " ";
        this.conditions =conditions;
    }

    @Override
    public void run() {
        System.out.println(this+ "Кассы открыты");
        while (!conditions.getSeniorCashier().storeIsClosed()){
            Buyer buyer= conditions.getQueueBuyers().pull();
            if (buyer !=null) {
                synchronized (buyer.getMONITOR()) {
                    System.out.println(this + " Начало обслуживания " + buyer);
                    int timeout = Tools.getRandom(2000, 5000);
                    Tools.sleep(timeout);
                    printBuyerCheck(buyer.basket, buyer);
                    System.out.println(this + "Закончили обслуживать " + buyer);
                    buyer.setWaiting(false);
                    buyer.notify();

                }

            }else {
                Thread.onSpinWait();
                Tools.sleep(1);

            }
        }

        System.out.println(this+ "Кассы закрыты");
    }

    private void printBuyerCheck(Basket basket, Buyer buyer) {
        ArrayList<Good> basketContents = basket.getBasketContents();
        double fullPrice = 0;
        for (Good good : basketContents) {
            System.out.println(this + "добавляет " + good + " в чек - цена : "
                    + PriceList.priceList.get(good) + ".");
            fullPrice += PriceList.priceList.get(good);
        }
        System.out.printf("\t%s В чеке. Итого: %.2f\n", buyer, fullPrice);
    }


    @Override
    public String toString(){
        return name;
    }
}
