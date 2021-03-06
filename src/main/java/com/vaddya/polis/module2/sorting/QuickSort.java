package com.vaddya.polis.module2.sorting;

import static com.vaddya.algorithms.Utils.swap;

/**
 * Quick Sort - фиксированный выбор опорного элемента
 *
 * @author vaddya
 * @since November 19, 2016
 */
public class QuickSort {

    public static int[] sort(int[] array) {
        if (array == null) return null;
        sort(array, 0, array.length - 1);
        return array;
    }

    private static void sort(int[] array, int left, int right) {
        if (left >= right) return;
        int pivot = partition(array, left, right);
        sort(array, left, pivot);
        sort(array, pivot + 1, right);
    }

    private static int partition(int[] a, int l, int r) {
        int x = a[l + (r - l + 1) / 2];
        int i = l;
        int j = r;
        while (i <= j) {
            while (a[i] < x) i++;
            while (a[j] > x) j--;
            if (i <= j) swap(a, i++, j--);
        }
        return j;
    }
}
