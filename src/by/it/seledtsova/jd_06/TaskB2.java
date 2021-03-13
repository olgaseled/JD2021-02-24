package by.it.seledtsova.jd_06;

public class TaskB2 {
    public static void main(String[] args) {

        String text = Poem.text;
        // 1. delete ...
        text = text.replace("...", "");
        // 2. split
        String[] sentences = text.split("[.!?]");
        //3. del non-letters;
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = sentences[i].replaceAll("[^а-яА-ЯёЁ]+", " ").trim();
                }


        for (int i = 0; i <= sentences.length - 1; i++) { // строка в массиве
            for (int j = i + 1; j <= sentences.length - 1; j++) { // след строка
                if (sentences[i].length() > sentences[j].length()) {
                    String buffer = sentences[i]; // запомнили строку
                    sentences[i] = sentences[j]; //заменили строку
                    sentences[j] = buffer; // завершили перестановку
                }
            }
        }
            System.out.print(String.join("\n", sentences));
        }
    }























