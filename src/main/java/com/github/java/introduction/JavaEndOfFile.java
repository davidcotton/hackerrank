package com.github.java.introduction;

import java.util.Scanner;

public class JavaEndOfFile {

  public static void main(String[] args) {
    // Enter your code here.
    // Read input from STDIN. Print output to STDOUT.
    // Your class should be named Solution.
    int i = 1;
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      System.out.printf("%s %s%n", i, scanner.nextLine());
      i++;
    }
  }
}
