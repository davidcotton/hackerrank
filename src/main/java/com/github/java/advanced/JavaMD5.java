package com.github.java.advanced;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class JavaMD5 {

  public static void main(String[] args) throws NoSuchAlgorithmException {
    // Enter your code here. Read input from STDIN.
    // Print output to STDOUT. Your class should be named Solution.

    // read input
    Scanner scanner = new Scanner(System.in);
    String input = scanner.next();
    scanner.close();

    // MD5 encode
    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
    byte[] digest = messageDigest.digest(input.getBytes());

    // convert to string (zero pad)
    BigInteger bigInt = new BigInteger(1, digest);
    StringBuilder hash = new StringBuilder(bigInt.toString(16));
    while (hash.length() < 32) {
      hash.insert(0, "0");
    }
    System.out.println(hash);
  }
}
