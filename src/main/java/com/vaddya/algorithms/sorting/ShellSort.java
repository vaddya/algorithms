package com.vaddya.algorithms.sorting;

import static com.vaddya.algorithms.Utils.swap;

/**
 * Shell sort algorithm
 *
 * @author vaddya
 * @since November 08, 2016
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
