package seminar1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
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

    private static Map<String, Integer> priority = new HashMap<>();
    static {
        priority.put(PLUS, 1);
        priority.put(MINUS, 1);
        priority.put(TIMES, 2);
        priority.put(DIVISION, 2);
    }

    private static double evaluate(String[] values) {
        Stack<String> ops = new Stack<>();
        Stack<String> nums = new Stack<>();
        for (String s : values) {
            switch (s) {
                case LEFT_PAREN:

            }
        }
        /* TODO: implement it */
        // Double.valueOf(values[i])
        return 0D;
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
