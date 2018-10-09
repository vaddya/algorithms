package module2.eolymp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * https://www.e-olymp.com/ru/problems/1457
 *
 * @author vaddya
 */
public class Sortable {

    public static void main(String[] args) throws FileNotFoundException {
        FastScanner in = new FastScanner(new File("input.txt"));
        PrintWriter writer = new PrintWriter("output.txt");
        int n = in.nextInt();
        int m = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        writer.print(isSortable(array, m) ? "Yes" : "No");
        writer.flush();
        writer.close();
    }

    private static boolean isSortable(int[] array, int m) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= max) {
                max = array[i];
            } else {
                if (max + array[i] > m) {
                    return false;
                }
            }
        }
        return true;
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
