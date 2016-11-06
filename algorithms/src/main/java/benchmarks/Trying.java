package benchmarks;

import algorithms.sorting.BubbleSort;
import algorithms.sorting.HeapSort;
import algorithms.sorting.SelectionSort;
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
 * @since November 06, 2016
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class Trying {

    private int[] array;


    @Setup
    public void setup() {
        array = Util.src.clone();
    }

    @Benchmark
    public int measureBubble(Blackhole bh) {
        BubbleSort.sort(array);
        return array[0];
    }

    @Benchmark
    public int measureHeap(Blackhole bh) {
        HeapSort.sort(array);
        return array[0];
    }

    @Benchmark
    public int measureSelection(Blackhole bh) {
        SelectionSort.sort(array);
        return array[0];
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Trying.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(2)
                .build();

        new Runner(opt).run();
    }
}
