package by.it.papruga.jd02_03;

public interface ICashier {

    void goToCashierQueue();    //кассир в очереди кассиров

    void waiting();             //кассир в магазине, но ожидает

    void opened ();             //касса открыта

    void startService();        //начало обслуживания покупателя

    void finishService();       //завершение обслуживания покупателя

    void closed();              //касса закрыта

}
