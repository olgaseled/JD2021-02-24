package by.it.dudko.jd02_06;

public class Runner {

    private static class OneThread extends Thread {
        OneThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            Logger.getLoggerInstance()
                    .log(this.getName());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new OneThread("th" + i).start();
        }
    }
}
