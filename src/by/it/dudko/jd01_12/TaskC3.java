package by.it.dudko.jd01_12;

import java.util.*;

public class TaskC3 {

    private static final Set<String> openBraces = new HashSet<>(Arrays.asList("(", "[", "{"));
    private static final Set<String> closeBraces = new HashSet<>(Arrays.asList(")", "]", "}"));
    private static final Map<String, String> bracesMap =
            new HashMap<>(Map.of("(", ")", "[", "]", "{", "}"));

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bracesHell = sc.nextLine();
        List<String> expression = new LinkedList<>(Arrays.asList(bracesHell.split("")));
        boolean isValidString = validateBraces(expression);
        System.out.println(isValidString);
    }

    private static boolean validateBraces(List<String> expression) {

        String lastOpened = null;
        Deque<String> buffer = new ArrayDeque<>();

        for (String ch : expression) {
            if (openBraces.contains(ch)) {
                // Opening mode
                buffer.add(ch); // add every opening brace to deque
                lastOpened = ch;
                continue;
            }
            if (closeBraces.contains(ch)) {
                // Closing mode
                if (Objects.isNull(lastOpened)) {
                    // error! nothing to close
                    buffer.add("whatever"); // ensures return false
                    break;
                }
                //  Current brace have to conform with last opened
                if (bracesMap.get(lastOpened).equals(ch)) {
                    buffer.pollLast(); // ok. remove last opened
                    lastOpened = buffer.peekLast(); // update last opened
                }
            }
        }

        return buffer.isEmpty();
    }
}
