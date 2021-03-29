package by.it.kirichenko.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputWords = new LinkedList<>();
        int posZero = 0;
        while (true) {
            String word = scanner.next();
            if (word.equals("end")) {
                break;
            }
            word=word.replaceAll("[,.?;!]+","");
            if(word.contains("/")){
                String[] arrWords = word.split("/");
                for (String wordRazdel : arrWords) {
                    inputWords.add(wordRazdel);
                }
            }
            else{
                inputWords.add(word);
            }
        }
        Collections.sort(inputWords);
        System.out.println(inputWords);
        Iterator<String> iterator = inputWords.iterator();
        String prevoisWord = "";
        String currentWord = "";
        int countwords=1;
        while (iterator.hasNext()) {
            currentWord = iterator.next();
            if (!prevoisWord.equals("") & !prevoisWord.equals(currentWord)){
                System.out.printf("%s=%d\n",prevoisWord,countwords);
                countwords=1;
            }
            if(prevoisWord.equals(currentWord)){
                countwords++;
            }
            prevoisWord=currentWord;
        }
        if (prevoisWord.equals(currentWord)){
            System.out.printf("%s=%d\n",prevoisWord,countwords);
        }
        else {
            System.out.printf("%s=%d\n",currentWord,1);
        }
    }
}
