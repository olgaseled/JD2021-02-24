package by.it.kaminskii.jd01_12;/* created by Kaminskii Ivan
 */

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        LinkedList<String> text = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String line;
        while (!(line = scanner.next()).equals("end")) {
            line = line.replaceAll("[.!?,;:]+", "");
            System.out.println(line);
            text.add(line);
        }
        for (int i = 0; i < text.size(); i++) {

            String word = text.get(i);
            int col = 0;
            for (int j = 0; j < text.size(); j++) {
                String next = text.get(j);
                if (word.equals(next)) {
                    col++;
                }
            }
            System.out.println(word +"="+ col);
        }
    }
}
