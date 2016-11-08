package benchmarks;

import algorithms.sorting.MergeSort;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * benchmarks at technopolis
 *
 * @author vaddya
 * @since November 08, 2016
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MergeSortBench {

    private int[] array;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        array = Utils.src.clone();
    }

    @Benchmark
    public void measureHeap(Blackhole bh) {
        bh.consume(MergeSort.sort(array));
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
