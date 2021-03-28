package by.it.kaminskii.jd01_12;/* created by Kaminskii Ivan
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> listArr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String str;
        int pos = 0;
        while (!(str = sc.next()).equals("end")) {
            Integer value = Integer.valueOf(str);
            if (value > 0)
                listArr.add(pos++, value);
            else if (value == 0)
                listArr.add(pos, value);
            else
                listArr.add(value);
        }
        System.out.println(listArr);
    }
}