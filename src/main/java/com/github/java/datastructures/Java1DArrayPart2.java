package com.github.java.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Java1DArrayPart2 {

  public static void main(String[] args) {
    // Enter your code here. Read input from STDIN.
    // Print output to STDOUT. Your class should be named Solution.
    for (TestCase testCase : readInput2()) {
      System.out.println(solve(testCase.integers, testCase.m) ? "YES" : "NO");
    }
  }

  /**
   * Solve.
   */
  private static boolean solve(List<Integer> array, int m) {
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> set = new HashSet<>();
    int[] moves = {m, 1, -1};

    queue.add(0);
    while (!queue.isEmpty()) {
      int current = queue.remove();
      for (int move : moves) {
        int node = current + move;
        if (node < 0) {
          continue;
        } else if (array.size() <= node) {
          return true;
        }
        int val = array.get(node);
        if (val != 0) {
          continue;
        }
        if (!set.contains(node)) {
          set.add(node);
          queue.add(node);
        }
      }
    }

    return false;
  }

  /**
   * Read input.
   */
  private static List<TestCase> readInput() {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    List<TestCase> testCases = new ArrayList<>();
    while (testCases.size() < t) {
      int n = scanner.nextInt();
      int m = scanner.nextInt();
      List<Integer> integers = new ArrayList<>();
      while (integers.size() < n) {
        integers.add(scanner.nextInt());
      }
      testCases.add(new TestCase(m, integers));
    }

    return testCases;
  }

  private static List<TestCase> readInput2() {
    return new ArrayList<TestCase>() {{
      // TEST CASE #1
      add(new TestCase(3, new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0))));
      add(new TestCase(5, new ArrayList<>(Arrays.asList(0, 0, 0, 1, 1, 1))));
      add(new TestCase(3, new ArrayList<>(Arrays.asList(0, 0, 1, 1, 1, 0))));
      add(new TestCase(1, new ArrayList<>(Arrays.asList(0, 1, 0))));

      // TEST CASE DAVO
      add(new TestCase(2, new ArrayList<>(Arrays.asList(0, 1, 0, 0, 1, 0))));

      // TEST CASE #6
      add(new TestCase(5, new ArrayList<>(Arrays.asList(0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1))));
      add(new TestCase(5, new ArrayList<>(Arrays.asList(0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1))));
      add(new TestCase(5, new ArrayList<>(Arrays.asList(0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1))));
      add(new TestCase(7, new ArrayList<>(Arrays.asList(0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1))));
      add(new TestCase(7, new ArrayList<>(Arrays.asList(0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1))));
    }};
  }
}

class TestCase {
  int m;
  List<Integer> integers;

  TestCase(int m, List<Integer> integers) {
    this.m = m;
    this.integers = integers;
  }
}
