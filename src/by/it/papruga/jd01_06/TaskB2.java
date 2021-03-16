package by.it.papruga.jd01_06;

public class TaskB2 {

    public static void main(String[] args) {
        String text = Poem.text;
        //1. del...
        text = text.replace("...", "");
        //2. split
        String[] sentences = text.split("[.?!]");
        //3. del non-letters

        for (int i = 0; i < sentences.length; i++) {

            sentences[i] = sentences[i].replaceAll("[^а-яА-ЯёЁ]+", " ").trim();
        }

        for (int i = 0; i < sentences.length; i++) {

            for (int j = i + 1; j < sentences.length; j++) {

                if (sentences[i].length() > sentences[j].length()) {
                    String buffer = sentences[i];
                    sentences[i] = sentences[j];
                    sentences[j] = buffer;
                }

            }
        }

        for (String sentence : sentences) {

            System.out.println(sentence);

        }


    }
}



