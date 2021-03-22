package by.it.runcov.jd01_10;

class Bean {
    @Param(a = 9, b = 10)
    double sum(int a, int b) {
        return a + b;
    }

    static double max(int a, int b) {
        return a > b ? a : b;
    }

    @Param(a = 9, b = 10)
    static double min(int a, int b) {
        return a < b ? a : b;
    }

    @Param(a = 9, b = 10)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
