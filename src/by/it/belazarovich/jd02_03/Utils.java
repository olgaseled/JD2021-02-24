package by.it.belazarovich.jd02_03;

import java.util.concurrent.ThreadLocalRandom;

class Utils {

     static int getRandom (int min, int max) {
        return ThreadLocalRandom.current().nextInt((max-min+1)+min);
     }

     static int getRandom(int max){
         return getRandom(0, max);
     }
static void sleep (int timeout){
    try {
        Thread.sleep(timeout/ Configuration.K_SPEED);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}

}
