package by.it.levchuk.levchuk.jd02_03;

/*crash-noobik
Liauchuk Aliaksandr*/

public class Cashier implements Runnable {
    private final String name;

    public Cashier(int number) {
        name = "\tКассир №" + number + "";
    }

    @Override
    public void run() {
        System.out.println(this+ "Кассы открыты");
        while (SeniorCashier.storeIsClosed()){
            Buyer buyer= QueueBuyers.poll();
            if (buyer !=null) {
                synchronized (buyer.getMONITOR()) {
                    System.out.println(this + " Начало обслуживания " + buyer);
                    int timeout = Tools.getRandom(2000, 5000);
                    Tools.sleep(timeout);
                    System.out.println(this + "Закончили обслуживать" + buyer);
                    buyer.setWaiting(false);
                    buyer.notify();

                }

            }else {
                Tools.sleep(1);

            }
        }

        System.out.println(this+ "Кассы закрыты");
    }
    @Override
    public String toString(){
        return name;
    }
}
