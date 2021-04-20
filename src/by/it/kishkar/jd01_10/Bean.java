package by.it.kishkar.jd01_10;

public class Bean {

    @Param(a = 5, b = 6)
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 5, b = 6)
    static double avg(int a, int b) {
        return (a + b) / 2.0;
    }

    @Param(a = 5, b = 6)
    double min(int a, int b) {
        return a < b ? a : b;
    }

    double max(int a, int b) {
        return a > b ? a : b;
    }


}
