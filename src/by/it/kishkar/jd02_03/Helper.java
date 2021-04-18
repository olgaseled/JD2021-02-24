package by.it.kishkar.jd02_03;

import java.util.Random;

public class Helper {

    private static final Random generate = new Random();

    public static int getRandom(int start, int end) {
        return generate.nextInt(end - start + 1) + start;
    }
    public static int getRandom(int max) {
        return getRandom(0, max);
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout/ Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
