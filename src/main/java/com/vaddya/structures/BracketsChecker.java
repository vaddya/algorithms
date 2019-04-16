package com.vaddya.structures;

import java.util.Scanner;
import java.util.Stack;

public class BracketsChecker {

    private static final char LEFT_PAREN = '(';
    private static final char RIGHT_PAREN = ')';
    private static final char LEFT_BRACE = '{';
    private static final char RIGHT_BRACE = '}';
    private static final char LEFT_BRACKET = '[';
    private static final char RIGHT_BRACKET = ']';

    public static void main(String[] args) {
        String text = new Scanner(System.in).next();
        int error = checkParentheses(text);
        System.out.println(error == -1 ? "Success" : error);
    }

    /**
     * Проверить, правильно ли расставлены скобки в данном коде.
     *
     * @param text Исходный код программы
     * @return Проверить, верно ли расставлены скобки. Если нет, выдать индекс первой ошибки.
     */
    public static int checkParentheses(String text) {
        Stack<Character> stack = new Stack<>();
        int i = 1;
        int indexOfFirstUnpairedLeft = 0;
        for (char curr : text.toCharArray()) {
            switch (curr) {
                case LEFT_PAREN:
                case LEFT_BRACE:
                case LEFT_BRACKET:
                    if (stack.isEmpty()) {
                        indexOfFirstUnpairedLeft = i;
                    }
                    stack.push(curr);
                    break;
                case RIGHT_PAREN:
                    if (stack.isEmpty() || stack.pop() != LEFT_PAREN) {
                        return i;
                    }
                    break;
                case RIGHT_BRACE:
                    if (stack.isEmpty() || stack.pop() != LEFT_BRACE) {
                        return i;
                    }
                    break;
                case RIGHT_BRACKET:
                    if (stack.isEmpty() || stack.pop() != LEFT_BRACKET) {
                        return i;
                    }
                    break;
            }
            i++;
        }
        if (!stack.isEmpty()) {
            return indexOfFirstUnpairedLeft;
        }
        return -1;
    }
}