package algorithms.sublist;

import java.util.Scanner;

/**
 * Дано целое число n и массив A[1...n], содержащий неотрицательные целые числа.
 * Найдите наибольшую невозрастающую подпоследовательность в A.
 * В первой строке выведите её длину k, во второй — её индексы.
 *
 * @author vaddya
 * @since June 18, 2017
 */
public class LongestDecreasingSublist {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        int[] result = findMaxSublist(array);
        System.out.println(result.length);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] findMaxSublist(int[] array) {
        int[] helping = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            helping[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[i] <= array[j] && helping[j] + 1 > helping[i]) {
                    helping[i] = helping[j] + 1;
                }
            }
        }
        return restoreResult(array, helping);
    }

    private static int[] restoreResult(int[] array, int[] helping) {
        int max = findMax(helping);
        int[] result = new int[max];
        int index = result.length - 2; // index >= 1 and another -1 for max

        int k = array.length - 1;
        while (helping[k] != max) k--;
        result[result.length - 1] = k + 1; // index >= 1

        while (index >= 0) {
            for (int i = k - 1; i >= 0; i--) {
                if (helping[i] == k - 1 && array[i] >= array[k]) {
                    result[index--] = i + 1; // index >= 1
                    k = i;
                    break;
                }
            }
        }
        return result;
    }

    private static int findMax(int[] array) {
        int max = array[0];
        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

}