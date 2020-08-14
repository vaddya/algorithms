package com.vaddya.stepik.structures;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PackageProcessorTest {

    @Test
    public void testProcess() {
        check(1, List.of(pack(0, 0)), List.of(0));
        check(1, List.of(pack(0, 1), pack(0, 1)), List.of(0, -1));
        check(1, List.of(pack(0, 1), pack(1, 1)), List.of(0, 1));
    }
    
    private void check(int bufferSize, List<PackageProcessor.Package> packages, List<Integer> expected) {
        PackageProcessor.process(bufferSize, packages);
        for (int i = 0; i < packages.size(); i++) {
            Assert.assertEquals(expected.get(i).intValue(), packages.get(i).getProcessStartTime());
        }
    }
    
    private PackageProcessor.Package pack(int arrival, int duration) {
        return new PackageProcessor.Package(arrival, duration);
    }
}