package by.it.levchuk.levchuk.jd01_10;

public class Bean {
    @Param(a = 7, b = 15)
    double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 7, b = 15)
    double max(int a, int b) {
        return a > b ? a : b;
    }

    @Param(a = 7, b = 15)
    static double min(int a, int b) {
        return a < b ? a : b;
    }

    static double avg(int a, int b) {
        return (a + b) / 2.0;
    }

}
