package algorithms.sorting;

import static algorithms.sorting.Utils.swap;

/**
 * Selection sort algorithm
 *
 * @author vaddya
 */
public class SelectionSort {

    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
        return array;
    }
}
