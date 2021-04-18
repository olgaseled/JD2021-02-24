package by.it.khrolovich.jd02_03;

public class Cashier implements Runnable {
    private String name;
    //private QueueCustomer queueCustomer;
    private Context context;

    public Cashier(int number,Context context) {
        this.context = context;
        this.name = "\tCashier #" + number + " ";
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!context.getManager().storeIsClosed()) {
            Customer customer = context.getQueueCustomer().poll();
            if (customer != null) {

                synchronized (customer.getMONITOR()) {
                    //никакой другой не может  перехватить
                    //можно посылать notify
                    System.out.println(this + " started service for " + customer);
                    int timeout = Util.getRandom(2000, 5000);
                    Util.Sleep(timeout);
                    double sumOfBill = customer.getBasket().showContent();
                    System.out.println(customer.getName() + ": sum of bill = " + sumOfBill);
                    System.out.println(this + " finished service for " + customer);
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                Util.Sleep(1);//TODO должно быть правильное ожидание
                //должен также перейти в wait(), как покупатель в очереди.
                // Но его должен разбудить покупатель из очереди или очередь - посылают notify
            }
        }

        System.out.println(this + "closed");
    }

    @Override
    public String toString() {
        return name + " ";
    }
}
