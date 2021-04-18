package by.it.dudko.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket implements IBasket {

    Map<String, Good> goods;

    public Basket() {
        goods = new HashMap<>(Config.MAX_GOODS_IN_BASKET);
    }

    public void putGood(Good good) {
        goods.put(good.getName(), good);
    }

    public Good getGood(String name) {
       return goods.get(name);
    }

    public List<Good> getAllGoods() {
        return new ArrayList<>(goods.values());
    }
}
