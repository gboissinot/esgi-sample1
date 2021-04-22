package fr.gboissinot.sample1.domain.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class TestZipCode {
    public static void main(String[] args) {

        Set<ZipCode> zipCodeSet = new HashSet<>();

        IntStream.range(0, 100000).forEach(val ->
                zipCodeSet.add(ZipCode.of("7500" + val % 10))
        );

        System.out.println(zipCodeSet.size());
    }
}
