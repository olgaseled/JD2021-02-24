package by.it.papruga.jd02_06.task_a;

public class Runner {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {

            new Thread(() -> {
                Logger.getLogger().log("Test");
            }).start();
        }

    }
}
