package by.it.belazarovich.jd02_03;

class Context {
    private final QueueOfBuyers queueOfBuyers;
    private final Manager manager;

    Context(QueueOfBuyers queueOfBuyers, Manager manager) {
        this.queueOfBuyers = queueOfBuyers;
        this.manager = manager;
    }

    public QueueOfBuyers getQueueOfBuyers() {
        return queueOfBuyers;
    }

    public Manager getManager() {
        return manager;
    }
}
