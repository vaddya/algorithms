package algorithms.sorting;

/**
 * Merge sort algorithm
 *
 * @author vaddya
 */
public class MergeSort {

    public static int[] sort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int n = array.length;
        int m = n / 2;
        // TODO: 11/5/2016 сделать на месте
        int[] left = new int[m];
        int[] right = new int[n - m];
        System.arraycopy(array, 0, left, 0, m);
        System.arraycopy(array, m, right, 0, n - m);
        left = sort(left);
        right = sort(right);
        return MergeSort.merge(left, right);
    }

    private static int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0, j = 0;
        for (int k = 0; k < res.length; k++) {
            if (i == a.length) {
                res[k] = b[j++];
            } else if (j == b.length) {
                res[k] = a[i++];
            } else if (a[i] <= b[j]) {
                res[k] = a[i++];
            } else {
                res[k] = b[j++];
            }
        }
        return res;
    }
}
