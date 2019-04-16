package com.vaddya.polis.module1.eolymp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * https://www.e-olymp.com/ru/problems/3920
 *
 * @author vaddya
 */
public class GCD {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            PrintWriter writer = new PrintWriter("output.txt");
            int curr = in.nextInt();
            while (in.hasNext()) {
                curr = gcd(curr, in.nextInt());
            }
            writer.print(curr);
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a > b) {
            return gcd(a % b, b);
        } else {
            return gcd(a, b % a);
        }
    }
}
