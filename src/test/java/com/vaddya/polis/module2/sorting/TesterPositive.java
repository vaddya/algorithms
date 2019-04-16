package com.vaddya.polis.module2.sorting;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static com.vaddya.algorithms.Utils.gen;
import static com.vaddya.algorithms.Utils.isSorted;
import static org.junit.Assert.assertTrue;

/**
 * TesterPositive at technopolis
 *
 * @author vaddya
 * @since November 27, 2016
 */
@RunWith(value = Parameterized.class)
public class TesterPositive {

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    @Parameterized.Parameter
    public int[] array;

    @Parameterized.Parameters
    public static Collection<int[]> data() {
        return Arrays.asList(new int[][]{
                {0},
                {0, 0, 0, 0},
                {4, 3, 2, 1},
                {0, 1, 1, 0},
                {1},
                {Integer.MAX_VALUE, 0, 0},
                gen(1),
                gen(10),
                gen(100),
                gen(1000),
                gen(10000),
        });
    }

    @Test
    public void test01_checkLSDSort() throws IOException {
        assertTrue(isSorted(LSD.sort(array)));
    }

    @Test
    public void test02_checkMSDBinSort() throws IOException {
        assertTrue(isSorted(MSDBin.sort(array)));
    }
}
