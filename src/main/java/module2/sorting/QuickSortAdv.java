package module2.sorting;

import java.util.Random;

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

    private static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = left + new Random().nextInt(right - left + 1);
        int x = array[pivot];
        int q = left;
        int p = left;
        swap(array, left, pivot);

        for (int i = left + 1; i <= right; i++) {
            if (array[i] < x) {
                q++;
                swap(array, i, q);
            } else if (array[i] == x) {
                q++;
                p++;
                swap(array, i, q);
                swap(array, p, q);
            }
        }

        int m = q;
        for (int i = left; i <= p; i++) {
            swap(array, q--, i);
        }

        sort(array, left, q);
        sort(array, m + 1, right);
    }
}
