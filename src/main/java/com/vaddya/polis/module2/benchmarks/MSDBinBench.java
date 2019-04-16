package com.vaddya.polis.module2.benchmarks;

import com.vaddya.polis.module2.sorting.MSDBin;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

import static com.vaddya.algorithms.Utils.arrays;

/**
 * MSD для двоичных чисел (без учёта знака)
 * Benchmark            (index)  Mode  Cnt         Score         Error  Units
 * MSDBinBench.measure        0  avgt    5     45466.106 ±    3025.171  ns/op
 * MSDBinBench.measure        1  avgt    5    455724.540 ±   17256.426  ns/op
 * MSDBinBench.measure        2  avgt    5   4636629.994 ±  316153.921  ns/op
 * MSDBinBench.measure        3  avgt    5  46688373.391 ± 2642299.736  ns/op
 *
 * @author vaddya
 * @since November 27, 2016
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MSDBinBench {

    private int[] array;

    @Param({"0", "1", "2", "3"})
    private int index;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        array = arrays[index].clone();
    }

    @Benchmark
    public void measure(Blackhole bh) {
        bh.consume(MSDBin.sort(array));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MSDBinBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
