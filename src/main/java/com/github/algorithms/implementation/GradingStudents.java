package com.github.algorithms.implementation;

import static com.github.InputHelper.readIntArray;

public class GradingStudents {

  public static void main(String[] args) {
//    for (int grade : readIntArray()) {
    for (int grade : readIntArray2()) {
      System.out.println(adjustGrade(grade));
    }
  }

  private static int adjustGrade(int grade) {
    if (grade >= 38) {
      int modeFive = grade % 5;
      if (modeFive > 2) {
        grade += 5 - modeFive;
      }
    }

    return grade;
  }

  private static int[] readIntArray2() {
    return new int[]{73, 67, 38, 33};
  }
}
