package com.github.java.strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRegex3UsernameChecker {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    //int testCases = Integer.parseInt(in.nextLine());
    int testCases = 5;
    String[] cases = {
        "short",
        "123Swakkhar",
        "nagib@007",
        "xahidbuffon",
        "alpha_naheed"
    };

    while (testCases > 0) {
      //String username = in.nextLine();
      String username = cases[testCases - 1];

      // String pattern = Complete this line in the editable area below

      // `^` start of line
      // `[\\p{Alpha}]` first char must be alphabetic
      // `[\\p{Alnum}_]{7,29}` next 7-29 chars must be alphanumeric or `_`
      // `$` end of line
      String pattern = "^[\\p{Alpha}][\\p{Alnum}_]{7,29}$";

      // End editable area
      Pattern r = Pattern.compile(pattern);
      Matcher m = r.matcher(username);

      if (m.find()) {
        System.out.println("Valid" + ": \"" + username + "\"");
      } else {
        System.out.println("Invalid" + ": \"" + username + "\"");
      }
      testCases--;
    }
  }
}
