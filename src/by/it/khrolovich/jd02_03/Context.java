package by.it.khrolovich.jd02_03;

class Context {
    private final QueueCustomer queueCustomer;
    private final Manager manager;

    public Context(QueueCustomer queueCustomer, Manager manager) {
        this.queueCustomer = queueCustomer;
        this.manager = manager;
    }

    public QueueCustomer getQueueCustomer() {
        return queueCustomer;
    }

    public Manager getManager() {
        return manager;
    }
}
