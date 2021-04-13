package by.it.zmushko.jd02_03;

import java.util.concurrent.Semaphore;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private final Object MONITOR;
    private final Contex contex;
    private final Semaphore semaphore = new Semaphore(30);
    private boolean waitInQueue = false;

    public Object takeMonitor(){
        return MONITOR;
    }

    public void waiting(boolean wait) {
        this.waitInQueue = wait;
    }

    Buyer(int number, Contex contex) {
        super("Buyer number <<" + number + ">>");
        MONITOR = this;
        this.contex = contex;
        contex.getManager().peopleCome();
    }

    @Override
    public void run() {
        enterToShop();
        takeBasket();
        chooseItems();
        try {
            semaphore.acquire();
            stayInQueue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        goOutFromShop();
        contex.getManager().counterPeople();
    }

    @Override
    public void enterToShop() {
        System.out.println(this.getName() + " Enter in shop ");
    }

    @Override
    public void chooseItems() {
        System.out.println(this.getName() + " Start choose ");
        putGoodsToBasket();
        System.out.println(this.getName() + " End choose ");
    }

    @Override
    public void goOutFromShop() {
        System.out.println(this.getName() + " Out of the shop");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        System.out.println(this.getName() + " take a basket");
    }

    @Override
    public void putGoodsToBasket() {
        for (int countGoods = 0; countGoods < Support.getRandom(1, 4); countGoods++) {
            System.out.println(this.getName() + " put in basket " + Support.getRandomGoods());
            Support.sleep(Support.getRandom(500, 2000));
        }
    }

    public void stayInQueue() {
        synchronized (MONITOR) {
            contex.getQueuePeoples().addInQueue(this);
            waitInQueue = true;
            while(waitInQueue) {
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
