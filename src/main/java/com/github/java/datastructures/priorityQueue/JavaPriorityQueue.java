package com.github.java.datastructures.priorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class JavaPriorityQueue {
}

class Priorities {
  List<Student> getStudents(List<String> events) {
    Comparator<Student> studentComparator = Comparator
        .comparing(Student::getCgpa).reversed()
        .thenComparing(Student::getName)
        .thenComparing(Student::getId);
    PriorityQueue<Student> pq = new PriorityQueue<>(studentComparator);
    for (String event : events) {
      if (event.equals("SERVED")) {
        pq.poll();
      } else {
        String[] parts = event.split(" ");
        pq.add(new Student(Integer.parseInt(parts[3]), parts[1], Double.parseDouble(parts[2])));
      }
    }

    List<Student> students = new ArrayList<>();
    while (!pq.isEmpty()) {
      students.add(pq.poll());
    }
    return students;
  }
}

class Student {
  private int id;
  private String name;
  private double cgpa;

  Student(int id, String name, double cgpa) {
    super();
    this.id = id;
    this.name = name;
    this.cgpa = cgpa;
  }

  int getId() {
    return id;
  }

  String getName() {
    return name;
  }

  double getCgpa() {
    return cgpa;
  }
}

class Solution {
  private final static Scanner scan = new Scanner(System.in);
  private final static Priorities priorities = new Priorities();

  public static void main(String[] args) {
//    int totalEvents = Integer.parseInt(scan.nextLine());
//    List<String> events = new ArrayList<>();
//
//    while (totalEvents-- != 0) {
//      String event = scan.nextLine();
//      events.add(event);
//    }
    List<String> events = Arrays.asList(
        "ENTER John 3.75 50",
        "ENTER Mark 3.8 24",
        "ENTER Shafaet 3.7 35",
        "SERVED",
        "SERVED",
        "ENTER Samiha 3.85 36",
        "SERVED",
        "ENTER Ashley 3.9 42",
        "ENTER Maria 3.6 46",
        "ENTER Anik 3.95 49",
        "ENTER Dan 3.95 50",
        "SERVED"
    );

    List<Student> students = priorities.getStudents(events);

    if (students.isEmpty()) {
      System.out.println("EMPTY");
    } else {
      for (Student st : students) {
        System.out.println(st.getName());
      }
    }
  }
}
