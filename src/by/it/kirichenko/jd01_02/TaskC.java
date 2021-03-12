package by.it.kirichenko.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matr = new int[n][n];
        matr=step1(n);
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if ((j+1)%n==0)
                    System.out.println(matr[i][j]);
                else
                    System.out.print(matr[i][j]+" ");
            }
        }

    }

    private static int[][] step1(int n) {
        int[][] matr = new int[n][n];
        matr[0][0]=1;
        boolean min = false;
        boolean max = false;
        do {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matr[i][j] = getRandomInteger(-n, n);
                    if(matr[i][j]==-n){
                        min=true;
                    }
                    else if(matr[i][j]==n){
                        max=true;
                    }
                }
            }
        }while(min==false|max==false);
        return matr;
    }

    public static int getRandomInteger(int min, int max){
        //double x = (int)(Math.random()*((max-min)+1))+min;
        return (int)(Math.random()*((max-min)+1))+min;
    }
}
