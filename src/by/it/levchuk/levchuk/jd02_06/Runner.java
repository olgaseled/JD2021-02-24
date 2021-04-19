package by.it.levchuk.levchuk.jd02_06;

/*crash-noobik
Liauchuk Aliaksandr*/

public class Runner {

    private static class OneThread extends Thread {
        OneThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            Logger.getInstanceLogger().log(this.getName());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new OneThread("ATTENTION" + i).start();
        }
    }
}
