package by.it.khrolovich.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    private List<Integer> grades = new ArrayList<>();

    private static Random random = new Random(6565665656L);

    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();
        for(int i =0;i<20;i++){

            //grades.add(); - нужен объект, конструкторами не получится
            //int g =(int) (Math.random()*10)+1;
            int g = random.nextInt();
            instance.grades.add(g);
        }
        System.out.println(instance.grades);
        //instance.cle
    }
    //void ClearBad(List<Integer> grades){//передается по ссылке
    void ClearBad(List<Integer> myGrades){

        //Alt+enter
        myGrades.removeIf(myGrade -> myGrade < 4);

        //Alt+enter Replace Iterator
        for (Iterator<Integer> iterator = myGrades.iterator(); iterator.hasNext(); ) {
            Integer myGrade = iterator.next();
            //внутри итератора нельзя удалять
            if (myGrade < 4) {
                myGrades.remove(myGrade);

            }

        }

//внутри итератора нельзя удалять, значит заменяем ALt+Enter
       /* for (Integer myGrade : myGrades) {
            //внутри итератора нельзя удалять
            if(myGrade<4){
                myGrades.remove(myGrade);

            }

        }*/
    }
}
