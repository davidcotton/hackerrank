package com.github.java.introduction;

import java.util.Scanner;

public class JavaLoops1 {

  final static int M = 10;

  public static void main(String[] args) {
    // Enter your code here. Read input from STDIN.
    // Print output to STDOUT. Your class should be named Solution.
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    for (int i = 1; i < M + 1; i++) {
      System.out.printf("%d x %d = %d%n", n, i, n * i);
    }
  }
}
