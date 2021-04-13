package by.it.seledtsova.jd02_03;


import java.util.concurrent.atomic.AtomicInteger;

class Manager {
    // Atomic = ссылка на какой-то атомарный счетчик, в нашем случае он статический.
    // Их желательно писать final, чтобы ссылка никуда не убежала
    // volatile and synchranize  убрали

    private  static final AtomicInteger buyersInMarket = new AtomicInteger(0); // избавились от volatile, создали atomic
    private static final AtomicInteger buyersOutMarket =new AtomicInteger(0);//0 присвоить нельзя, только через конструктор


    static void addBuyer(){ //заменили ++
        buyersInMarket.getAndIncrement();
    }

    static void completeBuyer() {
          buyersOutMarket.getAndIncrement(); // заменили ++
        }


    static boolean marketIsOpened() { // количество внутри + выведших < план (100)
        //countCustomerIn<Config.PLAN; //prod
        return buyersInMarket.get() != Configuration.PLAN; //не 100, а или больше, или меньше
    }

    static boolean marketIsClosed() {  //
        // countCustomerOut>=Config.PLAN; //prod
        return buyersOutMarket.get() == Configuration.PLAN; //операция только читает поле , здесь синхранизация необязательна.
                                                    // тк переменная volatile
    }
}
