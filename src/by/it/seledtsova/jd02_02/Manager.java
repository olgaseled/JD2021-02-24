package by.it.seledtsova.jd02_02;



class Manager {

    private volatile static int buyersInMarket = 0; // покупатели  в магазине
    private volatile static int buyersOutMarket = 0; // покупатели  вне магазине

    static synchronized void newCustomer() { // увеличиваем счетчик наших вошедших покупателей
        buyersInMarket++;
    }

    static void completeBuyer() { // увеличиваем вышедших покупателей.
        synchronized (Manager.class) {
            buyersOutMarket++;
        }
    }

    static boolean marketIsOpened() { // количество внутри + выведших < план (100)
        //countCustomerIn<Config.PLAN; //prod
        return buyersInMarket != Configuration.PLAN; //не 100, а или больше, или меньше
    }

    static boolean marketIsClosed() {  //
        // countCustomerOut>=Config.PLAN; //prod
        return buyersOutMarket == Configuration.PLAN; //операция только читает поле , здесь синхранизация необязательна.
                                                    // тк переменная volatile
    }
}
