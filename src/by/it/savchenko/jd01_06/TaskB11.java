package by.it.savchenko.jd01_06;

public class TaskB11 {

    private static final String votes = "уеыаоэяиюёУЕЫАОЭЯИЮЁ";

    public static void main(String[] args) {
        boolean result = checkOneWord(Poem.text);
        System.out.println(result);

    }

    private static boolean checkOneWord(String word) {
        return votes.indexOf(word.charAt(0)) < 0
                && votes.indexOf(word.charAt(word.length() - 1)) >= 0;
    }
}
