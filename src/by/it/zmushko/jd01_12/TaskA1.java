package by.it.zmushko.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    private List<Integer> grades = new ArrayList<>();

    private static Random random = new Random();

    public static void main(String[] args) {
        TaskA1 taskA1 = new TaskA1();
        for (int i = 0; i < 20; i++) {
            int grade = random.nextInt(10) + 1;
            taskA1.grades.add(grade);

        }
        System.out.println(taskA1.grades);
        taskA1.clearBad(taskA1.grades);
    }

    void clearBad(List<Integer> thisGrades) {
        Iterator<Integer> iterator = thisGrades.iterator();
        while (iterator.hasNext()) {
            Integer thisGrade = iterator.next();
            if (thisGrade < 4) {
                thisGrades.remove(thisGrade);
            }
        }
    }

}
