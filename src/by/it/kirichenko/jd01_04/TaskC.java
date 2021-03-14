package by.it.kirichenko.jd01_04;

import by.it.kirichenko.jd01_03.InOut;

public class TaskC {
    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length-1];
        //InOut.printArray(array);
        InOut.printArray(array, "V", 5);
        //Helper.sort(array);
        //mergeSort(array, 0, array.length-1);
        mergeSort(array);
        InOut.printArray(array, "V          ", 4);
        for (int i = 0; i < array.length; i++) {
            if(array[i]==first){
                System.out.printf("Index of first element=%d\n", i);
                break;
            }
        }
        //int indexLast= Arrays.binarySearch(array,last);

        for (int i = 0; i < array.length; i++) {
            if(array[i]==last){
                System.out.printf("Index of last element=%d\n", i);
                break;
            }
        }
    }

    static void mergeSort(double[] array){
        mergeSort(array, 0, array.length-1);
    }
    static void mergeSort(double[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left+right)/2;
        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array, left, mid, right);
    }

    static void merge(double[] array, int left, int mid, int right) {
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        double leftArray[] = new double [lengthLeft];
        double rightArray[] = new double [lengthRight];

        for (int i = 0; i < lengthLeft; i++)
            leftArray[i] = array[left+i];
        for (int i = 0; i < lengthRight; i++)
            rightArray[i] = array[mid+i+1];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = left; i < right + 1; i++) {
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            else if (leftIndex < lengthLeft) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }
            else if (rightIndex < lengthRight) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
}
