package by.it.kishkar.jd01_06;

public class TaskB2 {

    public static void main(String[] args) {
        String text=Poem.text;
        text=text.replace("...", "");
        String [] sent=text.split("[.?!]");
        for (int i = 0; i < sent.length; i++) {
            sent[i]=sent[i].replaceAll("[^а-яА-ЯёЁ]+", " ").trim();

        }

        for (int i = 0; i < sent.length-1; i++) {
            for (int j =i+1 ; j <= sent.length -1; j++) {
                if (sent[i].length()> sent[j].length()){
                    String buf=sent[i];
                    sent[i]=sent[j];
                    sent[j]=buf;


                }
            }

        }
        System.out.println(String.join("\n", sent));

    }
}
