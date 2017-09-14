package com.github.algorithms.sorting;

import java.util.Scanner;

public class IntroToTutorialChallenges {

  public static void main(String[] args) {
    // Enter your code here. Read input from STDIN.
    // Print output to STDOUT. Your class should be named Solution.
    Scanner scanner = new Scanner(System.in);
    int value = scanner.nextInt();
    int n = scanner.nextInt();
    int[] ints = new int[n];
    for (int i = 0; i < n; i++) {
      ints[i] = scanner.nextInt();
    }

//    int value = 4;
//    int[] ints = {1, 4, 5, 7, 9, 12};

    System.out.println(solve(ints, value));
    scanner.close();
  }

  private static int solve(int[] ints, int value) {
    for (int i = 0; i < ints.length; i++) {
      if (ints[i] == value) {
        return i;
      }
    }

    return -1;
  }
}
