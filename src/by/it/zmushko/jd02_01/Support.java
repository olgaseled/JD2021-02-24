package by.it.zmushko.jd02_01;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Support {

    static void sleep(int timeSleep) {
        try {
            Thread.sleep(timeSleep / Constants.WALK_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static int getRandom(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    static int getRandom(int max) {
        return getRandom(0, max);
    }

    static String getRandomGoods() {
        ArrayList<String> arrayListGoods = new ArrayList<>(Products.products.keySet());
        String randomGoods = arrayListGoods.get(Support.getRandom(arrayListGoods.size() - 1));
        Double valueGoods = Products.products.get(randomGoods);
        return randomGoods + " with a price " + valueGoods;
    }

}
