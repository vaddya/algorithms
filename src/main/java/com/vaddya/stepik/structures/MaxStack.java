package com.vaddya.stepik.structures;

import java.util.Scanner;
import java.util.Stack;

/**
 * Стек с поддержкой максимума
 * Реализовать стек с поддержкой операций push, pop и max.
 * Вход. Последовательность запросов push, pop и max.
 * Выход. Для каждого запроса max вывести максимальное число, находящееся на стеке.
 */
public class MaxStack {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
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
    }

    private static final String PUSH = "push";
    private static final String POP = "pop";
    private static final String MAX = "max";

    private final Stack<Integer> max = new Stack<>();

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
