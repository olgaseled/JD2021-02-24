package by.it.dudko.jd01_12;

public class TaskB3 {


    public static class Timer {
        private long iniTime;
        private double delta;

        public Timer() {
            iniTime = System.nanoTime();
        }

        public String getDeltaString() {
            return Double.toString(delta);
        }

        public String toString() {
            delta = (double) (System.nanoTime() - iniTime) / 1000;
            iniTime = System.nanoTime();
            return "Прошло " + getDeltaString() + " сек.";
        }
    }
}
