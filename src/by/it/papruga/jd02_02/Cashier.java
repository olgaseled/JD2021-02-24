package by.it.papruga.jd02_02;

public class Cashier implements Runnable {

    private final int number;
    public Basket basket = new Basket();

    public Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this + "opened");

        while (!Manager.storeIsClosed()){

            Customer customer = QueueCustomers.pull();

            if (customer!=null){
                System.out.println(this+"start service for "+customer);
                int timeout = Util.getRandom(500, 2000);
                Util.sleep(timeout);
                System.out.println(customer + "bought:" + customer.showBasket());
                System.out.println(this+"finish service for "+customer);
                synchronized (customer)
                {
                    customer.setWaiting(false);
                    customer.notify();
                }
            }
            else {
                Util.sleep(1);
            }

        }



        System.out.println(this + "closed");
    }


    @Override
    public String toString() {
        return "Cashier N#"+ number +" ";
    }
}
