package by.it.dudko.jd01_06;

import java.util.Random;

public class TaskC2 {

    private static final int OUTPUT_TEXT_MIN_LENGTH = 100_000;

    public static void main(String[] args) {

        String randomText;
        long time;
        Timer timer = new Timer();

        timer.start();
        randomText = slow(Poem.text);
        time = timer.stop();
        System.out.println(randomText);
        System.out.println(time);
        System.out.println("\n***********************************\n");

        timer.start();
        randomText = fast(Poem.text);
        time = timer.stop();
        System.out.println(randomText);
        System.out.println(time);

    }

    @SuppressWarnings("SameParameterValue")
    public static String slow(String text) {
        Random random = new Random(123);
        String randomText = "";
        String randomWord;
        String[] words = getWords(text);
        while (randomText.length() < OUTPUT_TEXT_MIN_LENGTH) {
            randomWord = words[random.nextInt(words.length)];
            //noinspection StringConcatenationInLoop
            randomText += randomWord + " ";
        }
        return randomText;
    }

    @SuppressWarnings("SameParameterValue")
    public static String fast(String text) {
        Random random = new Random(123);
        StringBuilder randomText = new StringBuilder();
        String randomWord;
        String[] words = getWords(text);
        while (randomText.length() < OUTPUT_TEXT_MIN_LENGTH) {
            randomWord = words[random.nextInt(words.length)];
            randomText
                    .append(randomWord)
                    .append(" ");
        }
        return randomText.toString();
    }

    public static String[] getWords(String text) {
        return text.trim().split("[^а-яА-ЯёЁa-zA-Z]+");
    }

    public static class Timer {
        long init;

        public Timer() {
        }

        public void start() {
            init = System.nanoTime();
        }

        public long stop() {
            return System.nanoTime() - init;
        }
    }
}
