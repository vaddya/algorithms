package com.vaddya.stepik.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextPatternSearch {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            String pattern = scan.nextLine();
            String text = scan.nextLine();
            List<Integer> patterns = findPattern(text, pattern);
            for (Integer p : patterns) {
                System.out.print(p + " ");
            }
        }
    }

    /**
     * Поиск образца в тексте
     * <p>
     * Найти все вхождения строки Pattern в строку Text.
     * Вход. Строки Pattern и Text.
     * Выход. Все индексы i строки Text, начиная с которых строка Pattern входит в Text:
     * Text[i..i + |Pattern| − 1] = Pattern.
     */
    public static List<Integer> findPattern(String text, String pattern) {
        List<Integer> results = new ArrayList<>();
        String initial = text.substring(0, pattern.length());
        if (initial.equals(pattern)) {
            results.add(0);
        }

        int patternHash = new SlidingHasher(pattern).hash;
        SlidingHasher hasher = new SlidingHasher(initial);
        for (int i = pattern.length(); i < text.length(); i++) {
            hasher.slide(text.charAt(i));
            if (hasher.hash == patternHash) {
                int index = i - pattern.length() + 1;
                String sub = text.substring(index, index + pattern.length());
                if (sub.equals(pattern)) {
                    results.add(index);
                }
            }
        }

        return results;
    }

    private static class SlidingHasher {
        private final int[] window;
        private int index;
        private int hash;

        public SlidingHasher(String initial) {
            this.window = initial.chars().toArray();
            this.index = 0;
            this.hash = 0;
            for (int c : window) {
                this.hash += c;
            }
        }

        public void slide(int next) {
            int old = window[index];
            hash = hash - old + next;
            window[index] = next;
            index = (index + 1) % window.length;
        }
    }
}
