package by.it.maksimova.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    private List <Integer> marks = new ArrayList();
    Random random = new Random();

    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();
        for (int i = 0; i < 15; i++) {
            int mark = instance.random.nextInt(10);
            instance.marks.add(mark);
        }
        System.out.println (instance.marks);
        instance.clearBad(instance.marks);
        System.out.println(instance.marks);

    }

    private void clearBad(List<Integer> marks) {
        Iterator<Integer> iterator = marks.iterator();
        while (iterator.hasNext()) {
            Integer badMark = iterator.next();
            if (badMark<4)
                iterator.remove();
        }
    }
}
