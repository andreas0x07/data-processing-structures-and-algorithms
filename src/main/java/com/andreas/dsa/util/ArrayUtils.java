package com.andreas.dsa.util;

import java.util.Objects;
import java.util.Random;

public class ArrayUtils {
    private static final Random RANDOM = new Random();

    // Fills out array 'a' in ascending order
    public static void fillInc(int[] a) {
        Objects.requireNonNull(a, "Array 'a' must not be null");
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }
    }

    // Fills out array 'a' in descending order
    public static void fillDec(int[] a) {
        Objects.requireNonNull(a, "Array 'a' must not be null");
        for (int i = 0; i < a.length; i++) {
            a[i] = a.length - i;
        }
    }

    // Fills out array 'a' with random numbers in the range ('min' <= x <= 'max') without using a seed
    public static void fillRand(int[] a, int min, int max) {
        fillRand(a, min, max, RANDOM);
    }

    // Fills out array 'a' with random numbers in the range ('min' <= x <= 'max') with the seed 'random'
    public static void fillRand(int[] a, int min, int max, Random random) {
        Objects.requireNonNull(a, "Array 'a' must not be null");
        Objects.requireNonNull(random, "Random 'random' must not be null");
        if (min > max) {
            throw new IllegalArgumentException("min (" + min + ") must not be greater than max (" + max + ")");
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(min, max + 1);
        }
    }

    // Calculates the sum of all elements in array 'a'
    public static long checkSum(int[] a) {
        Objects.requireNonNull(a, "Array 'a' must not be null");
        long sum = 0;
        for (int val : a) {
            sum += val;
        }
        return sum;
    }

    // Returns the number of runs in array 'a'
    // Definition: A run is a maximum-sized non-descending sequence of numbers (A[i] <= A[i+1])
    public static int runCount(int[] a) {
        Objects.requireNonNull(a, "Array 'a' must not be null");
        if (a.length == 0) {
            return 0;
        }

        int runs = 1; // Ein nicht-leeres Array hat mindestens 1 Serie
        for (int i = 0; i < a.length - 1; i++) {
            // Sobald das nächste Element kleiner ist als das aktuelle, bricht die Serie ab!
            if (a[i] > a[i + 1]) {
                runs++;
            }
        }
        return runs;
    }

    // Prints the array in the console
    public static void printArray(int[] a){
        if (a == null) {
            System.out.println("null");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i]);
            if (i < a.length - 1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}