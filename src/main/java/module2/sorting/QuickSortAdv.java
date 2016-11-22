package module2.sorting;

import static algorithms.Utils.swap;

/**
 * Quick Sort + random для опорного + разделение на три части
 *
 * @author vaddya
 * @since November 19, 2016
 */
public class QuickSortAdv {

    public static int[] sort(int[] array) {
        if (array == null) return null;
        sort(array, 0, array.length - 1);
        return array;
    }

    // TODO: 11/21/2016 разделение на три и рандом
    private static void sort(int[] array, int left, int right) {
        if (left >= right) return;
        int pivot = partition(array, left, right);
        sort(array, left, pivot);
        sort(array, pivot + 1, right);
    }

    private static int partition(int[] a, int l, int r) {
        int x = a[l + (r - l + 1) / 2];
        int i = l;
        int j = r;
        while (i <= j) {
            while (a[i] < x) i++;
            while (a[j] > x) j--;
            if (i <= j) swap(a, i++, j--);
        }
        return j;
    }

}
