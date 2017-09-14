package com.github.algorithms.implementation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BirthdayChocolate {

  private static int solve(int n, int[] ints, int goalSum, int consecutive) {
    Deque<Integer> deque = new ArrayDeque<>();
    int runningSum = 0;
    int success = 0;
    for (int i : ints) {
      deque.add(i);
      runningSum += i;
      if (deque.size() == consecutive) {
        if (runningSum == goalSum) {
          success++;
        }
        runningSum -= deque.poll();
      }
    }

    return success;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] ints = new int[n];
    for (int i = 0; i < n; i++) {
      ints[i] = scanner.nextInt();
    }
    int day = scanner.nextInt();
    int month = scanner.nextInt();
    int result = solve(n, ints, day, month);
    System.out.println(result);
  }
}
