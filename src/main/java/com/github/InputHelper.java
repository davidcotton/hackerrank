package com.github;

import java.util.Scanner;

public class InputHelper {

  public static int[] readIntArray() {
    Scanner scanner = new Scanner(System.in);
    int n  = scanner.nextInt();
    int[] ints = new int[n];
    for (int i = 0; i < n; i++) {
      ints[i] = scanner.nextInt();
    }
    scanner.close();

    return ints;
  }

  public static long[] readLongArray() {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    long[] ints = new long[n];
    for (int i = 0; i < n; i++) {
      ints[i] = scanner.nextInt();
    }
    scanner.close();

    return ints;
  }

  public static String[] readStringArray() {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    String[] strings = new String[n + 2];
    for (int i = 0; i < n; i++) {
      strings[i] = scanner.next();
    }
    scanner.close();

    return strings;
  }
}
