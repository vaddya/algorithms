package module1.seminar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * №6.1
 * ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) = 101
 * ( 1 + ( 5 * ( 4 * 5 ) ) )
 * ( 1 + ( 5 * 20 ) ) = 101
 * ( 1 + 100 ) = 101
 * <p>
 * 1 + ( 2 + 3 ) * 4 * 5 = 101
 * 1 + 5 * 4 * 5 = 101
 * 1 + 5 * 20 = 101
 * 1 + 100 = 101
 * 20 / 4 = 5
 * (101 - 1) / 5 = 20 // только если с пробелами
 * <p>
 * Считаем, что операции деления на ноль отсутствуют
 */
public class SolverExt {

    private static final String QUIT = "q";

    private static final char LEFT_PAREN = '(';
    private static final char RIGHT_PAREN = ')';
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char TIMES = '*';
    private static final char DIVISION = '/';

    private static double evaluate(String[] values) {
        Stack<Character> ops = new Stack<>();
        Stack<Double> nums = new Stack<>();
        for (String s : values) {
            try {
                nums.push(Double.parseDouble(s));
            } catch (NumberFormatException e) {
                if (s.length() != 1) return 0;
                char c = s.charAt(0);
                switch (c) {
                    case PLUS:
                    case MINUS:
                    case TIMES:
                    case DIVISION:
                        ops.push(c);
                        break;
                    case RIGHT_PAREN:
                        nums.push(calculate(nums.pop(), nums.pop(), ops.pop()));
                        break;
                    case LEFT_PAREN:
                    default:
                        break;
                }
            }
        }
        while (nums.size() > 1) {
            nums.push(calculate(nums.pop(), nums.pop(), ops.pop()));
        }
        return nums.pop();
    }

    private static double calculate(double x, double y, char op) {
        switch (op) {
            case PLUS:
                return y + x;
            case MINUS:
                return y - x;
            case TIMES:
                return y * x;
            case DIVISION:
                return y / x;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in))) {
            String sequence;
            while (!QUIT.equals(sequence = lineReader.readLine())) {
                System.out.println(evaluate(sequence.split(" ")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
