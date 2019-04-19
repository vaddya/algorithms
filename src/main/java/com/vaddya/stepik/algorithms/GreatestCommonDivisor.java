package com.vaddya.stepik.algorithms;

public class GreatestCommonDivisor {

    /**
     * По данным двум числам 1≤a,b≤2⋅10^9 найдите их наибольший общий делитель.
     */
    public static int find(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a > b) {
            return find(a % b, b);
        } else {
            return find(a, b % a);
        }
    }
}
