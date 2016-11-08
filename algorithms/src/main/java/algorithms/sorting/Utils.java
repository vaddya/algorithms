package algorithms.sorting;

import java.util.Random;

/**
 * Utils class
 *
 * @author vaddya
 */
class Utils {

    private static Random random = new Random(System.currentTimeMillis());

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void shuffle(int[] array) {
        for (int i = 0; i < array.length; i++) {
            swap(array, i, i + random.nextInt(array.length - i));
        }
    }
}
