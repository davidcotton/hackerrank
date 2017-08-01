package com.github.java.introduction;

import java.util.Scanner;

public class JavaStaticInitializerBlock {

  static Scanner scanner = new Scanner(System.in);
  static boolean flag = true;
  static int B = scanner.nextInt();
  static int H = scanner.nextInt();

  static {
    try {
      if (B <= 0 || H <= 0) {
        flag = false;
        throw new Exception("Breadth and height must be positive");
      }
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  public static void main(String[] args) {
    if (flag) {
      int area = B * H;
      System.out.print(area);
    }
  }
}
