package by.it.seledtsova.jd02_01;


import java.util.concurrent.ThreadLocalRandom;

class Util {

    private Util() {
    }

    static int getRandom(int min, int max) {
        return ThreadLocalRandom
                .current()
                .nextInt(max - min + 1) + min;
    }

    static int getRandom(int max) {
        return getRandom(0, max);
    } // вместо 4 было макс


    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / Configuration.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
