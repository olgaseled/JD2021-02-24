package by.it.maksimova.jd01_10;

class Bean {
    @Param(a = 9, b = 18)
    double sum(int a, int b) {
        return a + b;
    }

   static double max(int a, int b) {
        return a > b ? a : b;
    }
    @Param(a = 9, b = 18)
    static double min(int a, int b) {
        return a < b ? a : b;
    }
    @Param(a = 9, b = 18)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
