package com.github.algorithms.warmup;

import static com.github.InputHelper.readLongArray;

import java.util.Arrays;

public class PlusMinus {

  public static void main(String[] args) {
    // Enter your code here. Read input from STDIN.
    // Print output to STDOUT. Your class should be named Solution.
    double positive, negative, zeros, n;
//    long[] input = readLongArray();
    long[] input = readLongArray2();
    n = input.length;
    positive = Arrays.stream(input).filter(i -> i > 0).count();
    negative = Arrays.stream(input).filter(i -> i < 0).count();
    zeros = Arrays.stream(input).filter(i -> i == 0).count();
    System.out.printf("%f\n%f\n%f", positive / n, negative / n, zeros / n);
  }

  private static long[] readLongArray2() {
    return new long[]{-4, 3, -9, 0, 4, 1};
  }
}
