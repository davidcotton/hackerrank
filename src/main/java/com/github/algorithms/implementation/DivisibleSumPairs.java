package com.github.algorithms.implementation;

import java.util.Scanner;

public class DivisibleSumPairs {

  private static int divisibleSumPairs(int[] ints, int k) {
    int nPairs = 0;
    for (int i = 0; i < ints.length; i++) {
      for (int j = 1; j < ints.length; j++) {
        if (j <= i) {
          continue;
        }
        if ((ints[i] + ints[j]) % k == 0) {
          nPairs++;
        }
      }
    }
    return nPairs;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
//    int n = scanner.nextInt();
//    int k = scanner.nextInt();
//    int[] ints = new int[n];
//    for (int i = 0; i < n; i++) {
//      ints[i] = scanner.nextInt();
//    }
    int[] ints = {1, 3, 2, 6, 1, 2};
    int k = 3;

    System.out.println(divisibleSumPairs(ints, k));
    scanner.close();
  }
}
