package by.it.kaminskii.new_project_jd_02;/* created by Kaminskii Ivan
 */

import java.util.concurrent.ThreadLocalRandom;

public class TestHelper {


    static int randomValue(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    static int randomValue(int max) {
        return randomValue(0, max);
    }
}
