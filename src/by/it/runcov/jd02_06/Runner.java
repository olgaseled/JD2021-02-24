package by.it.runcov.jd02_06;

public class Runner {

    private static class OneThread extends Thread {
        OneThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            Logger.getInstanceLogger().log(this.getName());
        }

        public static void main(String[] args) {
            for (int i = 0; i < 50; i++) {
                new OneThread("I like Java" + " " + i).start();
            }
        }
    }
}
