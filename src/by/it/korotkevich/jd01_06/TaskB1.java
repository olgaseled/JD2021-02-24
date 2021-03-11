package by.it.korotkevich.jd01_06;

public class TaskB1 {

    private static final String votes= "уеэоаыяиюёУЕЫАОЭЯИЮЁ";

    public static void main(String[] args) {
        String[] arrayOfWords=Poem.text.split("\\s+");
        for (int i = 0; i < arrayOfWords.length-1; i++) {
            arrayOfWords[i] = arrayOfWords[i].replaceAll("[^а-яА-ЯёЁ]", "");
        }

        for (int word = 0; word < arrayOfWords.length-1; word++) {
            boolean result = checkOneWord(arrayOfWords[word]);
            if (result) {
                System.out.println(arrayOfWords[word]);
            }
        }
    }

    private static boolean checkOneWord(String word) {
        if (word.length()==0) return false;
        return votes.indexOf(word.charAt(0))<0
                && votes.indexOf(word.charAt(word.length()-1))>=0;
    }
}
