package by.it.savchenko.jd02_01;

import java.util.concurrent.ThreadLocalRandom;

public class Util {

    private Util() {
    }

    public static int getRandom(int min, int max) {

        return ThreadLocalRandom
                .current()
                .nextInt(max - min + 1) + min;
    }

    static int getRandom(int max) {
        return getRandom(0, max);
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / Config.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
