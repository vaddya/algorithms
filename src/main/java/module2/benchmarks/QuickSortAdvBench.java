package module2.benchmarks;

import module2.sorting.QuickSortAdv;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

import static algorithms.Utils.arrays;

/**
 * Quick Sort + random для опорного + разделение на три части
 * Benchmark                  (index)  Mode  Cnt         Score         Error  Units
 * QuickSortAdvBench.measure        0  avgt    5      5879.085 ±    173.368  ns/op
 * QuickSortAdvBench.measure        1  avgt    5     75551.948 ±   4150.900  ns/op
 * QuickSortAdvBench.measure        2  avgt    5    903537.111 ±  39198.785  ns/op
 * QuickSortAdvBench.measure        3  avgt    5  10803992.098 ± 450625.428  ns/op
 *
 * @author vaddya
 * @since November 27, 2016
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class QuickSortAdvBench {

    private int[] array;

    @Param({"0", "1", "2", "3"})
    private int index;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        array = arrays[index].clone();
    }

    @Benchmark
    public void measure(Blackhole bh) {
        bh.consume(QuickSortAdv.sort(array));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(QuickSortAdvBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
