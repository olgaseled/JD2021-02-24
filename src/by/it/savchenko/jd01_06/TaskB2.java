package by.it.savchenko.jd01_06;

public class TaskB2 {
    public static void main(String[] args) {

        String text = Poem.text;
        text = text.replace("...", "");
        String poem = text.replaceAll("[^а-яА-ЯёЁ.!?]+", " ");
        String[] split = poem.split("\\s*[.!?]\\s*");
        sortText(split);
        for (String elements : split) {
            System.out.println(elements);
        }
    }

    static void sortText(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            String d = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1].length() > d.length()) {
                arr[j] = arr[j - 1];
                j = j - 1;
            }
            arr[j] = d;
        }
    }
}
