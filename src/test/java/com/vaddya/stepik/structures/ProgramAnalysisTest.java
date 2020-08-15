package com.vaddya.stepik.structures;

import com.vaddya.stepik.structures.ProgramAnalysis.Pair;
import org.junit.Assert;
import org.junit.Test;

public class ProgramAnalysisTest {

    @Test
    public void testIsAchievableAllEqual() {
        Pair[] equalities = new Pair[]{p(1, 2), p(1, 3), p(1, 4), p(2, 3), p(2, 4), p(3, 4)};
        Pair[] inequalities = new Pair[0];
        Assert.assertTrue(ProgramAnalysis.isAchievable(4, equalities, inequalities));
    }

    @Test
    public void testIsAchievableContradiction() {
        Pair[] equalities = new Pair[]{p(2, 3), p(1, 5), p(2, 5), p(3, 4), p(4, 2)};
        Pair[] inequalities = new Pair[]{p(6, 1), p(4, 6), p(4, 5)};
        Assert.assertFalse(ProgramAnalysis.isAchievable(6, equalities, inequalities));
    }

    Pair p(int f, int s) {
        return new Pair(f, s);
    }
}
