package by.it.dudko.jd02_03;

import java.util.List;

public interface IBasket {

    void putGood(Good good);

    Good getGood(String name);

    List<Good> getAllGoods();

}
