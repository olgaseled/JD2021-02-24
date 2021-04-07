package by.it.khrolovich.jd02_02;

public class Cashier implements Runnable{
    private  String name;

    public Cashier(int number) {
        this.name = "\tCashier #"+number+" ";
    }

    @Override
    public void run() {
        System.out.println(this+"opened");
        while (!Manager.storeIsClosed()){
            Customer customer = QueueCustomer.poll();
            if(customer!= null) {

                synchronized (customer.getMONITOR()) {
                    //никакой другой не может  перехватить?
                    //можно посылать notify

                    System.out.println(this + " started service");
                    int timeout = Util.getRandom(2000, 5000);
                    Util.Sleep(timeout);
                    System.out.println(this + " finished service");
                    customer.setWaiting(false);
                    customer.notify();
                }
            }else{
                Util.Sleep(1);//должно быть правильное ожидание
            }
        }

        System.out.println(this+"closed");
    }

    @Override
    public String toString() {
        return name+" ";
    }
}
