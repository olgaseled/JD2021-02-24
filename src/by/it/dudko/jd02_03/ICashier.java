package by.it.dudko.jd02_03;

public interface ICashier {
    void scanGood(Good good);
    void sayCheckSum(Customer customer);
    void countGood(double cost);
    void takeBreak();
}
