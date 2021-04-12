package by.it.khrolovich.jd02_01;

import java.util.concurrent.ThreadLocalRandom;

public class Util {
    static int getRandom(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
        //return ThreadLocalRandom.current().nextInt(max-min+1)+min;
    }

    static int getRandom(int max) {
        return getRandom(0, max);
    }

    static void Sleep(int timeSleep) {
        try {
            Thread.sleep(timeSleep / Config.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
