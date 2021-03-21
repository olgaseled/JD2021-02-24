package by.it.dudko.jd01_10;

public class Bean {

    double sum(int a, int b) {
        return a + b;
    }
    @Param(a=7, b=4)
    static double max(int a, int b) {
        return Math.max(a, b);
    }
    @Param(a=40, b=50)
    static double min(int a, int b) {
        return Math.min(a, b);
    }
    @Param(a=-1, b=1)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }

}
