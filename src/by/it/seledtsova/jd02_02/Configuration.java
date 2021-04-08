package by.it.seledtsova.jd02_02;


class Configuration {

    static final int K_SPEED=1000; // коэфициент ускорения
    static final int FINAL_TIME = 120;
    static final int PLAN=100; //количество покупателей
    volatile static  int buyersInMarket=0; // сколько вошло покупателей
    volatile static int buyersOutMarket=0; // сколько вышло покупателей

    static synchronized void addBuyer(){
        buyersInMarket++; // подсказывает, что операция не атомарна. написали synchronized и все стало атомарно
    }
    static void completeBuyer (){ // второй вариант использования synchronized
        synchronized (Configuration.class) {
            buyersInMarket--;
            buyersOutMarket++;
        }
    }

    //вычисляем количество покупателей, которые уже все купили и ушли
    // вкускать могу покупатели вошли+покупатели ушли = 100 (PLAN)

    static boolean marketIsOpened () {
        return buyersInMarket+buyersOutMarket!=PLAN;
    }
    static boolean marketIsClosed () {
        return buyersOutMarket==PLAN;
    }

}
