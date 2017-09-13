package com.github.algorithms.implementation;

import java.util.Scanner;

public class BreakingTheRecords {

  private static int[] getRecord(int[] ints) {
    int nHighScores = 0;
    int nLowScores = 0;
    int highScore = ints[0];
    int lowScore = ints[0];

    for (int i = 1; i < ints.length; i++) {
      if (ints[i] > highScore) {
        highScore = ints[i];
        nHighScores++;
      }
      if (ints[i] < lowScore) {
        lowScore = ints[i];
        nLowScores++;
      }
    }

    return new int[]{nHighScores, nLowScores};
  }

  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    int n = scanner.nextInt();
//    int[] ints = new int[n];
//    for (int i = 0; i < n; i++) {
//      ints[i] = scanner.nextInt();
//    }

    int[] ints = {10, 5, 20, 20, 4, 5, 2, 25, 1};
//    int[] ints = {3, 4, 21, 36, 10, 28, 35, 5, 24, 42};

    int[] result = getRecord(ints);
    String separator = "", delimiter = " ";
    for (Integer val : result) {
      System.out.print(separator + val);
      separator = delimiter;
    }

    System.out.println("");
  }
}
