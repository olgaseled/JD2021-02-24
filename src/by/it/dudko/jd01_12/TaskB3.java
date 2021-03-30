package by.it.dudko.jd01_12;

import java.util.*;

public class TaskB3 {

    public static void main(String[] args) {
        int playersNumber = 4096;
        List<String> players = getRandomPlayers(playersNumber, false);
        String winner;

        Timer timer = new Timer(); // set iniTime
        winner = process(new ArrayList<>(players));
        System.out.print("Победитель: " + winner + "\n");
        System.out.print("Время для ArrayList: " + timer.toString() + "\n\n"); // iniTime updates here

        winner = process(new LinkedList<>(players));
        System.out.print("Победитель: " + winner + "\n");
        System.out.print("Время для LinkedList: " + timer.toString() + "\n\n");
    }

    public static String process(ArrayList<String> people) {
        for (int counter = 1, cursor = 1; people.size() > 1; counter++) {
            if (counter % 2 == 0) {
                cursor = (cursor >= people.size()) ? cursor % people.size() : cursor;
                people.remove(cursor++);
            }
        }
        return people.get(0);
    }


    public static String process(LinkedList<String> people) {
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

    public static List<String> getRandomPlayers(int playersNumber, boolean unique) {
        List<String> players = new ArrayList<>(playersNumber * 4 / 3 + 1);
        String[] localNames = {"Алесь", "Анюта", "Васіль", "Віталіна", "Ганна", "Генадзь",
                "Ефрасіння", "Казімір", "Кандрат", "Матвей", "Мірон", "Паліна",
                "Сямён", "Соф'я", "Тарас", "Трафім", "Улляна", "Ціхан", "Ядвіга"};
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


    public static class Timer {
        private long iniTime;
        private double delta;

        public Timer() {
            iniTime = System.nanoTime();
        }

        public String getDeltaString() {
            return Double.toString(delta);
        }

        public String toString() {
            delta = (double) (System.nanoTime() - iniTime) / 1000;
            iniTime = System.nanoTime();
            return "прошло " + getDeltaString() + " сек.";
        }
    }
}
