package com.vaddya.algorithms.sorting;

import java.util.Arrays;

import static com.vaddya.algorithms.Utils.gen;

/**
 * MSD sort algorithm
 *
 * @author vaddya
 * @since November 19, 2016
 */
public class MSD {

    public static void main(String[] args) {
        int[] array = gen(100000);
        System.out.println(Arrays.toString(sort(array)));
    }

    public static int[] sort(int[] array) {
        int[] res = new int[array.length];
        return msdSort(array, res, 0, array.length - 1, 0);
    }

    private static final int ALPHABET = 10;
    private static final int THRESHOLD = 20;

    private static int[] msdSort(int[] a, int[] res, int left, int right, int r) {
        if (r > THRESHOLD || left >= right) return a;
        int[] count = new int[ALPHABET + 1];
        for (int i = left; i <= right; i++) {
            count[digit(a[i], r)]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = right; i >= left; i--) {
            res[left + --count[digit(a[i], r)]] = a[i];
        }
        System.arraycopy(res, left, a, left, right - left + 1);
        for (int i = 0; i < ALPHABET; i++) {
            msdSort(a, res, left + count[i], left + count[i + 1] - 1, r + 1);
        }
        return a;
    }

    private static int digit(int x, int k) {
        for (int i = THRESHOLD; i > k; i--) {
            x /= ALPHABET;
        }
        return x % ALPHABET;
    }
}
