package com.github.algorithms.warmup;

import java.util.Scanner;

public class DiagonalDifference {

  public static void main(String[] args) {
    // Enter your code here. Read input from STDIN.
    // Print output to STDOUT. Your class should be named Solution.
    int sum = 0;
//    int[][] matrix = readMatrix();
    int[][] matrix = readMatrix2();
    int n = matrix.length - 1;
    for (int i = 0; i <= n; i++) {
      sum += matrix[i][i] - matrix[i][n - i];
    }
    System.out.println(Math.abs(sum));
  }

  private static int[][] readMatrix() {
    Scanner scanner = new Scanner(System.in);
    int n  = scanner.nextInt();
    int[][] matrix = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = scanner.nextInt();
      }
    }

    return matrix;
  }

  private static int[][] readMatrix2() {
    return new int[][] {
        {11, 2, 4},
        {4, 5, 6},
        {10, 8, 12},
    };
  }
}
