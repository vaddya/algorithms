package algorithms.sorting;

import static algorithms.sorting.Util.swap;

/**
 * Selection sort algorithm
 *
 * @author vaddya
 */
public class SelectionSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }
}
