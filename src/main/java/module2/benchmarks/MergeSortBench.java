package module2.benchmarks;

import module2.sorting.MergeSort;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

import static algorithms.Utils.arrays;

/**
 * Сортировка слиянием
 * Benchmark               (index)  Mode  Cnt         Score        Error  Units
 * MergeSortBench.measure        0  avgt    5      2707.941 ±    812.320  ns/op
 * MergeSortBench.measure        1  avgt    5     70741.755 ±  32709.068  ns/op
 * MergeSortBench.measure        2  avgt    5   1016292.484 ± 468488.631  ns/op
 * MergeSortBench.measure        3  avgt    5  11464513.697 ± 815040.780  ns/op
 *
 * @author vaddya
 * @since November 08, 2016
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MergeSortBench {

    private int[] array;

    @Param({"0", "1", "2", "3"})
    private int index;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        array = arrays[index].clone();
    }

    @Benchmark
    public void measure(Blackhole bh) {
        bh.consume(MergeSort.sort(array));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MergeSortBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
