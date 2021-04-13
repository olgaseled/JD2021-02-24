package by.it.khrolovich.jd02_03;

public class Manager {

    private static int countCustomerIn = 0;
    private static int countCustomerOut = 0;

    static synchronized void newCustomer() {
        countCustomerIn++;
        //неатомарная операция
    }

    static void completeCustomer(){
        synchronized (Manager.class) {//то же самое, чтов методе newCustomer
            countCustomerOut++;
        }
        //static - один единственный
        //если 3 магазина запускать. Нельзя расценивать как один объект static
    }
    static boolean storeIsOpened(){//люди могут заходить

        //return countCustomerIn<=Config.PLAN;//production
        return countCustomerIn!= Config.PLAN;//dev разработка
        //просто чтение, можно
    }

    static boolean storeIsClosed(){
        //return countCustomerOut>=Config.PLAN;
        return countCustomerOut==Config.PLAN;
    }

}
