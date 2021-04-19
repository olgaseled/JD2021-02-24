package by.it.dudko.jd02_03;

import java.util.List;

public interface IUseBasket {
    void takeBasket();
    void putGoodsToBasket(List<Good> goods);
    List<Good> takeOutAllGoods();
}
