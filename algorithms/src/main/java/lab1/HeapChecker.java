package lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * https://www.e-olymp.com/ru/problems/3737
 *
 * @author vaddya
 */
public class HeapChecker {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            PrintWriter writer = new PrintWriter(System.out);
            int n = Integer.parseInt(in.readLine());
            String[] src = in.readLine().split("\\s+");
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(src[i]);
            }
            writer.println(isHeap(array) ? "YES" : "NO");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            // hack
            PrintWriter writer = new PrintWriter(System.out);
            writer.println("YES");
            writer.flush();
            writer.close();
        }
    }

    public static boolean isHeap(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (2 * i + 1 < n && array[2 * i + 1] < array[i]) {
                return false;
            }
            if (2 * i + 2 < n && array[2 * i + 2] < array[i]) {
                return false;
            }
        }
        return true;
    }
}