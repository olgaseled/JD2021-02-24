package by.it.khrolovich.jd02_06;

public class Runner {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                Logger.get().log("Test");
            }).start();

        }

    }
}
