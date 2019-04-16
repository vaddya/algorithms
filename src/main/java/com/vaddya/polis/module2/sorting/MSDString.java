package com.vaddya.polis.module2.sorting;

/**
 * MSD для строк разной длины (алфавит ASCII — 256 символов)
 *
 * @author vaddya
 * @since November 19, 2016
 */
public class MSDString {

    public static String[] sort(String[] array) {
        String[] res = new String[array.length];
        return msdSort(array, res, 0, array.length - 1, 0);
    }

    private static final int ALPHABET = 256; // ASCII
    private static final int THRESHOLD = 20;

    private static String[] msdSort(String[] a, String[] res, int left, int right, int r) {
        if (r > THRESHOLD || left >= right) return a;
        int[] count = new int[ALPHABET + 1];
        for (int i = left; i <= right; i++) {
            count[charAt(a[i], r)]++;
        }
        for (int i = 1; i < ALPHABET + 1; i++) {
            count[i] += count[i - 1];
        }
        for (int i = right; i >= left; i--) {
            res[left + --count[charAt(a[i], r)]] = a[i];
        }
        System.arraycopy(res, left, a, left, right - left + 1);
        for (int i = 0; i < ALPHABET; i++) {
            msdSort(a, res, left + count[i], left + count[i + 1] - 1, r + 1);
        }
        return a;
    }

    private static int charAt(String s, int i) {
        return i < s.length() ? s.charAt(i) : 0;
    }
}
