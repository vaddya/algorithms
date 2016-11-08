package algorithms.sorting;

import static algorithms.sorting.Utils.swap;

/**
 * Quick sort algorithm
 *
 * @author vaddya
 */
public class QuickSort {

    public static int[] sort(int[] array) {
        //shuffle(array);
        sort(array, 0, array.length - 1);
        return array;
    }

    private static void sort(int[] array, int left, int right) {
        if (left >= right) return;
        int pivot = partition(array, left, right);
        sort(array, left, pivot - 1);
        sort(array, pivot + 1, right);
    }

    private static int partition(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                swap(a, j, i);
            }
        }
        swap(a, l, j);
        return j;
    }
}
