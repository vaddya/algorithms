package com.vaddya.polis.module1.eolymp;

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
                switch (s) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        stack.push(-stack.pop() + stack.pop());
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    default:
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
