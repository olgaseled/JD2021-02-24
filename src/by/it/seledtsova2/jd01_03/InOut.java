package by.it.seledtsova2.jd01_03;

public class InOut {
    //  String line="71 12 14 789 565 76 712";
    static double[] getArray(String line) {
        line = line.trim();
        String[] elementString = line.split(" "); // создали массив из строки
        int count = elementString.length;
        double[] arrayFromString = new double[count];
        for (int i = 0; i < arrayFromString.length; i++) {
            arrayFromString[i] = Double.parseDouble(elementString[i]);
        }
        return arrayFromString;
    }

    static void printArray(double[] arrayFromString) {
        for (int i = 0; i < arrayFromString.length; i++) {
            System.out.println(arrayFromString[i]);
        }
        System.out.println();
    }

    static void printArray(double[] arrayFromString, String name, int columnCount) {
        for (int i = 0; i < arrayFromString.length; i++) {
            System.out.println(name);
            System.out.printf("%s[% -3d]=%-10.4f", name, i, arrayFromString[i]);
            if ((i + 1) % columnCount == 0 || i + 1 == arrayFromString.length) {

                System.out.println();
            }
        }
    }
}



