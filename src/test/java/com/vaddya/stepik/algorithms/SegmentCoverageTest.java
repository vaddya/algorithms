package com.vaddya.stepik.algorithms;

import com.vaddya.stepik.algorithms.SegmentCoverage.Point;
import com.vaddya.stepik.algorithms.SegmentCoverage.Segment;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SegmentCoverageTest {

    @Test
    public void test1() {
        List<Point> points = cover(
                Segment.from(1, 3),
                Segment.from(2, 5),
                Segment.from(3, 6)
        );

        assertEquals(1, points.size());
        assertEquals(3, points.get(0).x);
    }

    @Test
    public void test2() {
        List<Point> points = cover(
                Segment.from(4, 7),
                Segment.from(1, 3),
                Segment.from(2, 5),
                Segment.from(5, 6)
        );

        assertEquals(2, points.size());
        assertEquals(3, points.get(0).x);
        assertEquals(6, points.get(1).x);
    }

    private List<Point> cover(Segment... segments) {
        List<Segment> list = new ArrayList<>(Arrays.asList(segments));
        return SegmentCoverage.cover(list);
    }

}