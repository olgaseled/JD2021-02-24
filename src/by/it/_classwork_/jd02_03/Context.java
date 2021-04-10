package by.it._classwork_.jd02_03;

class Context {
    private final QueueCustomers queueCustomers;
    private final Manager manager;

    Context(QueueCustomers queueCustomers, Manager manager) {
        this.queueCustomers = queueCustomers;
        this.manager = manager;
    }

    public QueueCustomers getQueueCustomers() {
        return queueCustomers;
    }

    public Manager getManager() {
        return manager;
    }
}
