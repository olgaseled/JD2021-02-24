package by.it.runcov.jd02_03;

class Context {
    private final QueueBuyers queueBuyers;
    private final Manager manager;

    Context(QueueBuyers queueBuyers, Manager manager) {
        this.queueBuyers = queueBuyers;
        this.manager = manager;
    }

    public QueueBuyers getQueueBuyers() {
        return queueBuyers;
    }

    public Manager getManager() {
        return manager;
    }
}
