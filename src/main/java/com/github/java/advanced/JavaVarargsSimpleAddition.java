package com.github.java.advanced;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JavaVarargsSimpleAddition {
  public static void main(String[] args) {
//    readInput();
    readInput2();
  }

  static void readInput() {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n1 = Integer.parseInt(br.readLine());
      int n2 = Integer.parseInt(br.readLine());
      int n3 = Integer.parseInt(br.readLine());
      int n4 = Integer.parseInt(br.readLine());
      int n5 = Integer.parseInt(br.readLine());
      int n6 = Integer.parseInt(br.readLine());
      Add ob = new Add();
      ob.add(n1, n2, n3);
      ob.add(n1, n2, n3, n4, n5);
      ob.add(n1, n2, n3, n4, n5, n6);
      Method[] methods = Add.class.getDeclaredMethods();
      Set<String> set = new HashSet<>();
      boolean overload = false;
      for (int i = 0; i < methods.length; i++) {
        if (set.contains(methods[i].getName())) {
          overload = true;
          break;
        }
        set.add(methods[i].getName());
      }

      if (overload) {
        throw new Exception("Overloading not allowed");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static void readInput2() {
    Add ob = new Add();
    ob.add(1, 2, 3, 4, 5, 6);
    ob.addJava8Way(1, 2, 3, 4, 5, 6);
  }
}


class Add {
  void add(int... ints) {
    int sum = 0;
    StringBuilder sb = new StringBuilder();
    for (int n : ints) {
      sum += n;
      sb.append("+");
      sb.append(n);
    }
    System.out.println(String.format("%s=%s", sb.toString().substring(1), sum));
  }

  void addJava8Way(int... ints) {
    System.out.println(String.format("%s=%s", String.join("+", Arrays.toString(ints)), Arrays.stream(ints).sum()));
  }
}
