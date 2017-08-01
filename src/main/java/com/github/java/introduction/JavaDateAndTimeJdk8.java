package com.github.java.introduction;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class JavaDateAndTimeJdk8 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String month = in.next();
    String day = in.next();
    String year = in.next();

    LocalDate date = LocalDate.of(
        Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)
    );
    DayOfWeek dayOfWeek = date.getDayOfWeek();
    String weekDay = dayOfWeek.name();
    System.out.println(weekDay);
  }
}
