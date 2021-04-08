package by.it.levchuk.levchuk.jd02_02;

/*crash-noobik
Liauchuk Aliaksandr*/

public class Cashier implements Runnable {
    private String name;

    public Cashier(int number) {
        name = "\tКассир №" + number + "";
    }

    @Override
    public void run() {
        System.out.println(this+ "Cash Opened");
        while (SeniorCashier.storeIsClosed()){
            Buyer buyer=QueueBuyers.poll();
            if (buyer !=null){
                synchronized (buyer.getMONITOR()){

                }

            }
        }

        System.out.println(this+ "Cash Closed");
    }
}
