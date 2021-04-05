package by.it.dudko.jd01_12;

import java.util.*;

public class TaskB2 {

//    public static String process(ArrayList<String> people) {
//        for (int counter = 1, cursor = 1; people.size() > 1; counter++) {
//            if (counter % 2 == 0) {
//                cursor = (cursor >= people.size()) ? cursor % people.size() : cursor;
//                people.remove(cursor++);
//            }
//        }
//        return people.get(0);
//    }

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


    public static List<String> getRandomPlayers(int playersNumber, boolean unique) {
        List<String> players = new ArrayList<>(playersNumber * 4 / 3 + 1);
        String[] localNames = {"Алесь", "Анюта", "Васіль", "Віталіна", "Ганна", "Генадзь",
                "Ефрасіння", "Казімір", "Кандрат", "Матвей", "Мірон", "Паліна",
                "Сямён", "Соф'я", "Тарас", "Трафім", "Улляна", "Ціхан", "Ядвіга"};
        if (unique && localNames.length < playersNumber) {
            unique = false;
        }
        Random rnd = new Random(123);
        while (players.size() < playersNumber) {
            int randI = (rnd.nextInt(playersNumber) + 1) % localNames.length;
            if (unique && players.contains(localNames[randI])) {
                continue;
            }
            players.add(localNames[randI]);
        }
        return players;
    }

}
