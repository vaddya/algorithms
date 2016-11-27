package module2.benchmarks;

import module2.sorting.LSD;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

import static algorithms.Utils.arrays;

/**
 * LSD
 * Benchmark         (index)  Mode  Cnt         Score         Error  Units
 * LSDBench.measure        0  avgt    5     65028.430 ±   15315.158  ns/op
 * LSDBench.measure        1  avgt    5    609223.492 ±  138803.648  ns/op
 * LSDBench.measure        2  avgt    5   6018122.157 ±   94934.323  ns/op
 * LSDBench.measure        3  avgt    5  67337101.143 ± 3935848.561  ns/op
 *
 * @author vaddya
 * @since November 27, 2016
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class LSDBench {

    private int[] array;

    @Param({"0", "1", "2", "3"})
    private int index;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        array = arrays[index].clone();
    }

    @Benchmark
    public void measure(Blackhole bh) {
        bh.consume(LSD.sort(array));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(LSDBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
