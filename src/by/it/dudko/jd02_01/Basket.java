package by.it.dudko.jd02_01;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Basket implements IBasket {

    Map<String, Double> goods;

    public Basket() {
        goods = new HashMap<>(Config.MAX_GOODS_IN_BASKET);
    }

    @Override
    public void putGood(Good good) {
        goods.put(good.getName(), good.getPrice());
    }

    @Override
    public Good removeGood(String name) {
        Object removed = goods.remove(name);
        if (Objects.isNull(removed))
            return null;
        else
            return new Good(name, (double) removed, Store.getPriceList().getCurrency());
    }
}
