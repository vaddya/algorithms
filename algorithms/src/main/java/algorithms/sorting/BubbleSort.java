package algorithms.sorting;

import static algorithms.sorting.Util.swap;

/**
 * Bubble sort algorithm
 *
 * @author vaddya
 */
public class BubbleSort {

    public static void sort(int[] array) {
        int i = 0;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            i++;
        }
    }
}
