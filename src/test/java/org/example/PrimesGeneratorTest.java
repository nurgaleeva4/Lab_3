package org.example;
import java.util.*;

class PrimesGeneratorTest {
    public static void main(String[] args) {
        int N = 10;
        PrimesGenerator primesGenerator = new PrimesGenerator(N);

        System.out.println("The first " + N + " prime numbers:");
        List<Integer> primesList = new ArrayList<>();
        for (int prime : primesGenerator) {
            primesList.add(prime);
        }
        System.out.println(primesList);

        Collections.reverse(primesList);
        System.out.println("The first " + N + " prime numbers in reverse order:");
        System.out.println(primesList);
    }
}