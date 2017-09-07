package com.github.java.bignumber;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class JavaBigDecimal {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    String[] strings = new String[n + 2];
    for (int i = 0; i < n; i++) {
      strings[i] = scanner.next();
    }
    scanner.close();

    // Write your code here
    hackerrank(strings, n);
  }

  public static void hackerrank(String[] strings, int n) {
//    sortWithoutLambda(strings);
//    sortWithLambda(strings, n);
    sortWithMethodReference(strings, n);

    //Output
    for (int i = 0; i < n; i++) {
      System.out.println(strings[i]);
    }
  }

  private static void sortWithoutLambda(String[] strings) {
    Arrays.sort(strings, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        BigDecimal a = new BigDecimal(o1);
        BigDecimal b = new BigDecimal(o2);
        return a.compareTo(b);
      }
    });
  }

  private static void sortWithLambda(String[] strings, int n) {
    Arrays.sort(strings, 0, n, (o1, o2) -> new BigDecimal(o1).compareTo(new BigDecimal(o2)));
  }

  private static void sortWithMethodReference(String[] strings, int n) {
    Arrays.sort(strings, 0, n, Comparator.comparing(BigDecimal::new, Comparator.reverseOrder()));
  }
}
