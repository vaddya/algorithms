package module2.sorting;

import static algorithms.Utils.swap;

/**
 * Сортировка вставками
 *
 * @author vaddya
 * @since November 19, 2016
 */
public class InsertionSort {

    public static int[] sort(int[] array) {
        if (array == null) return null;
        for (int i = 0; i < array.length; i++) {
            int j = i - 1;
            while (j >= 0 && array[j] > array[j + 1]) {
                swap(array, j, j + 1);
                j--;
            }
        }
        return array;
    }
}
