package com.github.java.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JavaList {

  public static void main(String[] args) {
    // Enter your code here. Read input from STDIN.
    // Print output to STDOUT. Your class should be named Solution.
    Scanner scanner = new Scanner(System.in);
    List<Integer> input = readInput2(scanner);
    for (Query query : readQueries2(scanner)) {
      input = query.execute(input);
    }

    input.forEach(i -> System.out.printf("%s ", i));
//    input.forEach(System.out::print);
  }

  private static List<Integer> readInput(Scanner scanner) {
    int n = scanner.nextInt();
    List<Integer> input = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      input.add(scanner.nextInt());
    }

    return input;
  }

  private static List<Integer> readInput2(Scanner scanner) {
    return new ArrayList<>(Arrays.asList(12, 0, 1, 78, 12));
  }

  private static Query[] readQueries(Scanner scanner) {
    int n = scanner.nextInt();
    Query[] queries = new Query[n];
    for (int i = 0; i < n; i++) {
      String type = scanner.next();
      if (type.equals("Insert")) {
        queries[i] = new Insert(scanner.nextInt(), scanner.nextInt());
      } else if (type.equals("Delete")) {
        queries[i] = new Delete(scanner.nextInt());
      }
    }

    return queries;
  }

  private static Query[] readQueries2(Scanner scanner) {
    return new Query[]{
        new Insert(5, 23),
        new Delete(0)
    };
  }

}

abstract class Query {
  abstract List<Integer> execute(List<Integer> input);
}

class Insert extends Query {
  int x, y;

  Insert(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  List<Integer> execute(List<Integer> input) {
    input.add(x, y);
    return input;
  }

  @Override
  public String toString() {
    return String.format("<I>[%s:%s]", x, y);
  }
}

class Delete extends Query {
  int x;

  Delete(int x) {
    this.x = x;
  }

  @Override
  List<Integer> execute(List<Integer> input) {
    input.remove(x);
    return input;
  }

  @Override
  public String toString() {
    return String.format("<D>[%s]", x);
  }
}
