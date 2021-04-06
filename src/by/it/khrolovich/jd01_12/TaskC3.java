package by.it.khrolovich.jd01_12;

import java.util.*;

public class TaskC3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        char[] chars = expression.toCharArray();

        Stack<Character> stack = new Stack<>();
        boolean check = true;
        for (char aChar : chars) {
            if ((aChar == '{') || (aChar == '[') || (aChar == '(')) {
                stack.push(aChar);//заталкиваем в стек открывающиеся скобки
            } else if ((aChar == '}') || (aChar == ']') || (aChar == ')')) {
                if (stack.empty()) {
                    check = false;
                } else {
                    Character pop = stack.pop();//сравниваем с последним элементом в стеке
                    if (!((pop == '{') && (aChar == '}') ||
                            (pop == '[') && (aChar == ']') ||
                            (pop == '(') && (aChar == ')'))) {
                        check = false;
                        break;
                    }
                }
            }
        }
        System.out.println(check);
    }
}
