package com.vaddya.stepik.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SegmentCoverage {

    /**
     * По данным n отрезкам необходимо найти множество точек минимального размера,
     * для которого каждый из отрезков содержит хотя бы одну из точек.
     * <p>
     * В первой строке дано число 1≤n≤100 отрезков.
     * Каждая из последующих n строк содержит по два числа 0≤l≤r≤10^9, задающих начало и конец отрезка.
     * Выведите оптимальное число m точек и сами m точек.
     * Если таких множеств точек несколько, выведите любое из них.
     * </p>
     */
    public static List<Point> cover(List<Segment> segments) {
        segments.sort(Comparator.comparing(segment -> segment.right));

        List<Point> points = new ArrayList<>();
        while (!segments.isEmpty()) {
            Point p = Point.of(segments.get(0).right);
            points.add(p);
            while (!segments.isEmpty()) {
                if (!segments.get(0).isCovered(p)) {
                    break;
                }
                segments.remove(0);
            }
        }
        return points;
    }

    public static class Segment {
        public int left;
        public int right;

        public static Segment from(int left, int right) {
            Segment segment = new Segment();
            segment.left = left;
            segment.right = right;
            return segment;
        }

        boolean isCovered(Point p) {
            return left <= p.x && p.x <= right;
        }
    }

    public static class Point {
        public int x;

        public static Point of(int coordinate) {
            Point point = new Point();
            point.x = coordinate;
            return point;
        }

        @Override
        public String toString() {
            return Integer.toString(x);
        }
    }
}
