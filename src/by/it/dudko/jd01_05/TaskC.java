package by.it.dudko.jd01_05;

import static java.lang.Math.*;

public class TaskC {


    public static void main(String[] args) {
        step1();
        step2();
    }


    private static void step1() {
        final int minLength = 20;
        final int maxLength = 40;
        final double minRange = 5.33;
        final double maxRange = 9.0;

        int arrLength = minLength +
                (int) round(random() * (maxLength - minLength));
        double[] myArr = new double[arrLength];
        double step = (maxRange - minRange) / (arrLength - 1);

        for (int i = 0; i < arrLength; i++) {
            double x = minRange + i * step;
            double z = cbrt(x * x + 4.5);
            myArr[i] = z;
        }

        System.out.println("Массив A[]");
        formattedOutput(myArr, "A", 5);

        double[] filteredArr = filterByValue(myArr, 3.5);
        System.out.println("Массив B[] из элементов массива A > 3.5");
        formattedOutput(filteredArr, "B", 5);

        double m = getAvgGeom(filteredArr);
        System.out.println(m);
    }

    public static void step2() {
        final int ARR_LEN = 31;
        final int COLUMNS_A = 3;
        int[] arrA = new int[ARR_LEN];
        for (int i = 0; i < ARR_LEN; i++) {
            arrA[i] = getRandomNumberFromRange(103, 450, true);
        }
        printArray(arrA, "A", COLUMNS_A, false);

        int[] arrB = customArrayFilter(arrA);
        Helper.sort(arrB);
        // final int COLUMNS_B = (int) ceil((double) arrB.length / COLUMNS_A);
        printArray(arrB, "B", 5, true);
    }


    private static void formattedOutput(double[] arr, String name, int col) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -4d] = %f", name, i, arr[i]);
            if (i + 1 % col != 0 && i + 1 < arr.length) {
                System.out.print('\t');
            } else {
                System.out.print('\n');
            }
        }
    }


    private static double[] filterByValue(double[] arr, double thresh) {
        int filterIndex = 0;
        double[] bufferArr = new double[arr.length];
        for (double elem : arr) {
            if (elem > thresh) {
                bufferArr[filterIndex++] = elem;
            }
        }
        double[] filteredArr = new double[filterIndex];
        for (int i = 0; i < filterIndex; i++) {
            filteredArr[i] = bufferArr[i];
        }
        return filteredArr;
    }


    private static double getAvgGeom(double[] arr) {
        double multiplication = 1.0;
        for (double elem : arr) {
            multiplication *= elem;
        }
        if (arr.length != 0) {
            return pow(multiplication, 1.0 / arr.length);
        } else {
            return 0;
        }
    }

    private static int[] customArrayFilter(int[] arr) {
        int filterCount = 0;
        int[] bufferArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (filterCondition(i, arr[i])) {
                bufferArray[filterCount++] = arr[i];
            }
        }
        int[] filteredArr = new int[filterCount];
        for (int i = 0; i < filterCount; i++) {
            filteredArr[i] = bufferArray[i];
        }
        return filteredArr;
    }


    private static boolean filterCondition(int index, int value) {
        return index < value * 0.1;
    }


    static int getRandomNumberFromRange(int from, int to, boolean inclFlag) {
        if (inclFlag) {
            return (int) (random() * (to - from + 1)) + from;
        } else {
            return (int) (random() * (to - from)) + from;
        }
    }


    /**
     * @param arr  array of integers
     * @param name array's name to print before it's indices
     *             totalColumns - number of table columns
     *             paddingLength - horizontal gap between the cell border and cell content
     *             constantLength - includes length of special characters []=
     *             indexLength - number of digits of integer array key
     *             valueLength - maximum number of digits of the array item integer value
     */
    public static void printArray(int[] arr, String name, int cols, boolean isVertical) {
        int totalColumns = cols;
        int paddingLength = 3;
        int constantLength = 3;
        int indexLength = 2;
        int valueLength = 3;

        if (!isVertical)
            System.out.printf("\nArray %s (index to rows)\n", name);
        else
            System.out.printf("\nArray %s (index to cols)\n", name);

        int cellWidth = 2 * paddingLength + name.length() + constantLength + indexLength + valueLength;
        int rowCount = (int) ceil((double) arr.length / totalColumns);

        for (int currentRow = 0; currentRow < rowCount; currentRow++) {
            if (currentRow == 0) { // first row
                printBorder("top", cellWidth, totalColumns);
                printData(arr, name, currentRow, cellWidth, totalColumns, indexLength, valueLength, paddingLength, isVertical);
            } else if (currentRow == rowCount - 1) { // last row
                printBorder("between", cellWidth, totalColumns);
                printData(arr, name, currentRow, cellWidth, totalColumns, indexLength, valueLength, paddingLength, isVertical);
                printBorder("bottom", cellWidth, totalColumns);
            } else { // another row
                printBorder("between", cellWidth, totalColumns);
                printData(arr, name, currentRow, cellWidth, totalColumns, indexLength, valueLength, paddingLength, isVertical);
            }
        }
    }


    static void printBorder(String borderType, int cellWidth, int columnsNumber) {
        char plainBorder = '\u2550';
        char topLeftCorner = '\u2554';
        char topCross = '\u2566';
        char topRightCorner = '\u2557';
        char leftCross = '\u2560';
        char middleCross = '\u256c';
        char rightCross = '\u2563';
        char bottomLeftCorner = '\u255a';
        char bottomCross = '\u2569';
        char bottomRightCorner = '\u255d';

        char rowLeft, rowCross, rowRight, rowPlain;
        rowPlain = plainBorder;
        switch (borderType) {
            case "top":
                rowLeft = topLeftCorner;
                rowCross = topCross;
                rowRight = topRightCorner;
                break;
            case "between":
                rowLeft = leftCross;
                rowCross = middleCross;
                rowRight = rightCross;
                break;
            case "bottom":
                rowLeft = bottomLeftCorner;
                rowCross = bottomCross;
                rowRight = bottomRightCorner;
                break;
            default:
                rowLeft = '?';
                rowCross = '?';
                rowRight = '?';
        }

        String cellBorder = "";
        for (int len = 0; len < cellWidth; len++) {
            cellBorder += rowPlain;
        }

        String rowBorder = "";
        for (int col = 0; col < columnsNumber; col++) {
            rowBorder = (col + 1 != columnsNumber)
                    ? rowBorder + cellBorder + rowCross
                    : rowBorder + cellBorder;
        }

        System.out.printf("%s%s%s\n", rowLeft, rowBorder, rowRight);

    }

    static void printData(int[] arr, String name, int currentRow, int cellWidth, int totalColumns,
                          int indexLength, int valueLength, int paddingLength, boolean isVertical) {
        char verticalBorder = '\u2551';
        String dataFormat = String.format("%%s%%%ss%%s[%%%dd]=%%%dd%%%ss", paddingLength, indexLength, valueLength, paddingLength);
        String paddingString = "";
        String dummyData = "";
        String dummyFormat = String.format("%%s%%%ss", cellWidth);
        int rows = (int) ceil((double) arr.length / totalColumns);
        for (int i = 0; i < totalColumns; i++) {
            int currentArrItem = (!isVertical) ? currentRow * totalColumns + i : currentRow + i * rows;
            if (currentArrItem < arr.length) { // non-existing array element check
                int data = arr[currentArrItem];
                System.out.printf(dataFormat, verticalBorder, paddingString, name, currentArrItem, data, paddingString);
            } else {
                System.out.printf(dummyFormat, verticalBorder, dummyData);
            }
        }
        System.out.printf("%s\n", verticalBorder);
    }
}