package com.github.java.strings;

import java.util.Scanner;

public class JavaStringReverse {

  public static void main(String[] args) {

    //Scanner scanner = new Scanner(System.in);
    //String input = scanner.next();
    String input = "madam";

    /* Enter your code here. Print output to STDOUT. */
    int len, halfLen;
    len = input.length();
    halfLen = (int) Math.floor(len / 2);
    boolean palindrome = true;
    for (int i = 0; i < halfLen; i++) {
      String start, finish;
      start = input.substring(i, i + 1);
      finish = input.substring(len - i - 1, len - i);
      if (!start.equals(finish)) {
        palindrome = false;
        break;
      }
    }

    System.out.println(palindrome ? "Yes" : "No");
  }
}
