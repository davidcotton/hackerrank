package com.github.java.strings;

public class JavaStringCompare {

  public static void main(String[] args) {

    //Scanner scanner = new Scanner(System.in);
    //String input = scanner.next();
    //int len = scanner.nextInt();

    String input = "welcometojava";
    int len = 3;

    String min, max;
    min = max = input.substring(0, len);
    for (int i = 0; i <= (input.length() - len); i++) {
      String str = input.substring(i, (len + i));
      if (min.compareTo(str) > 0) {
        min = str;
      }
      if (str.compareTo(max) > 0) {
        max = str;
      }
    }

    System.out.printf("%s\n%s", min, max);
  }
}
