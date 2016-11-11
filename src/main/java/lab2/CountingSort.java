package lab2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.e-olymp.com/ru/problems/2327
 *
 * @author vaddya
 */
public class CountingSort {

    public static void main(String[] args) {
        try {
            FastScanner in = new FastScanner(new File("input.txt"));
            PrintWriter writer = new PrintWriter("output.txt");
            int n = in.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }
            sort(array);
            for (int i : array) {
                writer.print(i + " ");
            }
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void sort(int[] array) {
        int min = findMin(array);
        int max = findMax(array);
        int n = max - min + 1;
        int[] values = new int[n];
        for (int i : array) values[i - min]++;
        int pos = 0;
        for (int i = 0; i < n; i++) {
            while (values[i]-- > 0) {
                array[pos++] = i + min;
            }
        }
    }

    private static int findMin(int[] array) {
        int min = array[0];
        for (int i : array) {
            min = i < min ? i : min;
        }
        return min;
    }

    private static int findMax(int[] array) {
        int max = array[0];
        for (int i : array) {
            max = i > max ? i : max;
        }
        return max;
    }

    private static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
