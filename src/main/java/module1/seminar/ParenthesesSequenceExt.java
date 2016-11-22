package module1.seminar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * №4.1
 * 1. пустая строка — правильная скобочная последовательность;
 * 2. правильная скобочная последовательность,
 * взятая в скобки одного типа — правильная скобочная последовательность;
 * 3. правильная скобочная последовательность,
 * к которой приписана слева или справа правильная скобочная последовательность
 * — тоже правильная скобочная последовательность.
 */
public class ParenthesesSequenceExt {

    private static final String QUIT = "q";

    private static final char LEFT_PAREN = '(';
    private static final char RIGHT_PAREN = ')';
    private static final char LEFT_BRACE = '{';
    private static final char RIGHT_BRACE = '}';
    private static final char LEFT_BRACKET = '[';
    private static final char RIGHT_BRACKET = ']';

    // sequence = "()()" | "(({}[]))[[[" | "{}" | ...
    private static boolean isBalanced(String sequence) {
        Stack<Character> stack = new Stack<>();
        for (char c : sequence.toCharArray()) {
            switch (c) {
                case LEFT_PAREN:
                case LEFT_BRACE:
                case LEFT_BRACKET:
                    stack.push(c);
                    break;
                case RIGHT_PAREN:
                    if (stack.isEmpty() || stack.pop() != LEFT_PAREN) return false;
                    break;
                case RIGHT_BRACE:
                    if (stack.isEmpty() || stack.pop() != LEFT_BRACE) return false;
                    break;
                case RIGHT_BRACKET:
                    if (stack.isEmpty() || stack.pop() != LEFT_BRACKET) return false;
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in))) {
            String sequence;
            while (!QUIT.equals(sequence = lineReader.readLine())) {
                System.out.println(isBalanced(sequence) ? "YES" : "NO");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
