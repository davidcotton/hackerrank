package com.github.java.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaStringTokens {

  public static void main(String[] args) {
    //Scanner scanner = new Scanner(System.in);
    //String input = scanner.nextLine();
    //scanner.close();
    //String input = "He is a very very good boy, isn't he?";
    //String input = "                a                    ";
    String input = "                        ";

    // Write your code here.
    String regex = "[\\s!,'_?@.]+";
    List<String> tokens = new ArrayList<>();
    for (String token : input.trim().split(regex)) {
      if (token.length() > 0) {
        tokens.add(token);
      }
    }

    System.out.println(tokens.size());
    for (String r : tokens) {
      System.out.println(r);
    }

  }

  static void solution() {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine().trim();
    scanner.close();

    if (s.length() == 0) {
      System.out.println(0);
    } else {
      // Strip out non-word characters and replace with whitespace,
      // trim leading/trailing whitespace
      s = s.replaceAll("[^\\p{Alpha}]+", " ").trim();

      if (s.isEmpty()) {
        // String contains no valid tokens
        System.out.println(0);
      } else {
        // Split the string into valid tokens
        String[] strings = s.split("\\p{Space}+");

        // Print number of tokens
        System.out.println(strings.length);

        // Print each token
        for (String str : strings) {
          System.out.println(str);
        }
      }
    }
  }
}
