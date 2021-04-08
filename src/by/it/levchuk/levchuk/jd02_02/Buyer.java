package by.it.levchuk.levchuk.jd02_02;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.ArrayList;
import java.util.List;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private final Object MONITOR;

    public Object getMONITOR() {
        return MONITOR;
    }

    public boolean waiting = false;

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public Buyer(int number) {
        super("Покупатель №" + number + " ");
        MONITOR = this;
        SeniorCashier.newBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        SeniorCashier.lastBuyer();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "Вошёл в магазин");
    }

    @Override
    public void takeBasket() {
        System.out.println(this + "Взял корзину");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "Выбирает товары");
        int timeout = Tools.getRandom(500, 2000);
        Tools.sleep(timeout);
        System.out.println(this + "Выбрал товары");
    }

    @Override
    public void putGoodsToBasket() {
        List<String> listProducts = new ArrayList<>();
        System.out.println(this + "Положил товары в корзину");
    }

    @Override
    public void goToQueue() {
        synchronized (MONITOR) {
            QueueBuyers.add(this);
            waiting = true;
            while (waiting) {
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + "Покидает магазин");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
