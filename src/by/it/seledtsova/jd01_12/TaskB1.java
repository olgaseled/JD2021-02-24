package by.it.seledtsova.jd01_12;

//TaskB1.Нужно ввести с консоли текст на английском языке до строки “end”(100 и более слов).
//        Для каждого слова с помощью коллекций подсчитать частоту его встречаемости.
//        Вывести все различныеслова формате слово=частота.Слова, отличающиеся регистром букв,
//        считать различными. isn't или don’t –одно слово.


import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       List<String> result = new ArrayList<>();

        while (true) {
            String word = scanner.next(); // слова будут вводися, пока не будет слово "end"
            if (word.equals("end")) { //сравнении объектов между собой
                break;
                        }
            else result.add(word);
        }
        System.out.println(result);

      //  Map<String,Integer> hashMap=new HashMap<String,Integer>();

        }

    }

/*
Meet my family. There are five of us – my parents, my elder brother,
my baby sister and me. First, meet my mum and dad, Jane and Michael. My mum enjoys reading
 and my dad enjoys playing chess with my brother Ken. My mum is slim and rather tall.
 */