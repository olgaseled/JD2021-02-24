package by.it.levchuk.levchuk.jd02_02;

/*crash-noobik
Liauchuk Aliaksandr*/

public class Cashier implements Runnable{
    private String name;
    public Cashier(int number){
        name = "\t Кассир №"+number+"";
    }
    @Override
    public void run() {
        System.out.println(this);

        System.out.println(this);
    }
}
