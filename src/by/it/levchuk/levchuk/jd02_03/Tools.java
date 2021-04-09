package by.it.levchuk.levchuk.jd02_03;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.concurrent.ThreadLocalRandom;

class Tools {

    protected static int getRandom(int min, int max) {

        return ThreadLocalRandom
                .current()
                .nextInt(max - min + 1) + min;
    }

    protected static int getRandom(int max) {

        return getRandom(0, max);
    }

    protected static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / Сoefficients.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
