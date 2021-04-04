package by.it.kishkar.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {


    private List<Integer> list=new ArrayList<>();
    private void clearBad(List<Integer> grades){
        Iterator<Integer> iterator= grades.iterator();
        while (iterator.hasNext()){
            int grade=iterator.next();
            if (grade<4)
                iterator.remove();


        }
    }

    public static void main(String[] args) {
        TaskA1 task=new TaskA1();
        for (int i = 0; i < 20; i++)
        task.list.add((int) Math.ceil(Math.random()*10));
        System.out.println(task.list);
        task.clearBad(task.list);
        System.out.println(task.list);


    }




/*
    private List<Integer> grades = new ArrayList<>();
    private static Random random = new Random();


    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();
        for (int i = 0; i < 20; i++) {
            int grade = random.nextInt(10) + 1;
            instance.grades.add(grade);
        }
        System.out.println(instance.grades);

    }

    private void ClearBad(List<Integer> myGrades) {
        Iterator<Integer> iterator = myGrades.iterator();
        while (iterator.hasNext()) {
            Integer myGrade = iterator.next();
            if (myGrade < 4) {
                iterator.remove();

            }
        }


    }
*/

}
