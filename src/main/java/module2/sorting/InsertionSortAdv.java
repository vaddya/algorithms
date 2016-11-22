package module2.sorting;

import java.util.Arrays;

import static algorithms.Utils.gen;
import static algorithms.Utils.swap;

/**
 * Сортировка вставками + бин.поиск + сдвиги
 *
 * @author vaddya
 * @since November 19, 2016
 */
public class InsertionSortAdv {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(gen(15))));
    }

    // TODO: 11/21/2016 сдвиги
    public static int[] sort(int[] array) {
        if (array == null) return null;
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int k = binarySearch(array, array[i], -1, j + 1);
            for (int m = j; m >= k; m--) {
                swap(array, m, m + 1);
            }
        }
        return array;
    }

    private static int binarySearch(int[] array, int key, int left, int right) {
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] < key) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
