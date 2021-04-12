package by.it.dudko.sandbox_oop;

public interface IStore {
    void open();
    void close();
    void setCurrency(Currency mainCurrency);
    void sales(double cutOffPercent);
    void printGoods();
}
