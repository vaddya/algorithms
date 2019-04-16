package com.vaddya.polis.module2.sorting;

/**
 * Сортировка вставками + бин.поиск + сдвиги
 *
 * @author vaddya
 * @since November 19, 2016
 */
public class InsertionSortAdv {

    public static int[] sort(int[] array) {
        if (array == null) return null;
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int k = binarySearch(array, array[i], -1, j + 1);
            int val = array[i];
            System.arraycopy(array, k, array, k + 1, i - k); // сдвиг
            array[k] = val;
        }
        return array;
    }

    private static int binarySearch(int[] array, int key, int left, int right) {
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] < key) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
