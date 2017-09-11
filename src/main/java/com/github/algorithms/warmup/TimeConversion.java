package com.github.algorithms.warmup;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeConversion {

  public static void main(String[] args) {
    // Enter your code here. Read input from STDIN.
    // Print output to STDOUT. Your class should be named Solution.
    //Scanner scanner = new Scanner(System.in);
    //String input = scanner.next();
    String input = "07:05:45PM";
    LocalTime localTime = LocalTime.parse(input, DateTimeFormatter.ofPattern("hh:mm:ssa"));
    System.out.println(localTime.format(DateTimeFormatter.ISO_TIME));
  }
}
