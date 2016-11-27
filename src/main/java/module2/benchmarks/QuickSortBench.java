package module2.benchmarks;

import module2.sorting.QuickSort;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

import static algorithms.Utils.arrays;

/**
 * Quick Sort - фиксированный выбор опорного элемента
 * Benchmark               (index)  Mode  Cnt        Score        Error  Units
 * QuickSortBench.measure        0  avgt    5     1393.589 ±    113.975  ns/op
 * QuickSortBench.measure        1  avgt    5    40156.618 ±   4787.011  ns/op
 * QuickSortBench.measure        2  avgt    5   794448.359 ±  76955.015  ns/op
 * QuickSortBench.measure        3  avgt    5  9341802.581 ± 810747.343  ns/op
 *
 * @author vaddya
 * @since November 08, 2016
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class QuickSortBench {

    private int[] array;

    @Param({"0", "1", "2", "3"})
    private int index;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        array = arrays[index].clone();
    }

    @Benchmark
    public void measure(Blackhole bh) {
        bh.consume(QuickSort.sort(array));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(QuickSortBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
