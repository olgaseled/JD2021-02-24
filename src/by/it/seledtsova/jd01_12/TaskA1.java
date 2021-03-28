package by.it.seledtsova.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    private static Object ArrayListList;
    private static Object Integer;

    public static void main(String[] args) {
        TaskA1 taskA1=new TaskA1();
        ArrayList<Integer> marks=new ArrayList<Integer>(20);
        for (int i = 0; i <10; i++) {
            int element = (int) (Math.random() * 10 + 1);
            marks.add(element);
        }
        System.out.println(marks);// заполнить массив,
        taskA1.clearBad(marks);
        System.out.println(marks);
        }

        private void clearBad (List<Integer>myMarks) {
        Iterator<Integer>iterator=myMarks.iterator();
        while (iterator.hasNext()){
           Integer myMark= iterator.next();
           if (myMark<=3) {
               iterator.remove();

           }

        }
        }
        /*
 private void clearBad(List<Integer> myGrades){
        Iterator<Integer> iterator = myGrades.iterator();
        while (iterator.hasNext()) {
            Integer myGrade = iterator.next();
            if (myGrade < 4) {
                iterator.remove();

    */
}
