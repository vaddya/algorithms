package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Merge sort algorithm
 *
 * @author vaddya
 */
public class MergeSort {

    public static void main(String[] args) throws FileNotFoundException {
        new MergeSort().run();
    }

    public void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File(".in"));
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        System.out.println(Arrays.toString(sort(array)));
        System.out.println(inversions);
    }

    public static int[] sort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int n = array.length;
        int m = n / 2;
        int[] left = new int[m];
        int[] right = new int[n - m];
        System.arraycopy(array, 0, left, 0, m);
        System.arraycopy(array, m, right, 0, n - m);
        left = sort(left);
        right = sort(right);
        return MergeSort.merge(left, right);
    }

    private static int inversions = 0;

    private static int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0, j = 0;
        for (int k = 0; k < res.length; k++) {
            if (i == a.length) {
                res[k] = b[j++];
                continue;
            }
            if (j == b.length) {
                res[k] = a[i++];
                continue;
            }
            if (a[i] <= b[j]) {
                res[k] = a[i++];
            } else {
                inversions += a.length - i;
                res[k] = b[j++];
            }
        }
        return res;
    }
}
