package com.github.algorithms.warmup;

import java.util.Arrays;
import java.util.Scanner;

public class SimpleArraySum {

  public static void main(String[] args) {
    // Enter your code here. Read input from STDIN.
    // Print output to STDOUT. Your class should be named Solution.
    System.out.println(Arrays.stream(readInput()).sum());
    System.out.println(Arrays.stream(readIntArray2()).sum());
  }

  private static int[] readInput() {
    Scanner scanner = new Scanner(System.in);
    int n  = scanner.nextInt();
    int[] ints = new int[n];
    for (int i = 0; i < n; i++) {
      ints[i] = scanner.nextInt();
    }

    return ints;
  }

  private static int[] readIntArray2() {
    return new int[]{1, 2, 3, 4, 10, 11};
  }
}
