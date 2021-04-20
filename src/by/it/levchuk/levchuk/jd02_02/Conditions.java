package by.it.levchuk.levchuk.jd02_02;

/*crash-noobik
Liauchuk Aliaksandr*/

public class Conditions {
    private final QueueBuyers queueBuyers;
    private final SeniorCashier seniorCashier;
    private final Basket basket;

    Conditions(QueueBuyers queueBuyers, SeniorCashier seniorCashier, Basket basket) {
        this.queueBuyers = queueBuyers;
        this.seniorCashier = seniorCashier;
        this.basket = basket;
    }

    public QueueBuyers getQueueBuyers() {
        return queueBuyers;
    }

     public SeniorCashier getSeniorCashier() {
        return seniorCashier;
    }

    public Basket getBasket() {
        return basket;
    }
}
