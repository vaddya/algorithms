package com.vaddya.structures;

import java.util.Scanner;
import java.util.Stack;

public class MaxStack {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MaxStack stack = new MaxStack();
        int n = scan.nextInt();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            switch (scan.next()) {
                case PUSH:
                    stack.push(scan.nextInt());
                    break;
                case POP:
                    stack.pop();
                    break;
                case MAX:
                    builder.append(stack.max());
                    builder.append('\n');
                    break;
            }
        }
        System.out.println(builder.toString());
    }

    private static final String PUSH = "push";
    private static final String POP = "pop";
    private static final String MAX = "max";

    private Stack<Integer> max = new Stack<>();

    public void push(int value) {
        if (max.isEmpty()) {
            max.push(value);
        } else {
            max.push(Math.max(value, max.peek()));
        }
    }

    public int pop() {
        return max.pop();
    }

    public int max() {
        return max.peek();
    }

}
