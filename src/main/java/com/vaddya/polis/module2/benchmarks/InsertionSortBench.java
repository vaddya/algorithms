package com.vaddya.polis.module2.benchmarks;

import com.vaddya.polis.module2.sorting.InsertionSort;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

import static com.vaddya.algorithms.Utils.arrays;

/**
 * Сортировка вставками
 * Benchmark                   (index)  Mode  Cnt           Score          Error  Units
 * InsertionSortBench.measure        0  avgt    5        3258.324 ±      577.246  ns/op
 * InsertionSortBench.measure        1  avgt    5      457132.000 ±    42403.555  ns/op
 * InsertionSortBench.measure        2  avgt    5    46338871.044 ±  3599765.222  ns/op
 * InsertionSortBench.measure        3  avgt    5  4494536646.300 ± 69096078.724  ns/op
 *
 * @author vaddya
 * @since November 08, 2016
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class InsertionSortBench {

    private int[] array;

    @Param({"0", "1", "2", "3"})
    private int index;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        array = arrays[index].clone();
    }

    @Benchmark
    public void measure(Blackhole bh) {
        bh.consume(InsertionSort.sort(array));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(InsertionSortBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
