package module2.benchmarks;

import module2.sorting.InsertionSortAdv;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

import static algorithms.Utils.arrays;

/**
 * Сортировка вставками + бин.поиск + сдвиги
 * Benchmark                      (index)  Mode  Cnt           Score           Error  Units
 * InsertionSortAdvBench.measure        0  avgt    5       1820.705 ±     287.146  ns/op
 * InsertionSortAdvBench.measure        1  avgt    5      76848.979 ±    7098.226  ns/op
 * InsertionSortAdvBench.measure        2  avgt    5    2798367.506 ±  144697.508  ns/op
 * InsertionSortAdvBench.measure        3  avgt    5  329969681.150 ± 5928160.624  ns/op
 *
 * @author vaddya
 * @since November 27, 2016
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class InsertionSortAdvBench {

    private int[] array;

    @Param({"0", "1", "2", "3"})
    private int index;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        array = arrays[index].clone();
    }

    @Benchmark
    public void measure(Blackhole bh) {
        bh.consume(InsertionSortAdv.sort(array));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(InsertionSortAdvBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
