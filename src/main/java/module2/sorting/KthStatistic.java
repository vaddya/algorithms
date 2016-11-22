package module2.sorting;

import java.util.Arrays;
import java.util.Random;

import static algorithms.Utils.gen;
import static algorithms.Utils.swap;

/**
 * K-ая порядковая статистика в среднем O(n)
 *
 * @author vaddya
 * @since November 19, 2016
 */
public class KthStatistic {

    public static void main(String[] args) {
        int[] array = gen(10);
        System.out.println(Arrays.toString(array));
        kthElement(array, 0);
        System.out.println(Arrays.toString(array));
    }

    private static Random random = new Random(System.currentTimeMillis());

    public static void kthElement(int[] a, int k) {
        int left = 0;
        int right = a.length - 1;
        while (right > left) {
            int pivotIdx = left + random.nextInt(right - left + 1);
            int idx = partition(a, left, right, pivotIdx);
            if (k < idx) {
                right = idx - 1;
            } else if (k > idx) {
                left = idx + 1;
            } else {
                return; //a[k] — ответ
            }
        }
    }

    private static int partition(int[] a, int left, int right, int pivot) {
        if (left > right) return right;
        int i = left;
        int j = right;
        int x = a[pivot];
        swap(a, j--, pivot); //Поменяли с крайним
        while (i <= j) {
            while (i <= j && a[i] < x) i++;
            while (i <= j && a[j] > x) j--;
            if (i >= j) break;
            swap(a, i++, j--);
        }
        swap(a, i, right); //Вернули на место
        return i;
    }
}
