package by.it.levchuk.levchuk.jd01_12;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputWords = new LinkedList<>();
        while (true) {
            String word = scanner.next();
            if (word.equals("end")) {
                break;
            }
            word=word.replaceAll("[,.?;!]+","");
            if(word.contains("/")){
                String[] arrWords = word.split("/");
                inputWords.addAll(Arrays.asList(arrWords));
            }
            else{
                inputWords.add(word);
            }
        }
        Collections.sort(inputWords);
        System.out.println(inputWords);
        Iterator<String> iterator = inputWords.iterator();
        String firstOneFall = "";
        String currentWord;
        int countIterat=1;
        while (iterator.hasNext()) {
            currentWord = iterator.next();
            if (!firstOneFall.equals("") & !firstOneFall.equals(currentWord)){
                System.out.printf("%s=%d\n",firstOneFall,countIterat);
                countIterat=1;
            }
            if(firstOneFall.equals(currentWord)){
                countIterat++;
            }
            firstOneFall=currentWord;
        }
        System.out.printf("%s=%d\n",firstOneFall,countIterat);
    }
}
