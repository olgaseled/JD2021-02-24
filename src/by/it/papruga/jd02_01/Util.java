package by.it.papruga.jd02_01;

import java.util.concurrent.ThreadLocalRandom;

public class Util {

    private Util() {
    }

    static int getRandom(int min, int max) {
        return ThreadLocalRandom
                .current()
                .nextInt(max - min + 1) + min;
    }

    static int getRandom(int max) {

        return getRandom(0, max);

    }

    static void sleep(double timeout) {

        try {
            Thread.sleep((long) (timeout / Config.K_SPEED));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }




}
