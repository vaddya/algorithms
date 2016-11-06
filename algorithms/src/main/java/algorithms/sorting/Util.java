package algorithms.sorting;

/**
 * Util class
 *
 * @author vaddya
 */
class Util {

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
