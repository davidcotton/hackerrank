package com.github.java.datastructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class JavaSort {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCases = Integer.parseInt(scanner.nextLine());

    List<Student> students = new ArrayList<>();
    while (testCases > 0) {
      int id = scanner.nextInt();
      String firstName = scanner.next();
      double cgpa = scanner.nextDouble();

      Student student = new Student(id, firstName, cgpa);
      students.add(student);

      testCases--;
    }

    students.sort(Comparator
        .comparingDouble(Student::getCgpa).reversed()
        .thenComparing(Student::getFirstName)
        .thenComparingInt(Student::getId)
    );

    for (Student student : students) {
      System.out.println(student.getFirstName());
    }
  }
}

class Student {
  private int id;
  private String firstName;
  private double cgpa;

  public Student(int id, String firstName, double cgpa) {
    super();
    this.id = id;
    this.firstName = firstName;
    this.cgpa = cgpa;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public double getCgpa() {
    return cgpa;
  }
}
