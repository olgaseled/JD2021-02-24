package by.it._classwork_.jd02_01;

import java.util.Random;

class Util {

    private static Random random = new Random();

    private Util() {
    }

    static int getRandom(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    static int getRandom(int max) {
        return getRandom(0, max);
    }

    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / Config.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
