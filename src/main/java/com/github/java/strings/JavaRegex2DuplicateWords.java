package com.github.java.strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRegex2DuplicateWords {

  public static void main(String[] args) {
    // Write a RegEx matching repeated words here.
    String regex = "\\b(\\w+)(\\b\\W+\\b\\1\\b)*";
    String answerRegex = "(\\b\\w+\\b)(\\s+\\1\\b)+";
    // Insert the correct Pattern flag here.
    Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

    Scanner scanner = new Scanner(System.in);
    //int numSentences = Integer.parseInt(scanner.nextLine());
    int numSentences = 5;
    String[] inputs = {
        "Hello hello Ab aB",
        "in inthe",
        "Reya is is the the best player in eye eye game",
        "Sam went went to to to his business",
        "Goodbye bye bye world world world"
    };

    while (numSentences-- > 0) {
      //String input = scanner.nextLine();
      String input = inputs[numSentences];

      Matcher m = p.matcher(input);

      // Check for sub-sequences of input that match the compiled pattern
      while (m.find()) {
        // The regex to replace, The replacement
        input = input.replaceAll(m.group(), m.group(1));
      }

      // Prints the modified sentence.
      System.out.println(input);
    }

    scanner.close();
  }
}
