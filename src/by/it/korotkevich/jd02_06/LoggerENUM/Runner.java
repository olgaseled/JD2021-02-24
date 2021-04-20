package by.it.korotkevich.jd02_06.LoggerENUM;


public class Runner {
    private static class OneThread extends Thread {
        private Logger logger = Logger.INSTANCE;

        OneThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            logger.log(this.getName());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            new OneThread("th" + i).start();
        }
    }
}
