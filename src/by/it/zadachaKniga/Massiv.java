package by.it.zadachaKniga;

public class Massiv {
    public static void main(String[] args) {
        int [][] numbers=new int[3][3];
        int [][] number= {{1,2,3},
                         {4,5,6},
                         {7,8,9}};
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length ; j++) {
                System.out.print(number[i][j]+" ");
            }
            System.out.println();
        }
        }
    }

