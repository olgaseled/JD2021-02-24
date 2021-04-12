package by.it.korotkevich.jd02_02;

class Cashier implements Runnable {
    private String name;

    Cashier(int number) {
        name = "\tCashier #" + number + " ";
    }

    @Override
    public void run() {
        System.out.println(this + "started service.");
        while (!Manager.storeIsClosed()) {
            Customer customer = QueueOfCustomers.poll();
            if (customer != null) {
                synchronized (customer.getMONITOR()) {
                    System.out.println(this + "is serving " + customer);
                    int timeout = Util.getRandom(2000, 5000);
                    Util.sleep(timeout);
                    System.out.println(this + "finished serving " + customer);
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                Util.sleep(1);
            }
        }
        System.out.println(this + "closed");
    }

    @Override
    public String toString() {
        return name;
    }
}
