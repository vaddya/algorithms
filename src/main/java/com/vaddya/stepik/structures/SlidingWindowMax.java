package com.vaddya.stepik.structures;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SlidingWindowMax {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scan.nextInt();
            }
            int windowSize = scan.nextInt();
            int[] max = windowMax(array, windowSize);
            for (int m : max) {
                System.out.print(m + " ");
            }
        }
    }

    /**
     * Максимум в скользящем окне
     * Найти максимум в каждом окне размера m данного массива чисел A[1...n].
     * Вход. Массив чисел A[1...n] и число 1 ≤ m ≤ n.
     * Выход. Максимум подмассива A[i...i + m − 1] для всех 1 ≤ i ≤ n − m + 1.
     */
    public static int[] windowMax(int[] array, int windowSize) {
        int[] max = new int[array.length - windowSize + 1];
        Deque<ValueTtl> deque = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst().ttl <= i) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.getLast().value <= array[i]) {
                deque.removeLast();
            }
            deque.addLast(new ValueTtl(array[i], i + windowSize));
            if (!deque.isEmpty() && i - windowSize + 1 >= 0) {
                max[i - windowSize + 1] = deque.peekFirst().value;
            }
        }
        return max;
    }

    private static class ValueTtl {
        final int value;
        final int ttl;

        ValueTtl(int value, int ttl) {
            this.value = value;
            this.ttl = ttl;
        }
    }
}
