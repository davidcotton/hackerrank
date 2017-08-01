package com.github.java.introduction;

import java.util.Scanner;

public class JavaLoops2 {

  public static void main(String[] argh) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();

    for (int i = 0; i < t; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int n = in.nextInt();

      int[] nums = new int[n];
      int num = a;
      for (int j = 0; j < n; j++) {
        num += b * (1 << j);
        nums[j] = num;
      }

      StringBuilder builder = new StringBuilder();
      for (int j : nums) {
        builder.append(j + " ");
      }
      System.out.println(builder.toString());
    }

    in.close();
  }
}
