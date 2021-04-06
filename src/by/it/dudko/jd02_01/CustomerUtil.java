package by.it.dudko.jd02_01;

import java.util.concurrent.ThreadLocalRandom;

public class CustomerUtil {

    private CustomerUtil() {
    }

    public static int getRandom(int min, int max) {
        return ThreadLocalRandom
                .current()
                .nextInt(max - min + 1) + min;
    }

    public static int getRandom(int max) {
        return getRandom(0, max);
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis / Config.SPEED_MULTIPLIER);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
