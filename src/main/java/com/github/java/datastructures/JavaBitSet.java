package com.github.java.datastructures;

import java.util.BitSet;
import java.util.Scanner;

public class JavaBitSet {

  public static void main(String[] args) {
    // Enter your code here. Read input from STDIN.
    // Print output to STDOUT. Your class should be named Solution.
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();

    BitSet[] bitSets = {null, new BitSet(n), new BitSet(n)};

    for (int i = 0; i < m; i++) {
      String op = scanner.next();
      int left = scanner.nextInt();
      int right = scanner.nextInt();

      switch (op) {
        case "AND":
          bitSets[left].and(bitSets[right]);
          break;
        case "OR":
          bitSets[left].or(bitSets[right]);
          break;
        case "XOR":
          bitSets[left].xor(bitSets[right]);
          break;
        case "FLIP":
          bitSets[left].flip(right);
          break;
        case "SET":
          bitSets[left].set(right);
          break;
      }

      System.out.printf("%s %s\n", bitSets[1].cardinality(), bitSets[2].cardinality());
    }
  }
}
