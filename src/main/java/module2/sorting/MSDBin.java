package module2.sorting;

/**
 * MSD для двоичных чисел (без учёта знака)
 *
 * @author vaddya
 * @since November 19, 2016
 */
public class MSDBin {

    public static void main(String[] args) {
        int[] array = {0b1111, 0b0, 0b1, 0b10, 0b101, 0b100, 0b101};
        for (int i : sort(array)) {
            System.out.print(Integer.toBinaryString(i) + " ");
        }
    }

    public static int[] sort(int[] array) {
        int[] res = new int[array.length];
        return msdSort(array, res, 0, array.length - 1, 0);
    }

    private static final int ALPHABET = 2; // BIN
    private static final int THRESHOLD = 20;

    private static int[] msdSort(int[] a, int[] res, int left, int right, int r) {
        if (r > THRESHOLD || left >= right) return a;
        int[] count = new int[ALPHABET + 1];
        for (int i = left; i <= right; i++) {
            count[digit(a[i], r)]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = right; i >= left; i--) {
            res[left + --count[digit(a[i], r)]] = a[i];
        }
        System.arraycopy(res, left, a, left, right - left + 1);
        for (int i = 0; i < ALPHABET; i++) {
            msdSort(a, res, left + count[i], left + count[i + 1] - 1, r + 1);
        }
        return a;
    }

    private static int digit(int x, int k) {
        for (int i = THRESHOLD; i > k; i--) {
            x /= ALPHABET;
        }
        return x % ALPHABET;
    }
}
