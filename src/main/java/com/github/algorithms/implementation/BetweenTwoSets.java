package com.github.algorithms.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BetweenTwoSets {

  public static void main(String[] args) {
//    Scanner in = new Scanner(System.in);
//    int n = in.nextInt();
//    int m = in.nextInt();
//    int[] a = new int[n];
//    for (int a_i = 0; a_i < n; a_i++) {
//      a[a_i] = in.nextInt();
//    }
//    int[] b = new int[m];
//    for (int b_i = 0; b_i < m; b_i++) {
//      b[b_i] = in.nextInt();
//    }

    // Test Case #0
//    int[] a = {2, 4};
//    int[] b = {16, 32, 96};

    // Test Case #1
    int[] a = {100, 99, 98, 97, 96, 95, 94, 93, 92, 91};
    int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

//    // Test Case #3
//    int[] a = {3, 9, 6};
//    int[] b = {36, 72};

//    System.out.println(bruteForce(a, b));
    System.out.println(optimalSolution(a, b));
  }

  private static int optimalSolution(int[] as, int[] bs) {
    int max = 0;
    for (int i : bs) {
      max = gcd(i, max);
    }

    int min = 1;
    for (int i : as) {
      min = lcm(min, i);
      if (min > max) {
        return 0;
      }
    }

    int count = 0;
    for (int i = min; i <= max; i += min) {
      if (i % min == 0 && max % i == 0) {
        count++;
      }
    }

    return count;
  }

  private static int gcd(int a, int b) {
    if (a == 0) {
      return b;
    } else if (b == 0) {
      return a;
    }

    while (a != 0 && b != 0) {
      if (a >= b) {
        a %= b;
      } else {
        b %= a;
      }
    }

    return a + b;
  }

  private static int lcm(int a, int b) {
    return (a / gcd(a, b)) * b;
  }

  private static int brokenSolution(int[] as, int[] bs) {
    int min = Arrays.stream(as).max().getAsInt();
    int max = Arrays.stream(bs).min().getAsInt();
    List<String> xs = new ArrayList<>();
    for (int i = min; i <= max; i++) {
      int a = lcm(i, min);
      int b = gcd(max, i);
      if (lcm(i, min) == gcd(max, i)) {
        xs.add(String.format("a: %s, b: %s, i: %s", a, b, i));
      }
    }

    return xs.size();
  }

  /**
   * Solve by brute force. Check every int between min & max that every elem of A is a factor and a
   * factor of every B.
   */
  private static int bruteForce(int[] as, int[] bs) {
    int min = as[as.length - 1];
    int max = bs[0];

    int xs = 0;
    for (int i = min; i <= max; i++) {
      final int j = i;
      long aFactors = Arrays.stream(as).filter(f -> !isFactor(f, j)).count();
      long bFactors = Arrays.stream(bs).filter(f -> !isFactor(j, f)).count();
      if (aFactors == 0 && bFactors == 0) {
        xs++;
      }
    }

    return xs;
  }

  private static boolean isFactor(int a, int b) {
    return b % a == 0;
  }
}
