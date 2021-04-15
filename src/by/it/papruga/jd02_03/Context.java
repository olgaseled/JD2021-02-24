package by.it.papruga.jd02_03;

class Context {

    private final QueueCustomers queueCustomers;
    private final QueueCashiers queueCashiers;
    private final Manager manager;

    Context(QueueCustomers queueCustomers, QueueCashiers queueCashiers, Manager manager) {
        this.queueCustomers = queueCustomers;
        this.queueCashiers = queueCashiers;
        this.manager = manager;
    }

    public QueueCustomers getQueueCustomers() { return queueCustomers; }

    public QueueCashiers getQueueCashiers() { return queueCashiers; }

    public Manager getManager() { return manager; }
}
