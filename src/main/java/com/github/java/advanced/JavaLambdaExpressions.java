package com.github.java.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JavaLambdaExpressions {

  public static void main(String[] args) throws IOException {
    MyMath myMath = new MyMath();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    PerformOperation operation;
    boolean ret;
    String ans = null;

    while (T-- > 0) {
      String s = br.readLine().trim();
      StringTokenizer tokenizer = new StringTokenizer(s);
      int type = Integer.parseInt(tokenizer.nextToken());
      int number = Integer.parseInt(tokenizer.nextToken());
      if (type == 1) {
        operation = myMath.isOdd();
        ret = MyMath.checker(operation, number);
        ans = (ret) ? "ODD" : "EVEN";
      } else if (type == 2) {
        operation = myMath.isPrime();
        ret = MyMath.checker(operation, number);
        ans = (ret) ? "PRIME" : "COMPOSITE";
      } else if (type == 3) {
        operation = myMath.isPalindrome();
        ret = MyMath.checker(operation, number);
        ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
      }

      System.out.println(ans);
    }
  }
}

interface PerformOperation {
  boolean check(int number);
}

class MyMath {
  static boolean checker(PerformOperation operation, int number) {
    return operation.check(number);
  }

  // WRITE YOUR CODE HERE
  ///////////////////////
  PerformOperation isOdd() {
    return n -> (n % 2 != 0);
  }

  PerformOperation isPrime() {
//    return n -> java.math.BigInteger.valueOf(n).isProbablePrime(10);

    return n -> {
      if (n <= 1) {
        return false;
      }
      if (n == 2) {
        return true;
      }
      if (n % 2 == 0) {
        return false;
      }

      int m = Double.valueOf(Math.ceil(Math.sqrt(n))).intValue();
      for (int i = 3; i < m; i += 2) {
        if (n % i == 0) {
          return false;
        }
      }

      return true;
    };
  }

  PerformOperation isPalindrome() {
    return n -> Integer.toString(n).equals(new StringBuilder(Integer.toString(n)).reverse().toString());
  }
  //////////////////////
  // END WRITE CODE HERE
}
