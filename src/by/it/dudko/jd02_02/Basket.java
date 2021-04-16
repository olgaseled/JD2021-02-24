package by.it.dudko.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Basket implements IBasket {

    Map<String, Double> goods;

    public Basket() {
        goods = new HashMap<>(Config.MAX_GOODS_IN_BASKET);
    }

    @Override
    public void putGood(Good good) {
        goods.put(good.getName(), good.getPrice());
    }

}
