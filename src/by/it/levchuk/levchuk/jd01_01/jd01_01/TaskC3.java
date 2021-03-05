package by.it.levchuk.levchuk.jd01_01.jd01_01;

import java.util.Scanner;

/*
Ускорение свободного падения на Земле и Марсе таково:
Марс   3.86
Земля   9.81

С клавиатуры вводится вес человека в килограммах.
Рассчитайте вес человека на Марсе и выведите
округлив его до сотых килограмма (2 знака)

Создайте для этих целей метод getWeight(int weight)

Требования:
1.  Метод getWeight(int weight) должен быть статическим.
2.  Метод getWeight должен возвращать значение типа double.
3.  Метод getWeight должен ОБЯЗАТЕЛЬНО округлять до сотых возвращаемое значение
    типа double внутри самого метода.
4.  Метод getWeight не должен ничего выводить на экран.
5.  Метод getWeight должен правильно переводить вес тела в килограммах на Земле
    в вес этого же тела на Марсе, и возвращать это значение.
6.  Если получится, то пока не используйте в getWeight методы стандартной библиотеки
    (round, ceil, printf, format, и т.п). Возможностей самого языка вполне достаточно.

Пример:

Ввод:
75

Вывод:
29.51

*/
class TaskC3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int we = scanner.nextInt();
        double wm = getWeight(we);
        System.out.println(wm);
    }

    private static double getWeight(int we) {
        double mars = 3.86D;
        double earth = 9.81D;
        double wm = (double)we / 9.81D * 3.86D;
        int we100 = (int)(wm * 100.0D);
        return wm * 100.0D - (double)we100 < 0.5D ? (double)we100 / 100.0D : (double)(we100 + 1) / 100.0D;
    }
}


