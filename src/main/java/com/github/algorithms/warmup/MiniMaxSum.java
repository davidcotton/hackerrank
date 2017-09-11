package com.github.algorithms.warmup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MiniMaxSum {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = 5;
    List<Long> numbers = new ArrayList<>();
    while (n-- > 0) {
      numbers.add(scanner.nextLong());
    }

    List<Long> mins = new ArrayList<>(numbers);
    List<Long> maxs = new ArrayList<>(numbers);

    mins.remove(mins.indexOf(Collections.min(mins)));
    maxs.remove(maxs.indexOf(Collections.max(maxs)));

    System.out.printf("%s %s", maxs.stream().mapToLong(i -> i).sum(), mins.stream().mapToLong(i -> i).sum());
  }
}
