package by.it.voitsekhovskiy.jd01_06;

import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
    }
}
