package by.it.voitsekhovskiy.jd01_01;

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
//class TaskC3 {
//
//    public static double getWeight(int a) {
//        double divisionMars = 3.86 / 9.81;
//        double res = divisionMars * a;
//        return Double.valueOf(String.format(Locale.ROOT, "%.2f", res));
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int weightEarth = sc.nextInt();
//        double i = getWeight(weightEarth);
//        System.out.println(i);
//    }
//}

class TaskC3 {

//    public static double getWeight(int a) {
//        double divisionMars = 3.86 / 9.81;
//        double res = divisionMars * a;
//        String[] arr = String.valueOf(res).split("\\.");
//        String[] fractional  = arr[1].split("");
//        String[] newFractional = {};
//        for (int i = 0; i <3 ; i++) {
//            if (i == 2) {
//                if (Integer.valueOf(fractional[2]) >= 5) {
//                    newFractional[1] = newFractional[1] + 1;
//            } else {
//                newFractional[i] = fractional[i];
//            }
//            }
//        }
//        String.concat()
//        return res;
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int weightEarth = sc.nextInt();
//        double i = getWeight(weightEarth);
        System.out.println(Math.round(3.86/9.81*80*1000.00) / 1000.00);
    }
}