//package com.github.java.datastructures;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//
//public class JavaArrayList {
//
//  public static void main(String[] args) {
//    // Enter your code here. Read input from STDIN.
//    // Print output to STDOUT. Your class should be named Solution.
//    List<String> solutions = solve(readInput2(), readQueries());
//    for (String solution : solutions) {
//      System.out.println(solution);
//    }
//  }
//
//  private static List<String> solve(List<List<Integer>> inputs, List<Query> queries) {
//    List<String> result = new ArrayList<>();
//    for (Query query : queries) {
//      try {
//        result.add(inputs.get(query.x - 1).get(query.y) + "");
//      } catch (IndexOutOfBoundsException e) {
//        result.add("ERROR!");
//      }
//    }
//
//    return result;
//  }
//
//  /**
//   * Read input in.
//   */
//  private static List<List<Integer>> readInput() {
//    Scanner scanner = new Scanner(System.in);
//    int n = scanner.nextInt();
//    List<List<Integer>> input = new ArrayList<>();
//    for (int i = 0; i < n; i++) {
//      int d = scanner.nextInt();
//      List<Integer> nums = new ArrayList<>();
//      while (nums.size() < d) {
//        nums.add(scanner.nextInt());
//      }
//      input.add(nums);
//    }
//
//    return input;
//  }
//
//  /**
//   * Read queries in.
//   */
//  private static List<Query> readQueries() {
//    Scanner scanner = new Scanner(System.in);
//    int n = scanner.nextInt();
//    List<Query> queries = new ArrayList<>();
//    while (queries.size() < n) {
//      queries.add(new Query(scanner.nextInt(), scanner.nextInt()));
//    }
//
//    return queries;
//  }
//
//  private static List<List<Integer>> readInput2() {
//    return new ArrayList<List<Integer>>() {{
//      add(new ArrayList<>(Arrays.asList(5, 41, 77, 74, 22, 44)));
//      add(new ArrayList<>(Arrays.asList(1, 12)));
//      add(new ArrayList<>(Arrays.asList(4, 37, 34, 36, 52)));
//      add(new ArrayList<>(Arrays.asList(0)));
//      add(new ArrayList<>(Arrays.asList(3, 20, 22, 33)));
//    }};
//  }
//
//  private static List<Query> readQueries2() {
//    return new ArrayList<Query>() {{
//      add(new Query(1, 3));
//      add(new Query(3, 4));
//      add(new Query(3, 1));
//      add(new Query(4, 3));
//      add(new Query(5, 5));
//    }};
//  }
//}
//
//class Query {
//  int x, y;
//
//  Query(int x, int y) {
//    this.x = x;
//    this.y = y;
//  }
//
//  @Override
//  public String toString() {
//    return String.format("<Q>[%s:%s]", x, y);
//  }
//}
