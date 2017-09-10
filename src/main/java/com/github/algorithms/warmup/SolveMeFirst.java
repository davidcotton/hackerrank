package com.github.algorithms.warmup;

import java.util.Scanner;

public class SolveMeFirst {

  private static int solveMeFirst(int a, int b) {
    return a + b;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a;
    a = scanner.nextInt();
    int b;
    b = scanner.nextInt();
    int sum;
    sum = solveMeFirst(a, b);
    System.out.println(sum);
  }
}
