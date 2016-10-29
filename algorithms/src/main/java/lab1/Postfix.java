package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.e-olymp.com/ru/problems/1586
 *
 * @author vaddya
 */
public class Postfix {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        try (Scanner in = new Scanner(new File("input.txt"))) {
            PrintWriter writer = new PrintWriter("output.txt");

            String[] postfix = in.nextLine().split("\\s+");
            for (String s : postfix) {
                if ("+".equals(s)) {
                    stack.push(stack.pop() + stack.pop());
                } else if ("-".equals(s)) {
                    stack.push(-stack.pop() + stack.pop());
                } else if ("*".equals(s)) {
                    stack.push(stack.pop() * stack.pop());
                } else {
                    stack.push(Integer.parseInt(s));
                }
            }

            writer.print(stack.pop());
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
