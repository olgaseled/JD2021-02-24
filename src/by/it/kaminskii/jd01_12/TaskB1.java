package by.it.kaminskii.jd01_12;/* created by Kaminskii Ivan
 */

import by.it.kaminskii.jd01_11.ListB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB1 {
    static List<String> text = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        text.add(scanner.next());
        while (text.iterator().hasNext()) {
            System.out.print(text+ "гы");
        }
    }
}
