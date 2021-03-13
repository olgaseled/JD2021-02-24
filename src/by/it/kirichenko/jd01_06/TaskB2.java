package by.it.kirichenko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        //StringBuilder text = new StringBuilder(Poem.text);
        String text = Poem.text;
        Pattern patternMinusLishnieChars = Pattern.compile("[^а-яА-ЯёЁ\\.!]+");
        Matcher matcherMinusLishnieChars = patternMinusLishnieChars.matcher(text);

        String textMinusLishnieChars = matcherMinusLishnieChars.replaceAll(" ");

        Pattern patternMminusLishnieDots = Pattern.compile("[\\.]{2,}");
        Matcher matcherMminusLishnieDots = patternMminusLishnieDots.matcher(textMinusLishnieChars);

        String textMinusLishnieAllChars = matcherMminusLishnieDots.replaceAll("");

        Pattern patternPredlozhenie = Pattern.compile("[а-яА-ЯёЁ ]+");
        Matcher matcherPredlozhenie = patternPredlozhenie.matcher(textMinusLishnieAllChars);
        String[] arrayPredlozhTemp = new String[100];
        int k = 0;
        while (matcherPredlozhenie.find()) {
            arrayPredlozhTemp[k] = matcherPredlozhenie.group().trim();
            k++;
        }
        int countPredlozh = k;

        String[] arrayPredlozh = new String[countPredlozh];
        for (int i = 0; i < countPredlozh; i++) {
            arrayPredlozh[i] = arrayPredlozhTemp[i];
        }

        arraySort(arrayPredlozh);

        printArray(arrayPredlozh);
        // System.out.println(textMinusLishnieAllChars);


    }

    private static void arraySort(String[] array) {
        boolean swap;
        int last = array.length - 1;
        do {
            swap = false;
            for (int j = 0; j < last; j++) {
                if (array[j].length() > array[j + 1].length()) {
                    String buffer = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = buffer;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);
    }

    private static void printArray(String[] array){
        for (String value: array){
            System.out.println(value);
        }
    }
}
