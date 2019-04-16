package com.vaddya.polis.module2.sorting;

import static com.vaddya.algorithms.Utils.swap;

/**
 * Сортировка Шелла
 *
 * @author vaddya
 * @since November 19, 2016
 */
public class ShellSort {

    public static int[] sort(int[] array) {
        if (array == null) return null;
        int n = array.length;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h > 0) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && array[j] < array[j - h]; j -= h) {
                    swap(array, j, j - h);
                }
            }
            h /= 3;
        }
        return array;
    }
}
