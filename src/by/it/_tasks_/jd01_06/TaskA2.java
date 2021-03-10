package by.it._tasks_.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
}
public class TaskA {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
     Matcher matcher = pattern.matcher(Poem.text);
     while (matcher.find()){
         String word = matcher.group();
     }
     prosessOneWord(word);

     for int (i=0; i< words.length);i++);
        System.out.printf("%s=%d\n",words[i],counts[i]);
