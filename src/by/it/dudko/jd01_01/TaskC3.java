package by.it.dudko.jd01_01;

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

    public static double getWeight(int weight) {
        int ROUNDING = 100; // 2 decimal places
        double G_EARTH = 9.81;
        double G_MARS = 3.86;
        double weightOnMars = weight / G_EARTH * G_MARS;
        double roundedWeightOnMars = (double) ((int) (weightOnMars * ROUNDING)) / ROUNDING;
        // get first decimal place then add 0.5 and convert to integer
        // remainder will be greater than zero if first decimal place is greater than 0.005
        double remainder = (weightOnMars - roundedWeightOnMars) + 0.5 / ROUNDING;
        remainder = (double) ((int) (remainder * ROUNDING)) / ROUNDING;
        roundedWeightOnMars += remainder;

        return roundedWeightOnMars;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter person's weight:");
        int w = sc.nextInt();
        System.out.println(getWeight(w));
    }

}
