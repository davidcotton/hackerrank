package com.github.algorithms.implementation;

import java.util.Scanner;

public class Kangaroo {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int k1 = scanner.nextInt();
    int j1 = scanner.nextInt();
    int k2 = scanner.nextInt();
    int j2 = scanner.nextInt();

//    int k1 = 0;
//    int j1 = 3;
//    int k2 = 4;
//    int j2 = 2;

    if (k2 < k1) {
      int temp = j1;
      j1 = j2;
      j2 = temp;
      temp = k1;
      k1 = k2;
      k2 = temp;
    }

    System.out.println(((j2 < j1) && ((k2 - k1) % (j2 - j1) == 0)) ? "YES" : "NO");
  }
}
