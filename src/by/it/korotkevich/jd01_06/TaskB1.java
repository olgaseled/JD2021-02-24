package by.it.korotkevich.jd01_06;

public class TaskB1 {

    private static final String votes= "уеэоаыяиюёУЕЭОАЫЯИЮЁ";

    public static void main(String[] args) {
        boolean result=checkOneWord("Вася");
    }

    private static boolean checkOneWord(String word) {

        return votes.indexOf(word.charAt(0))<0
                && votes.indexOf(word.charAt(word.length()-1))>=0;
    }
}
