package com.github.algorithms.warmup;

import java.util.Arrays;

import static com.github.InputHelper.readIntArray;

public class AVeryBigSum {

  public static void main(String[] args) {
    // Enter your code here. Read input from STDIN.
    // Print output to STDOUT. Your class should be named Solution.
    System.out.println(Arrays.stream(readIntArray()).sum());
    System.out.println(Arrays.stream(readInput2()).sum());
  }

  private static int[] readInput2() {
    return new int[]{1, 2, 3, 4, 10, 11};
  }
}
