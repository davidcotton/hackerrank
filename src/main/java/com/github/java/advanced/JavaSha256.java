package com.github.java.advanced;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class JavaSha256 {

  public static void main(String[] args) throws NoSuchAlgorithmException {
    // Enter your code here. Read input from STDIN.
    // Print output to STDOUT. Your class should be named Solution.

    // read input
    Scanner scanner = new Scanner(System.in);
    String input = scanner.next();
    scanner.close();

    // SHA-256 encode
    // MD5 encode
    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
    byte[] digest = messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));

    // convert to string (zero pad)
    for (byte b : digest) {
      System.out.format("%02x", b);
    }

//    BigInteger bigInt = new BigInteger(1, digest);
//    StringBuilder hash = new StringBuilder(bigInt.toString(16));
//    while (hash.length() < 64) {
//      hash.insert(0, "0");
//    }
//    System.out.println(hash);
  }
}
