package by.it.dudko.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> sortedUserList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String strNum = "";
        int baseIndex = 0, currentIndex = 0;
        while (true) {
            strNum = sc.next().trim();
            if (strNum.equals("end"))
                break;
            Integer nextNumber = Integer.valueOf(strNum);
            if (nextNumber > 0) {
                sortedUserList.add(baseIndex++, nextNumber);
            } else if (nextNumber < 0) {
                sortedUserList.add(nextNumber);
            } else {
                sortedUserList.add(baseIndex, nextNumber);
            }
        }
        System.out.println(sortedUserList);
    }
}
