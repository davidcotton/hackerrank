package com.github.java.datastructures;

import java.util.Arrays;
import java.util.stream.IntStream;


public class JavaSubArray {

  public static void main(String[] args) {
    // Enter your code here. Read input from STDIN.
    // Print output to STDOUT. Your class should be named Solution.
//    System.out.println(findNegSubArrays(readIntArray()));
  }

  /**
   * Davo's method.
   */
  private static int findNegSubArrays(int[] ints) {
    int negatives = 0;
    for (int i = 0; i < ints.length; i++) {
      for (int j = i; j < ints.length; j++) {
        int[] temp = Arrays.copyOfRange(ints, i, j + 1);
        int sum = IntStream.of(temp).parallel().sum();
        if (sum < 0) {
          negatives++;
        }
      }
    }

    return negatives;
  }

  /**
   * A more efficient way to calculate.
   */
  private static int findNegTextBookMethod(int[] array) {
    int count = 0;
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      for (int j = i; j < array.length; j++) {
        sum += array[j];
        if (sum < 0) {
          count++;
        }
      }
      sum = 0;
    }

    return count;
  }

  private static int[] readIntArray2() {
    return new int[]{1, -2, 4, -5, 1};
  }
}
