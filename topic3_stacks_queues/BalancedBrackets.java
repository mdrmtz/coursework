import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }

        return stack.isEmpty();
    }
 private static String mLine;
/*
    Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
* */

    public static void parseArguments(Scanner scanner) {
        mLine = scanner.nextLine();
    }

    private static void iterate() {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : mLine.toCharArray()) {
            if (stack.size() > mLine.length() / 2) {
                System.out.println("NO");
                return;
            }
            if (!isClose(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                if (getClose(stack.pop()) != c) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static char getClose(char bracket) {
        return switch (bracket) {
            case '{' -> '}';
            case '(' -> ')';
            case '[' -> ']';
            default -> ' ';
        };
    }

    private static boolean isClose(char bracket) {
        return bracket == '}' || bracket == ')' || bracket == ']';
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int numberTestCases = scanner.nextInt();
        scanner.nextLine();
        while (numberTestCases > 0) {
            parseArguments(scanner);
            numberTestCases--;
            iterate();
        }
    }
}
