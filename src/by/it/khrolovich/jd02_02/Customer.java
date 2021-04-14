package by.it.khrolovich.jd02_02;

public class Customer extends Thread implements ICustomer, IUseBasket {

    //int number;//номер покупателя
    private Basket basket = new Basket();//его личная корзинка

    private final Object MONITOR;
    private boolean waiting = false;

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public Object getMONITOR() {
        return MONITOR;
    }

    public Basket getBasket() {
        return basket;
    }

    public Customer(int numberCustomer) {
        super("Customer №" + numberCustomer + " ");
        MONITOR = this;
        Manager.newCustomer();//посчитается в момент рождения покупателя
    }

    @Override
    public void run() {
        //Manager.newCustomer();//здесь нельзя считать. Покупатель существует

        enterToMarket();
        takeBasket();//покупатель взял корзину
        chooseGoods();//выбрал товар
        goToQueue();//покупатель идет в очередь
        goOut();

        Manager.completeCustomer();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " entered to the Store");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started to choose good");

        int countOfGoods = Util.getRandom(1, 4);
        for (int i = 0; i < countOfGoods; i++) {
            int pause = Util.getRandom(500, 2000);//от 0.5 до 2х секунд
            Util.Sleep(pause);//выбираем товар от 0.5 до 2х секунд
            putGoodsToBasket();//кладем в корзину
        }
        System.out.println(this + "finished to choose good");
    }

    @Override
    public void goOut() {
        System.out.println(this + "go out from the Store");
    }

    @Override
    public String toString() {
        //return super.toString();
        return this.getName();
    }

    @Override
    public void takeBasket() {
        System.out.println(this + "take the basket");
    }

    @Override
    public void goToQueue() {
        synchronized (MONITOR) {
            QueueCustomer.add(this);//добавляет сам себя
            waiting = true;
            while (waiting) {
                try {
                    MONITOR.wait();//висит, не получает кванты времени
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void putGoodsToBasket() {
        Good good = ListGoods.randomGood();
        basket.put(good);
        System.out.println(this + " put to the Basket " + good);
    }
}
