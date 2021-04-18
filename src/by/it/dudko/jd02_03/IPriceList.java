package by.it.dudko.jd02_03;

import java.util.List;

public interface IPriceList {


    List<String> getProductsList();

    StoreCurrency getCurrency();

    double getCostByName(String product);
}
