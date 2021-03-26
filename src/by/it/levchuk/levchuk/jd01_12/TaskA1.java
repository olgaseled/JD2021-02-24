package by.it.levchuk.levchuk.jd01_12;
/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskA1 {
    private List<Integer> grades = new ArrayList<>();
    private static Random random=new Random();

    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();
        for (int i = 0; i < 20; i++) {
            int grade= random.nextInt(10)+1;
            instance.grades.add(grade);
        }
        System.out.println(instance.grades);

    }
}
