package by.it.kirichenko.jd01_10;

class Bean {
    @Param(a = 9, b = 18)
    double sum(int aa, int bb) {
        return aa + bb;
    }

    @Param(a = 9, b = 18)
    double max(int a, int b) {
        return a > b ? a : b;
    }

    double min(int a, int b) {
        return a < b ? a : b;
    }

    @Param(a = 9, b = 18)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
