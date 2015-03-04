/**
 *
 */
package me.yumin.java.common.test;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author yumin
 * @since 2014-08-18
 */
public class HelloWorld {

    @GenerateMicroBenchmark
    public void wellHelloThere() {
        // this method was intentionally left blank.
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(".*" + HelloWorld.class.getSimpleName() + ".*")
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
