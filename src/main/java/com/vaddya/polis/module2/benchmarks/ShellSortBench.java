package com.vaddya.polis.module2.benchmarks;

import com.vaddya.polis.module2.sorting.ShellSort;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

import static com.vaddya.algorithms.Utils.arrays;

/**
 * Сортировка Шелла
 * Benchmark               (index)  Mode  Cnt         Score        Error  Units
 * ShellSortBench.measure        0  avgt    5      1084.799 ±    109.094  ns/op
 * ShellSortBench.measure        1  avgt    5     58395.881 ±   7566.782  ns/op
 * ShellSortBench.measure        2  avgt    5    961709.762 ±  45108.910  ns/op
 * ShellSortBench.measure        3  avgt    5  13079416.605 ± 364336.184  ns/op
 *
 * @author vaddya
 * @since November 08, 2016
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class ShellSortBench {

    private int[] array;

    @Param({"0", "1", "2", "3"})
    private int index;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        array = arrays[index].clone();
    }

    @Benchmark
    public void measure(Blackhole bh) {
        bh.consume(ShellSort.sort(array));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ShellSortBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
