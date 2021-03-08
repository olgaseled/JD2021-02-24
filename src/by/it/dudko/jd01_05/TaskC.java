package by.it.dudko.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    
    
    public static void main(String[] args) {
        step1();
    }
    
    
    private static void step1() {
        final int minLength = 20;
        final int maxLength = 40;
        final double minRange = 5.33;
        final double maxRange = 9.0;
        
        int arrLength = minLength +
            (int)round(random() * (maxLength - minLength));
        double[] myArr = new double[arrLength];
        double step = (maxRange - minRange) / (arrLength - 1);
        
        for (int i=0; i<arrLength; i++) {
            double x = minRange + i * step;
            double z = cbrt(x*x + 4.5);
            myArr[i] = z;
        }
        
        System.out.println("Массив A[]");
        formattedOutput(myArr, "A", 5);
        
        double[] filteredArr = filterByValue(myArr, 3.5);
        System.out.println("Массив B[] из элементов массива A > 3.5");
        formattedOutput(filteredArr, "B", 5);
        
        double m = getSredGeom(filteredArr);
        System.out.println(m);
    }
    
    
    private static void formattedOutput(double[] arr, String name , int col) {
        for (int i=0; i<arr.length; i++) {
            System.out.printf("%s[% -4d] = %f", name, i, arr[i]);
            if (i+1 % col != 0 && i + 1 < arr.length) {
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
            if (elem > 3.5) {
                bufferArr[filterIndex++] = elem;
            }
        }
        double[] filteredArr = new double[filterIndex];
        for (int i=0; i<filterIndex; i++) {
            filteredArr[i] = bufferArr[i];
        }
        return filteredArr;
    }
    
    
    private static double getSredGeom(double[] arr) {
        double multiplication = 1.0;
        for (double elem: arr) {
            multiplication*=elem;
        }
        if (arr.length != 0) {
            return pow(multiplication, 1/arr.length); 
        } else {
            return 0;
        }
    }
}