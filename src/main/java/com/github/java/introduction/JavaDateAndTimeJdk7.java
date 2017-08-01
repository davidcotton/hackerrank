package com.github.java.introduction;

import java.util.Calendar;
import java.util.Scanner;

public class JavaDateAndTimeJdk7 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String month = in.next();
    String day = in.next();
    String year = in.next();

    //////////////////////////
    Calendar calendar = Calendar.getInstance();
    calendar.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
    //SimpleDateFormat sdf = new SimpleDateFormat("EE").format();
  }
}
