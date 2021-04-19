package by.it.dudko.jd02_03;

import java.util.List;

public interface ICustomer {
    void enterToMarket();
    List<Good> chooseGoods();
    void goToQueue();
    void goOut();
}
