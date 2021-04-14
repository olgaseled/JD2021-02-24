package by.it.zmushko.jd02_03;

class Contex {

    private final QueuePeoples queuePeoples;
    private final Manager manager;

    Contex(QueuePeoples queuePeoples, Manager manager) {
        this.queuePeoples = queuePeoples;
        this.manager = manager;
    }

    public QueuePeoples getQueuePeoples() {
        return queuePeoples;
    }

    public Manager getManager() {
        return manager;
    }
}
