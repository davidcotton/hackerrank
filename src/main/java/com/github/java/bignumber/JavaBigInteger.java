package com.github.java.bignumber;

import java.math.BigInteger;
import java.util.Scanner;

public class JavaBigInteger {

  public static void main(String[] args) {
    // Enter your code here. Read input from STDIN.
    // Print output to STDOUT. Your class should be named Solution.
    Scanner scanner = new Scanner(System.in);
    BigInteger a, b;
    a = scanner.nextBigInteger();
    b = scanner.nextBigInteger();
    System.out.println(a.add(b));
    System.out.println(a.multiply(b));
  }
}
