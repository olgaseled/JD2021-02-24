package by.it.seledtsova.jd02_06;

public class Runner {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> { // создали 100 потоков лямдба выражением
                Logger logger = Logger.getLogger();  // знаем класс Logger . и видем методы класса и вызываем их
                logger.log("Logger test");
            }).start();
        }
    }
}