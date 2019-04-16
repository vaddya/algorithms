package com.vaddya.algorithms.sorting;

import java.util.Arrays;

import static com.vaddya.algorithms.Utils.shuffle;
import static com.vaddya.algorithms.Utils.swap;

/**
 * Quick sort algorithm
 *
 * @author vaddya
 */
public class QuickSort {

    public static int[] sort(int[] array) {
        if (array == null) return null;
        shuffle(array);
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
//        int x = a[l + (r - l + 1) / 2];
        int x = a[l];
        int i = l;
        int j = r;
        while (i <= j) {
            while (a[i] < x) i++;
            while (a[j] > x) j--;
            if (i <= j) swap(a, i++, j--);
        }
        return j;
    }

    public static void main(String[] args) {
        int[] x = {6, 11, 8, 1, 4, 13, 5, 7, 2, 15, 14, 10, 3, 12, 9};
        partition(x, 0, x.length - 1);
        System.out.println(Arrays.toString(x));
    }
}
