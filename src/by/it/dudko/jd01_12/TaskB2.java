package by.it.dudko.jd01_12;

import java.util.*;

public class TaskB2 {

//    static String process(ArrayList<String> people) {
//        int counter = 0;
//        Iterator<String> it = people.iterator();
//        while (people.size() >= everyNthOut) {
//            if (!it.hasNext()) {
//                it = people.iterator();
//            }
//            it.next();
//            counter++;
//            if (counter == everyNthOut) {
//                it.remove();
//                counter = 0;
//            }
//        }
//        return people.get(0);
//    }

    static String process(ArrayList<String> people) {
        for (int counter = 1, cursor = 1; people.size() > 1; counter++) {
            if (counter % 2 == 0) {
                cursor = (cursor >= people.size()) ? cursor % people.size() : cursor;
                people.remove(cursor++);
            }
        }
        return people.get(0);
    }


    static String process(LinkedList<String> people) {
        int counter = 0;
        Iterator<String> it = people.iterator();
        while (people.size() >= 2) {
            if (!it.hasNext()) {
                it = people.iterator();
            }
            it.next();
            counter++;
            if (counter == 2) {
                it.remove();
                counter = 0;
            }
        }
        return people.get(0);
    }


    public static void main(String[] args) {
        int playersNumber = 9;
        List<String> players = getRandomUniquePlayers(playersNumber);
        String winner;
        winner = process(new ArrayList<>(players));
        System.out.println(winner);
        winner = process(new LinkedList<>(players));
        System.out.println(winner);
    }

    static List<String> getRandomUniquePlayers(int playersNumber) {
        List<String> players = new ArrayList<>(playersNumber * 4 / 3 + 1);
        String[] localNames = {"Алесь", "Анюта", "Васіль", "Віталіна", "Ганна", "Генадзь",
                "Ефрасіння", "Казімір", "Кандрат", "Матвей", "Мірон", "Паліна",
                "Сямён", "Соф'я", "Тарас", "Трафім", "Улляна", "Ціхан", "Ядвіга"};
        Random rnd = new Random(123);
        while (players.size() < playersNumber) {
            int randI = rnd.nextInt(playersNumber) + 1;
            if (players.contains(localNames[randI])) {
                continue;
            }
            players.add(localNames[randI]);
        }
        return players;
    }

}
