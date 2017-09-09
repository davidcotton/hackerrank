package com.github.java.datastructures;

import static java.lang.Math.max;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JavaDequeue {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Deque<Integer> deque = new ArrayDeque<>();
    // can be done faster using a HashMap (num, count)
    // as deque.contains() is O(m) (worst case have to check every elem in deque)
    // however using HashSet is fast enough to pass
    Set<Integer> set = new HashSet<>();

//    int n = scanner.nextInt();
//    int m = scanner.nextInt();
    int n = 6;
    int m = 3;
    int[] nums = {5, 3, 5, 2, 3, 2};

    long count;
    for (int i = 0; i < m; i++) {
      deque.add(nums[i]);
      set.add(deque.peekLast());
    }
    count = set.size();

    int head;
    for (int i = m; i < n; i++) {
      head = deque.poll();
      deque.add(nums[i]);
      set.add(deque.peekLast());
      if (!deque.contains(head)) {
        set.remove(head);
      }
      count = max(count, set.size());
    }

    System.out.println(count);
  }
}
