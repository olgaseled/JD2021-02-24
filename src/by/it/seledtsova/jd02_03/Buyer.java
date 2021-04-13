package by.it.seledtsova.jd02_03;

/*
Напишите программу, моделирующую поток покупателей Buyerв магазине.
Каждую секунду в магазин приходят от 0 до 2 новых покупателей в течение двух минут.
 */


import java.util.ArrayList;
import java.util.List;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private QueueBuyers queueBuyers;

    private final Object MONITOR;

    private boolean waiting = false; // поле ожидания

    public Object getMONITOR() {
        return MONITOR;
    }

    public void setWaiting(boolean waiting) { //сеттер на поле ожидания
        this.waiting = waiting;
    }


    public Buyer(int number, QueueBuyers queueBuyers) {
        super("Buyer №" + number + " ");
        this.queueBuyers=queueBuyers;
        MONITOR=this;
        Manager.addBuyer();
    }


    @Override
    public void run(){   // выделили наш поток. Покупатель пришел в зал магазина,выбирает и покупает товар
        enterToMarket();
        takeBasket();
        chooseGoods();
        putProductToTheBasket();
        goToQueue();
        goOut();
        Manager.completeBuyer();
    }

// Реализовали методы класса предка enterToMarket(), chooseGoods(), goOut()
    @Override
    public void enterToMarket() {
        System.out.println(this+"The buyer has entered to the supermarket");

    }
    @Override
    public void takeBasket() {
        System.out.println(this + "The buyer takes the basket");
        int pause = Util.getRandom(500, 2000); //
        Util.sleep(pause);
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+"The buyer star to choose products");
        int pause = Util.getRandom(500, 2000);
        Util.sleep(pause);
        System.out.println(this + "finished choose goods");
    }



    @Override
    public void putProductToTheBasket() {
        List<Integer> basketProduct=new ArrayList<>();
        int pause = Util.getRandom(500, 2000); //
        Util.sleep(pause);
        int howMuchProducts= Util.getRandom(1,4);
        for (int product = 0; product < basketProduct.size(); product++) {
            basketProduct.add(howMuchProducts);
        }
        System.out.println(this + "The buyer put "+howMuchProducts+" product to the basket");
    }


    @Override
    public void goToQueue() { // добавляем в очередь
        synchronized (MONITOR) {
            queueBuyers.add(this); // покупатель взял свой монитор. Теперь мы обращаемся не к классу , а к экземпляру
            System.out.println(this+" покупатель встал в очередь");
            waiting = true;
            while (waiting) { // пока мы не в движении , мы будем ждать
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(this+ " покупатель покинул очередь");
        }
    }

    @Override
    public void goOut() {
        System.out.println(this+"The buyer has left the supermarket");
    }


    @Override
    public String toString() {
        return this.getName();
    }


}
