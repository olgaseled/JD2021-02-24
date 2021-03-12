package by.it._classwork_.jd01_06;

public class TaskB1 {

    private static final String votes="уеэоаыяиюёУЕЫАОЭЯИЮЁ"; //гласные

    public static void main(String[] args) {
        System.out.println(check("Cлово"));
        System.out.println(check("ещё"));
        System.out.println(check("итак"));
        System.out.println(check("конец"));
    }

    private static boolean check(String word) { //какое-то слово
        String fistLetter = word.substring(0, 1); //первая буква
        String lastLetter = word.substring(word.length() - 1); //последняя буква
        boolean firstOk = !votes.contains(fistLetter); //проверим, что первой нет в гласных
        boolean lastOk = votes.contains(lastLetter); //проверим, что последняя есть в гласных
        return firstOk && lastOk;
    }
}
