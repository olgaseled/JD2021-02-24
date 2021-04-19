package by.it.dudko.jd02_02;

public interface ICashier {
    void scanGood(Good good);
    void sayCheckSum(Customer customer);
    void countGood(double cost);
    void takeBreak();
}
