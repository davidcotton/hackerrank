package com.github.java.exceptionHandling;

import java.util.Scanner;

public class JavaExceptionHandlingTryCatch {

  public static void main(String[] args) {
    // Enter your code here. Read input from STDIN.
    // Print output to STDOUT. Your class should be named Solution.
    Scanner scanner = new Scanner(System.in);
    try {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int c = a / b;
      System.out.println(c);
    } catch (ArithmeticException e) {
      System.out.print(e.getClass().getName() + ": / by zero");
    } catch (Exception e) {
      System.out.print(e.getClass().getName());
    }
  }
}
