package com.vaddya.algorithms.sorting;

/**
 * Counting sort com.vaddya.algorithms
 *
 * @author vaddya
 * @since November 08, 2016
 */
public class CountingSort {

    public static int[] sort(int[] array) {
        if (array == null) return null;
        int min = findMin(array);
        int max = findMax(array);
        int n = max - min + 1;
        int[] values = new int[n];
        for (int i : array) values[i - min]++;
        int pos = 0;
        for (int i = 0; i < n; i++) {
            while (values[i]-- > 0) {
                array[pos++] = i + min;
            }
        }
        return array;
    }

    private static int findMin(int[] array) {
        int min = array[0];
        for (int i : array) {
            min = i < min ? i : min;
        }
        return min;
    }

    private static int findMax(int[] array) {
        int max = array[0];
        for (int i : array) {
            max = i > max ? i : max;
        }
        return max;
    }
}
