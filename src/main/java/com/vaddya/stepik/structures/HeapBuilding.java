package com.vaddya.stepik.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HeapBuilding {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scan.nextInt();
            }
            List<Swap> swaps = heapify(array);
            System.out.println(swaps.size());
            for (Swap swap : swaps) {
                System.out.println(swap.from + " " + swap.to);
            }
        }
    }

    /**
     * Построение кучи
     * <p>
     * Переставить элементы заданного массива чисел так, чтобы он удовлетворял свойству мин-кучи.
     * Вход. Массив чисел A[0...n − 1].
     * Выход. Переставить элементы массива так, чтобы выполнялись неравенства
     * A[i] ≤ A[2i + 1] и A[i] ≤ A[2i + 2] для всех i.
     */
    public static List<Swap> heapify(int[] array) {
        HeapBuilder builder = new HeapBuilder(array);
        builder.heapify();
        return builder.history();
    }

    public static class HeapBuilder {
        private final int[] data;
        private final int size;
        private final List<Swap> history;

        public HeapBuilder(int[] array) {
            this.data = array;
            this.size = array.length;
            this.history = new ArrayList<>();
        }

        public List<Swap> history() {
            return history;
        }

        public void heapify() {
            for (int i = data.length / 2; i >= 0; i--) {
                siftDown(i);
            }
        }

        private void siftDown(int i) {
            int left = leftOf(i);
            int right = rightOf(i);
            while (left <= size - 1) {
                if (right > size - 1) {
                    if (data[i] > data[left]) {
                        swap(data, i, left);
                    }
                    break;
                }
                if (data[i] > data[left]) {
                    if (data[i] <= data[right]) {
                        swap(data, i, left);
                        i = left;
                    } else {
                        int min = data[left] > data[right]
                                ? right
                                : left;
                        swap(data, i, min);
                        i = min;
                    }
                } else if (data[i] > data[right]) {
                    swap(data, i, right);
                    i = right;
                } else {
                    break;
                }
                left = leftOf(i);
                right = rightOf(i);
            }
        }

        private int leftOf(int i) {
            return i * 2 + 1;
        }

        private int rightOf(int i) {
            return i * 2 + 2;
        }

        private void swap(int[] array, int i, int j) {
            Swap swap = new Swap(i, j);
            swap.perform(array);
            history.add(swap);
        }
    }

    public static class Swap {
        public final int from;
        public final int to;

        public Swap(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public void perform(int[] array) {
            assert array.length > from && array.length > to;
            int temp = array[from];
            array[from] = array[to];
            array[to] = temp;
        }
    }
}
