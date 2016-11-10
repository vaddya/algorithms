package algorithms.sorting;

import static algorithms.Utils.swap;

/**
 * Max oriented heap sort algorithm
 *
 * @author vaddya
 */
public class HeapSort {

    private static int size;

    public static int[] sort(int[] array) {
        if (array == null) return null;
        size = array.length - 1;
        for (int i = array.length / 2; i >= 0; i--) {
            siftDown(array, i);
        }
        for (int i : array) {
            swap(array, size--, 0);
            siftDown(array, 0);
        }
        return array;
    }

    private static void siftDown(int[] array, int i) {
        int left = leftOf(i);
        int right = rightOf(i);
        while (left <= size) {
            if (right > size) {
                if (array[i] < array[left]) {
                    swap(array, i, left);
                }
                break;
            }
            if (array[i] < array[left]) {
                if (array[i] > array[right]) {
                    swap(array, i, left);
                    i = left;
                } else {
                    int max = array[left] > array[right]
                            ? left
                            : right;
                    swap(array, i, max);
                    i = max;
                }
            } else if (array[i] < array[right]) {
                swap(array, i, right);
                i = right;
            } else {
                break;
            }
            left = leftOf(i);
            right = rightOf(i);
        }
    }

    private static int leftOf(int i) {
        return i * 2 + 1;
    }

    private static int rightOf(int i) {
        return i * 2 + 2;
    }
}
