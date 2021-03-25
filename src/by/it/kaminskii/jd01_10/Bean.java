package by.it.kaminskii.jd01_10;

public class Bean {
    @Param(a = 2, b = 5)
    static double sum(int a, int b) {
        return a + b;
    }


    double min(int a, int b) {
        return a < b ? a : b;
    }

    @Param(a = 2, b = 5)
    static double max(int a, int b) {
        return a > b ? a : b;
    }

    @Param(a = 2, b = 5)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }

}
