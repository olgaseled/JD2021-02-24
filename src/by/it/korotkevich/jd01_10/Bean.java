package by.it.korotkevich.jd01_10;

class Bean {
    @Param(a = 9, b = 18)
    double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 3, b = 2)
    static double max(int a, int b) {
        return a > b ? a : b;
    }

    @Param(a = 9, b = 10)
    static double min(int a, int b) {
        return a < b ? a : b;
    }

    double avg(int a, int b) {
        return (a + b) / 2.0;
    }

}
