package by.it.korotkevich.jd02_02;

public class Context {
    private final QueueOfCustomers queueOfCustomers;
    private final Manager manager;
    private final Basket basket;

    Context(QueueOfCustomers queueOfCustomers, Manager manager, Basket basket) {
        this.queueOfCustomers = queueOfCustomers;
        this.manager = manager;
        this.basket = basket;
    }

    public QueueOfCustomers getQueueOfCustomers() {
        return queueOfCustomers;
    }

    public Manager getManager() {
        return manager;
    }

    public Basket getBasket() {
        return basket;
    }
}
