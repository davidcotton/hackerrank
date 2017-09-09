package com.github.java.oop;

import java.util.Scanner;

public class JavaInterface {
  public static void main(String[] args) {
    MyCalculator my_calculator = new MyCalculator();
    System.out.print("I implemented: ");
    ImplementedInterfaceNames(my_calculator);
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.print(my_calculator.divisor_sum(n) + "\n");
    sc.close();
  }

  /*
   *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
   */
  static void ImplementedInterfaceNames(Object o) {
    Class[] theInterfaces = o.getClass().getInterfaces();
    for (int i = 0; i < theInterfaces.length; i++) {
      String interfaceName = theInterfaces[i].getName();
      System.out.println(interfaceName);
    }
  }
}

interface AdvancedArithmetic {
  int divisor_sum(int n);
}

class MyCalculator implements AdvancedArithmetic {
  @Override
  public int divisor_sum(int n) {
    int sum = 1;
    for (int i = 2; i <= n; i++) {
      if (n % i == 0) {
        sum += i;
      }
    }
    return sum;
  }

  public int divisor_sum_more_efficient(int n) {
    // trivial cases
    if (n < 1) {
      return 0;
    } else if (n == 1) {
      return 1;
    }

    // all factors are paired, e.g. 6 has factors (1, 6) & (2, 3)
    // we can reduce the search space by searching up to sqrt(n)
    // 1 & n will always be factors (n != 1) so we can assume them.
    int max = (int) Math.sqrt(n);
    int sum = n + 1;
    for (int i = 2; i <= max; i++) {
      if (n % i == 0) {
        sum += i;
        int d = n / i;
        if (d != i) {
          sum += d;
        }
      }
    }

    return sum;
  }
}
