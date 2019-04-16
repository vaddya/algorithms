package com.vaddya.polis.module2.benchmarks;

import com.vaddya.polis.module2.sorting.MSDString;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

import static com.vaddya.algorithms.Utils.strings;

/**
 * MSD для строк разной длины (алфавит ASCII — 256 символов)
 * Benchmark               (index)  Mode  Cnt         Score         Error  Units
 * MSDStringSortBench.measure        0  avgt    5     40126.543 ±    7413.369  ns/op
 * MSDStringSortBench.measure        1  avgt    5    890789.487 ±   51892.985  ns/op
 * MSDStringSortBench.measure        2  avgt    5   4889776.722 ±  291305.869  ns/op
 * MSDStringSortBench.measure        3  avgt    5  65745804.738 ± 1729054.340  ns/op
 *
 * @author vaddya
 * @since November 27, 2016
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MSDStringSortBench {

    private String[] array;

    @Param({"0", "1", "2", "3"})
    private int index;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        array = strings[index].clone();
    }

    @Benchmark
    public void measure(Blackhole bh) {
        bh.consume(MSDString.sort(array));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MSDStringSortBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
