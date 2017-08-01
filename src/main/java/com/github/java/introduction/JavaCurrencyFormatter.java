package com.github.java.introduction;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class JavaCurrencyFormatter {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double payment = scanner.nextDouble();
    scanner.close();

    // Write your code here.
    String us, india, china, france;
    us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
    china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
    france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);
    india = NumberFormat
        .getCurrencyInstance(new Locale("en", "IN"))
        .format(payment);

    System.out.println("US: " + us);
    System.out.println("India: " + india);
    System.out.println("China: " + china);
    System.out.println("France: " + france);
  }

}
