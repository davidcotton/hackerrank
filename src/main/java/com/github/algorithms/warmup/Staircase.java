package com.github.algorithms.warmup;

import java.util.Scanner;

public class Staircase {

  public static void main(String[] args) {
    // Enter your code here. Read input from STDIN.
    // Print output to STDOUT. Your class should be named Solution.
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
//    int n = 6;
    for (int i = 0; i < n; i++) {
      String format = "%" + (n) + "s\n";
      System.out.printf(format, new String(new char[i + 1]).replace("\0", "#"));
    }
  }
}
