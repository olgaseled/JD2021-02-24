package by.it.seledtsova.jd01_06;

public class TaskB1 {

    private static final String votes= "уеэоаыяиюёУЕЫАОЭЯИЮЁ";

    public static void main(String[] args) {
        String [] arrayWords=Poem.text.split("\\s+");

        for (int i = 0; i < arrayWords.length-1; i++) {
            arrayWords[i] = arrayWords[i].replaceAll("[^а-яА-ЯёЁ]", "");
        }
        for (int j = 0; j < arrayWords.length-1; j++) {
            boolean result = checkOneWord(arrayWords[j]);
            if (result) {
                System.out.println(arrayWords[j]);
            }
        }
    }

    private static boolean checkOneWord(String word) {
        if (word.length()==0) return false;
        boolean b = votes.indexOf(word.charAt(0)) < 0
                && votes.indexOf(word.charAt(word.length() - 1)) >= 0;
        return b;
    }
}





