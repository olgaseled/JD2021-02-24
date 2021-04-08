package by.it.dudko.jd02_01;

import java.util.*;
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


    public static List<Good> getRandomGoods(int count) {
        List<Good> goods = new ArrayList<>(count * 4 / 3 + 1);
        Set<String> selectedProducts = new HashSet<>(); // provides unique products control
        PriceList priceList = Store.getPriceList();
        StoreCurrency currency = priceList.getCurrency();
        List<String> productList = priceList.getProductsList();
        int randomProductId;
        while (goods.size() < count) {
            randomProductId = getRandom(productList.size() - 1);
            String productName = productList.get(randomProductId);
            if (selectedProducts.contains(productName)) {
                continue;
            }
            selectedProducts.add(productName);
            double cost = priceList.getCostByName(productName);
            goods.add(new Good(productName, cost, currency));
        }

        return goods;
    }
}
