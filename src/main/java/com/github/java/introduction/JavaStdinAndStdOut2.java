package com.github.java.introduction;

import java.util.Scanner;

public class JavaStdinAndStdOut2 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int i = scan.nextInt();

    // Write your code here.
    double d = scan.nextDouble();
    scan.nextLine(); // read the empty newline at the end of the double
    String s = scan.nextLine();

    System.out.println("String: " + s);
    System.out.println("Double: " + d);
    System.out.println("Int: " + i);
  }
}
