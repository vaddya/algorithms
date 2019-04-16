package com.vaddya.algorithms.sublist;

import java.util.Scanner;

/**
 * Дано целое число n и массив A[1...n] натуральных чисел.
 * Выведите максимальное 1 <= k <= n, для которого найдётся подпоследовательность длины k,
 * в которой каждый элемент делится на предыдущий.
 *
 * @author vaddya
 * @since June 18, 2017
 */
public class LongestIncreasingSublist {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        System.out.println(findMaxSublist(array));
    }

    public static int findMaxSublist(int[] array) {
        int[] helping = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            helping[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[i] % array[j] == 0 && helping[j] + 1 > helping[i]) {
                    helping[i] = helping[j] + 1;
                }
            }
        }
        return findMax(helping);
    }

    private static int findMax(int[] array) {
        int max = array[0];
        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

}