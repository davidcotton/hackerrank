package com.github.java.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {

  public static void main(String[] argh) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine();
    Map<String, Integer> phoneBook = new HashMap<>();
    for (int i = 0; i < n; i++) {
      phoneBook.put(scanner.nextLine(), scanner.nextInt());
      scanner.nextLine();
    }
    while (scanner.hasNext()) {
      String name = scanner.nextLine();
      System.out.println(phoneBook.containsKey(name)
          ? String.format("%s=%s", name, phoneBook.get(name))
          : "Not found"
      );
    }
  }
}
