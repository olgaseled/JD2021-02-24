package by.it.savchenko.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {


    public static void main(String[] args) {
        int n  = 15;
        ArrayList<String> list = new ArrayList<>();

        process(n, list);
        System.out.println(list);               //заполнили и вывели лист

        process(list);                      //моделируем удаление каждого 2 по очереди пока не останется 1
        //(после каждого удаления выводим список оставшихся)

        System.out.println(joseph(15, 2));      //просто поиск последнего (15- количество 2- шаг)
    }

    static String process(int n, ArrayList<String> peoples) {
        for(int i = 0; i < n; i++) {
            peoples.add(String.valueOf(i + 1));
        }
        return null;
    }

    public static int joseph(int n, int k) {
        if (n > 1) {
            return (joseph(n - 1, k) + k - 1) % n + 1;
        } else {
            return 1;
        }
    }

    static String process(ArrayList<String> peoples) {
        int count = 0;
        Iterator<String> it = peoples.iterator();
        while(peoples.size() > 1) {
            if(it.hasNext()) {
                it.next();
                count++;
                if(count == 2) {
                    it.remove();
                    count = 0;
                    System.out.println(peoples);
                }
            }
            else {
                it = peoples.iterator();
            }
        }
        return null;
    }
}