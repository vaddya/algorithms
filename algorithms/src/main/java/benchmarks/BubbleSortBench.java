package benchmarks;

import algorithms.sorting.BubbleSort;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Bubble Sort Benchmark
 *
 * @author vaddya
 * @since November 06, 2016
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class BubbleSortBench {

    private int[] array;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        array = Utils.src.clone();
    }

    @Benchmark
    public void measureBubble(Blackhole bh) {
        bh.consume(BubbleSort.sort(array));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BubbleSortBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
