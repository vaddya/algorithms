package algorithms.sorting;

import static algorithms.sorting.Util.swap;

/**
 * Quick sort algorithm
 *
 * @author vaddya
 */
public class QuickSort {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
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
