package com.github.algorithms.warmup;

import static com.github.InputHelper.readIntArray;

public class BirthdayCakeCandles {

  public static void main(String[] args) {
    int[] n = readIntArray();
    System.out.println(birthdayCakeCandles(n.length, n));
  }

  static int birthdayCakeCandles(int n, int[] candles) {
    // Complete this function
    int maxHeight = 0;
    int numCandles = 0;
    for (int i = 0; i < n; i++) {
      if (candles[i] > maxHeight) {
        maxHeight = candles[i];
        numCandles = 1;
      } else if (candles[i] == maxHeight) {
        numCandles++;
      }
    }

    return numCandles;
  }
}
