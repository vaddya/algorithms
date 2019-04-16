package com.vaddya.stepik.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonacci {

    /**
     * Дано целое число 1≤n≤40, необходимо вычислить n-е число Фибоначчи
     * (напомним, что F0=0, F1=1 и Fn=Fn−1+Fn−2 при n≥2).
     */
    public static int findNth(int n) {
        List<Integer> list = new ArrayList<>(Arrays.asList(0, 1));
        for (int i = 2; i <= n; i++) {
            list.add(list.get(i - 1) + list.get(i - 2));
        }
        return list.get(n);
    }

    /**
     * Дано число 1≤n≤10^7, необходимо найти последнюю цифру n-го числа Фибоначчи.
     * <p>
     * Как мы помним, числа Фибоначчи растут очень быстро,
     * поэтому при их вычислении нужно быть аккуратным с переполнением.
     * В данной задаче, впрочем, этой проблемы можно избежать,
     * поскольку нас интересует только последняя цифра числа Фибоначчи:
     * если 0≤a,b≤9 — последние цифры чисел Fi и Fi+1 соответственно,
     * то (a+b)mod10 — последняя цифра числа Fi+2.
     * </p>
     */
    public static int findLastDigit(int n) {
        List<Integer> list = new ArrayList<>(Arrays.asList(0, 1));
        for (int i = 2; i <= n; i++) {
            int next = (list.get(i - 1) + list.get(i - 2)) % 10;
            list.add(next);
        }
        return list.get(n);
    }

    /**
     * Даны целые числа 1≤n≤10^18 и 2≤m≤10^5,
     * необходимо найти остаток от деления n-го числа Фибоначчи на m.
     */
    public static int findModulo(long n, int m) {
        List<Integer> list = new ArrayList<>(Arrays.asList(0, 1));

        int k = 0;
        for (int i = 2; i < m * 6; i++) {
            list.add((list.get(i - 1) + list.get(i - 2)) % m);
            k++;
            if (list.get(i) == 1 && list.get(i - 1) == 0) {
                break;
            }
        }
        return list.get((int) (n % k));
    }
}
