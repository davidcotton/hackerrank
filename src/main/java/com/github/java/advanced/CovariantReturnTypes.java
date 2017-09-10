package com.github.java.advanced;

import java.util.Scanner;

public class CovariantReturnTypes {
}

interface Flower {
  String whatsYourName();
}

class Jasmine implements Flower {
  @Override
  public String whatsYourName() {
    return "Jasmine";
  }
}

class Lily implements Flower {
  @Override
  public String whatsYourName() {
    return "Lily";
  }
}

class Lotus implements Flower {
  @Override
  public String whatsYourName() {
    return "Lotus";
  }
}

interface State {
  Flower yourNationalFlower();
}

class WestBengal implements State {
  @Override
  public Flower yourNationalFlower() {
    return new Jasmine();
  }
}

class Karnataka implements State {
  @Override
  public Flower yourNationalFlower() {
    return new Lotus();
  }
}

class AndhraPradesh implements State {
  @Override
  public Flower yourNationalFlower() {
    return new Lily();
  }
}

class Solution2 {
  public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    Scanner scanner = new Scanner(System.in);
    String className = scanner.next();

    String builder = "hackerrank.java.advanced." + className;

    State state = (State) Class.forName(builder).newInstance();
    Flower flower = state.yourNationalFlower();
    System.out.println(flower.whatsYourName());

    scanner.close();
  }
}
