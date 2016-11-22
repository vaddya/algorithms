package algorithms.sorting;

/**
 * LSD sort algorithm
 *
 * @author vaddya
 * @since November 19, 2016
 */
public class LSD {

    private static final int R = 10;

    public static int[] sort(int[] array) {
        int d = 20;
        int n = array.length;
        for (int k = 0; k < d; k++) {
            int[] count = new int[R];
            for (int x : array) {
                count[digit(x, k)]++;
            }
            for (int i = 1; i < R; i++) {
                count[i] += count[i - 1];
            }
            int[] res = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                res[--count[digit(array[i], k)]] = array[i];
            }
            System.arraycopy(res, 0, array, 0, n);
        }
        return array;
    }

    private static int digit(int x, int k) {
        for (int i = 0; i < k; i++) {
            x /= 10;
        }
        return x % 10;
    }
}
