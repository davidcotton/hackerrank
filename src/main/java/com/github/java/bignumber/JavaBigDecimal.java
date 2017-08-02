package com.github.java.bignumber;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class JavaBigDecimal {

  public static void main(String[] args) {
    //Input
    Scanner scanner = new Scanner(System.in);
//    int n = scanner.nextInt();
//    String[] s = new String[n + 2];
//    for (int i = 0; i < n; i++) {
//      s[i] = scanner.next();
//    }
    scanner.close();

    int n = 9;
    String[] s = {
        "-100",
        "50",
        "0",
        "56.6",
        "90",
        "0.12",
        ".12",
        "02.34",
        "000.000",
    };

    // Write your code here
    //s = Arrays.copyOf(s, n);
//    Arrays.sort(s, new Comparator<String>() {
//      @Override
//      public int compare(String o1, String o2) {
//        BigDecimal a = new BigDecimal(o1);
//        BigDecimal b = new BigDecimal(o2);
//        return a.compareTo(b);
//      }
//    });

//    Arrays.sort(s, 0, n, (o1, o2) -> new BigDecimal(o1).compareTo(new BigDecimal(o2)));

    Arrays.sort(s, 0, n, Comparator.comparing(BigDecimal::new, Comparator.reverseOrder()));

    //Output
    for (int i = 0; i < n; i++) {
      System.out.println(s[i]);
    }
  }
}
