package com.github.algorithms.implementation;

import java.util.Arrays;

public class AppleAndOrange {

  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    int houseLeft = scanner.nextInt();
//    int houseRight = scanner.nextInt();
//    int appleTree = scanner.nextInt();
//    int orangeTree = scanner.nextInt();
//    int m = scanner.nextInt();
//    int n = scanner.nextInt();
//    int[] apples = new int[m];
//    for (int apple_i = 0; apple_i < m; apple_i++) {
//      apples[apple_i] = scanner.nextInt();
//    }
//    int[] oranges = new int[n];
//    for (int orange_i = 0; orange_i < n; orange_i++) {
//      oranges[orange_i] = scanner.nextInt();
//    }

    int houseLeft = 7;
    int houseRight = 11;
    int appleTree = 5;
    int orangeTree = 15;
    int[] apples = {-2, 2, 1};
    int[] oranges = {5, -6};

    System.out.println(Arrays.stream(apples)
        .filter(apple -> appleTree + apple >= houseLeft && appleTree + apple <= houseRight)
        .count()
    );
    System.out.println(Arrays.stream(oranges)
        .filter(orange -> orangeTree + orange >= houseLeft && orangeTree + orange <= houseRight)
        .count()
    );
  }
}
