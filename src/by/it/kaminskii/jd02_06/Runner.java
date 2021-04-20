package by.it.kaminskii.jd02_06;/* created by Kaminskii Ivan
 */

public class Runner {


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread;
            int finalI = i;
            new Thread(()->{
                Logger.getLogger().log("Test"+ finalI);
            }).start();
        }
        Logger logger = Logger.getLogger();
        logger.log("test");
    }
}
