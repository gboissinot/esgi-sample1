package fr.gboissinot.sample1.domain.model;


import fr.gboissinot.kernel.java.annotation.Pattern;
import fr.gboissinot.kernel.java.annotation.ddd.DDD;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@DDD.ValueObject
final class ZipCode {

    private static final Map<String, ZipCode> _cachedZipCode = new ConcurrentHashMap<>();

    private final int[] code_array;

    private ZipCode(int[] zipCode) {
        this.code_array = zipCode;
    }

    @Pattern.StaticFactoryMethod
    static ZipCode of(String zipCode) {
        final ZipCode value = new ZipCode(convert(zipCode));
        _cachedZipCode.putIfAbsent(zipCode, value);
        return _cachedZipCode.get(zipCode);
    }

    private static int[] convert(String zipCode) {
        int[] result = new int[zipCode.length()];
        for (int i = 0; i < zipCode.length(); i++) {
            result[i] = Integer.valueOf(String.valueOf(zipCode.charAt(i)));
        }
        return result;
    }

    public String code() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : code_array) {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZipCode zipCode = (ZipCode) o;
        return Arrays.equals(code_array, zipCode.code_array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(code_array);
    }

    @Override
    public String toString() {
        return "ZipCode{" +
                "value=" + code() +
                '}';
    }
}
