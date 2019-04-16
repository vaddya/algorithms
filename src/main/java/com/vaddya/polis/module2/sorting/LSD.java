package com.vaddya.polis.module2.sorting;

/**
 * LSD для типа long по байтам
 *
 * @author vaddya
 * @since November 19, 2016
 */
public class LSD {

    private static final int ALPHABET = 10;

    public static int[] sort(int[] array) {
        int d = 20;
        int n = array.length;
        for (int k = 0; k < d; k++) {
            int[] count = new int[ALPHABET];
            for (int x : array) {
                count[digitAt(x, k)]++;
            }
            for (int i = 1; i < ALPHABET; i++) {
                count[i] += count[i - 1];
            }
            int[] res = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                res[--count[digitAt(array[i], k)]] = array[i];
            }
            System.arraycopy(res, 0, array, 0, n);
        }
        return array;
    }

    private static int digitAt(int x, int k) {
        for (int i = 0; i < k; i++) {
            x /= 10;
        }
        return x % 10;
    }
}
