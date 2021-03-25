package by.it.kaminskii.jd01_01;

public class Main {
    public static void main(String... args) {
        int number = 34;

        // Бинарный формат числа
        String convert = Integer.toBinaryString(number);
        System.out.println(convert);

        // Восьмиричная форма
        convert = Integer.toOctalString(number);
        System.out.println(convert);

        // Шеснадцатиричная форма
        convert = Integer.toHexString(number);
        System.out.println(convert);

    }


}
