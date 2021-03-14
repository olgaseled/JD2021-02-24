package by.it.maksimova.jd01_06;

import java.util.Arrays;

//Вывести через \n все предложения текста в порядке возрастания количества символов (!) в каждом из них.
// В предложениях нужно сначала заменить все небуквенные символы и их последовательности на один пробели
// выполнить trim() для каждого предложения.
public class TaskB2 {
    public static void main(String[] args) {
        //1 delete ...
        String poema = Poem.text;
        poema = poema.replace("...", "");
        // 2 split for sentences
        String[] sentences = poema.split("[.!?]");
        // 3 replace symbols for spaces
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = sentences[i].replaceAll("[^а-яА-ЯёЁ]+", " ").trim();
        }
        sort(sentences);

    }
    // 4 sort sentences from small to big
    private static void sort(String[] sentences) {
        boolean isSorted;
        do {
            isSorted = false;
            int last = sentences.length - 1;
            for (int i = 0; i < last; i++) {
                if (sentences[i].length() > sentences[i + 1].length()) {
                    String buffer = sentences[i];
                    sentences[i] = sentences[i + 1];
                    sentences[i + 1] = buffer;
                    isSorted = true;
                }
            }
        }
        while (isSorted);
        printArray(sentences);

    }

    private static void printArray(String[] sentences) {
        for (int i = 0; i < sentences.length; i++) {
            System.out.printf("%s\n", sentences[i]);
        }
    }
}


