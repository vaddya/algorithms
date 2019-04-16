package com.vaddya.polis.module2.sorting;

/**
 * Merge sort
 *
 * @author vaddya
 * @since November 19, 2016
 */
public class MergeSort {

    public static int[] sort(int[] array) {
        if (array == null) return null;
        int[] temp = new int[array.length];
        sort(array, temp, 0, array.length - 1);
        return array;
    }

    private static void sort(int[] array, int[] temp, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        sort(array, temp, left, mid);
        sort(array, temp, mid + 1, right);
        merge(array, temp, left, mid, right);
    }

    private static void merge(int[] array, int[] temp, int left, int mid, int right) {
        System.arraycopy(array, left, temp, left, right + 1 - left);
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                array[k] = temp[j++];
            } else if (j > right) {
                array[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                array[k] = temp[i++];
            } else {
                array[k] = temp[j++];
            }
        }
    }
}
