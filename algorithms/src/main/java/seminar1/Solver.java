package seminar1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * №5.1
 * ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) = 101
 * ( 1 + ( 5 * ( 4 * 5 ) ) ) ( 1 + ( 5 * 20 ) ) = 101
 * ( 1 + 100 ) = 101
 * <p>
 * Считаем, что операции деления на ноль отсутствуют
 */
public class Solver {

    private static final String QUIT = "q";

    private static final String LEFT_PAREN = "(";
    private static final String RIGHT_PAREN = ")";
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String TIMES = "*";
    private static final String DIVISION = "/";

    private static double evaluate(String[] values) {
        Stack<String> ops = new Stack<>();
        Stack<Double> nums = new Stack<>();
        for (String s : values) {
            switch (s) {
                case PLUS:
                case MINUS:
                case TIMES:
                case DIVISION:
                    ops.push(s);
                    break;
                case RIGHT_PAREN:
                    nums.push(calculate(nums.pop(), nums.pop(), ops.pop()));
                    break;
                case LEFT_PAREN:
                default:
                    nums.push(Double.parseDouble(s));
            }
        }
        return nums.pop();
    }

    private static double calculate(double x, double y, String op) {
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
