package by.it.papruga.jd01_06;

public class TaskB1 {

    private static final String votes = "уеэоаыяиюёУЕЫАОЭЯИЮЁ";

    public static void main(String[] args) {

        // boolean result = chekOneWord("Вася");

        String text = Poem.text;
        String[] words = text.split("[-.,:! \\n]");

        for (String word : words) {
            if (word.length() > 0) {
                if (chekOneWord(word)) {
                    System.out.println(word);
                }
            }
        }
    }

    private static boolean chekOneWord(String word) {
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        return votes.indexOf(first) < 0 && votes.indexOf(last) >= 0;
    }
}

