package by.it.dudko.jd02_01;

import java.util.List;

public interface ICustomer {
    void enterToMarket();
    <T> List<T> chooseGoods();
    void goOut();
}
