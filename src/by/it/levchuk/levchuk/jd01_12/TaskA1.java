package by.it.levchuk.levchuk.jd01_12;
/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {
    private final List<Integer> ratingList = new ArrayList<>();
    private static final Random random = new Random();

    private void clearBad(List<Integer> ratingList) {
        Iterator<Integer> iterator = ratingList.iterator();
        while (iterator.hasNext()) {
            int rating = iterator.next();
            if (rating < 4)
                iterator.remove();
        }
    }

    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();
        for (int i = 0; i < 20; i++) {
            int rating = random.nextInt(10) + 1;
            instance.ratingList.add(rating);
        }
        System.out.println(instance.ratingList);
        instance.clearBad(instance.ratingList);
        System.out.println(instance.ratingList);

    }
}
