package by.it.dudko.jd01_06;

import java.util.Random;

public class TaskC2 {

    Random random;

    private final int OUTPUT_TEXT_MIN_LENGTH = 100_000;

    public static void main(String[] args) {

        String randomText;
        long time;

        TaskC2 textMaker = new TaskC2();
        Timer timer = new Timer();

        timer.start();
        randomText = textMaker.slow(Poem.text);
        time = timer.stop();
        System.out.println(randomText);
        System.out.println(time);
        System.out.println("\n***********************************\n");

        timer.start();
        randomText = textMaker.fast(Poem.text);
        time = timer.stop();
        System.out.println(randomText);
        System.out.println(time);

    }

    public TaskC2() {
        random = new Random();
    }

    @SuppressWarnings("SameParameterValue")
    public String slow(String text) {
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
    public String fast(String text) {
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

    private String[] getWords(String text) {
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
