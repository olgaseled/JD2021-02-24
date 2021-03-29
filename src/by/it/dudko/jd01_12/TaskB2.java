package by.it.dudko.jd01_12;

import java.util.*;

public class TaskB2 {

    static int everyNthOut = 2;

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
        int currentRoundPlayersCount = people.size();
        int i = 1;
        while (currentRoundPlayersCount >= everyNthOut) {
            if ((i - 1) % everyNthOut == 0) {
                people.remove(i);
            }
            if (i == currentRoundPlayersCount - 1) { // last in the list
                // remove second from start
                i = 1;
            } else if (i == currentRoundPlayersCount - 2) { // before last in the list
                // remove first
                i = 0;
            } else {
                i++;
            }
            currentRoundPlayersCount = people.size();
        }
        return people.get(0);
    }


    static String process(LinkedList<String> people) {
        int counter = 0;
        Iterator<String> it = people.iterator();
        while (people.size() >= everyNthOut) {
            if (!it.hasNext()) {
                it = people.iterator();
            }
            it.next();
            counter++;
            if (counter == everyNthOut) {
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
        for (int i = 0; players.size() < playersNumber; i++) {
            int randI = rnd.nextInt(playersNumber) + 1;
            if (players.contains(localNames[randI])) continue;
            players.add(localNames[randI]);
        }
        return players;
    }

    public static class GameRuleException extends Exception {
        public GameRuleException() {
            super();
        }

        public GameRuleException(String message) {
            super(message);
        }

        public GameRuleException(String message, Throwable cause) {
            super(message, cause);
        }

        public GameRuleException(Throwable cause) {
            super(cause);
        }
    }

}
