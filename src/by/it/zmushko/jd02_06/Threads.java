package by.it.zmushko.jd02_06;

public class Threads extends Thread {

    Threads(String name) {
        super(name);
    }

    @Override
    public void run() {
        Logger.getLogger().logging(this.getName());
    }
}
