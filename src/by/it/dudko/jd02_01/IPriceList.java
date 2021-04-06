package by.it.dudko.jd02_01;

import java.util.List;

public interface IPriceList {


    List<String> getProductsList();

    <T> T getCurrency();

    double getCostByName(String product);
}
