package com.eazybytes.accounts.entity;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        AtomicReference<Integer> sum= new AtomicReference<>(0);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        list.stream().limit(2).forEach(n -> {
            sum.set(sum.get() + n);
        });
        System.out.println("sum is "+sum);

        int sum1 = list.stream().limit(2).mapToInt(Integer::intValue).sum();

        boolean prime = getPrime(7);
        System.out.println("prime is "+prime);
    }
    public static boolean getPrime(int n){
        return n > 1 && IntStream.range(2, (int) Math.sqrt(n)).noneMatch(i -> n % i == 0);
    }
    Stream s = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
}
