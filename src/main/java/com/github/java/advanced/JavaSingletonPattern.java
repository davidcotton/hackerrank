package com.github.java.advanced;

public class JavaSingletonPattern {

  public String str;
  private static JavaSingletonPattern self;

  private JavaSingletonPattern() {}

  public static JavaSingletonPattern getSingleInstance() {
    if (self == null) {
      self = new JavaSingletonPattern();
    }
    return self;
  }
}
