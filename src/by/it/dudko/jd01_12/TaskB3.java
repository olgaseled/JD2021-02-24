
package by.it.dudko.jd01_12;

import java.util.*;

import static by.it.dudko.jd01_12.TaskB2.getRandomPlayers;

public class TaskB3 {
    static void main(String[] args) {
        int playersNumber = 9;
        List<String> players = getRandomPlayers(playersNumber, true);
        String winner;
        winner = process(new ArrayList<>(players));
        System.out.println(winner);
        winner = process(new LinkedList<>(players));
        System.out.println(winner);
    }


    static String process(ArrayList<String> people) {
        boolean nextOut = false;
        Iterator<String> it = people.iterator();
        while (people.size() > 1) {
            if (it.hasNext()) {
                it.next();
                if (nextOut) {
                    it.remove();
                }
                nextOut = !nextOut;
            } else {
                it = people.iterator();
            }
        }
        return people.get(0);
    }


    static String process(LinkedList<String> people) {
        boolean nextOut = false;
        Iterator<String> it = people.iterator();
        while (people.size() > 1) {
            if (it.hasNext()) {
                it.next();
                if (nextOut) {
                    it.remove();
                }
                nextOut = !nextOut;
            } else {
                it = people.iterator();
            }
        }
        return people.get(0);
    }
}