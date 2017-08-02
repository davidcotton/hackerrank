package com.github.java.bignumber;

import java.math.BigInteger;
import java.util.Scanner;

public class JavaPrimalityTest {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    BigInteger n = scanner.nextBigInteger();
    scanner.close();

    // Write your code here.
    System.out.println(n.isProbablePrime(1) ? "prime" : "not prime");
  }
}
