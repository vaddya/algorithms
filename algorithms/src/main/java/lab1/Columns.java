package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * https://www.e-olymp.com/ru/problems/2322
 *
 * @author vaddya
 */
public class Columns {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            PrintWriter writer = new PrintWriter("output.txt");
            int x = in.nextInt();
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[j][i] = in.nextInt();
                }
            }
            for (int[] row : matrix) {
                boolean flag = false;
                for (int i : row) {
                    if (i == x) {
                        flag = true;
                        break;
                    }
                }
                writer.println(flag ? "YES" : "NO");
            }
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
