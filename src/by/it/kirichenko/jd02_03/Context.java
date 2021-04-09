package by.it.kirichenko.jd02_03;

public class Context {

    private final QueueBuyers queueBuyers;
    private final Manager manager;
    public Context(Manager manager, QueueBuyers queueBuyers) {
        this.queueBuyers=queueBuyers;
        this.manager=manager;
    }
}
