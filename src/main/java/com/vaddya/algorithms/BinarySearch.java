package com.vaddya.algorithms;

/**
 * Binary search com.vaddya.algorithms
 *
 * @author vaddya
 */
public class BinarySearch {

    public static int leftBinarySearch(int[] array, int key) {
        int left = -1;
        int right = array.length;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] < key) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (right == array.length || array[right] != key) {
            return -1;
        }
        return right;
    }

    public static int rightBinarySearch(int[] array, int key) {
        int left = -1;
        int right = array.length;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= key) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (left == -1 || array[left] != key) {
            return -1;
        }
        return left;
    }
}
