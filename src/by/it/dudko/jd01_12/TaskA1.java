package by.it.dudko.jd01_12;

import java.util.*;

public class TaskA1 {
    private final ArrayList<Integer> marks =  new ArrayList<>(Arrays.asList());
    private final int pupilCount = 31;

    public static void main(String[] args) {
        TaskA1 journal = new TaskA1();
        ArrayList<Integer> marks = journal.marks;
        Random rnd = new Random();
        for (int i = 0; i < journal.pupilCount; i++) {
            marks.add(rnd.nextInt(10) + 1);
        }
        System.out.println(marks);
        journal.clearBad(marks);
        System.out.println(marks);
    }

    void clearBad(List<Integer> grades) {
        for (Iterator<Integer> it = grades.iterator(); it.hasNext() ;) {
            if (it.next() < 4) {
                it.remove();
            }
        }
    }


}
