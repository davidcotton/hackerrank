package com.github.java.strings;

import java.util.Scanner;

public class JavaStringsIntroduction {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String a = scanner.next();
    String b = scanner.next();

    /* Enter your code here. Print output to STDOUT. */
    System.out.println(a.length() + b.length());
    System.out.println(a.compareTo(b) < 0 ? "Yes" : "No");
    System.out.printf("%s %s", capitalize(a), capitalize(b));
  }

  private static String capitalize(String input) {
    return input.substring(0, 1).toUpperCase() + input.substring(1);
  }
}
