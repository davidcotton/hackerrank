package com.github.java.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class JavaStack {

  public static void main(String[] argh) {
//    Scanner scanner = new Scanner(System.in);
//    while (scanner.hasNext()) {
//      String input = scanner.next();
//      //Complete the code
//      System.out.println(checkBrackets(input));
//    }

    List<String> inputs = new ArrayList<>(Arrays.asList(
        "({}[])",
        "(({()})))",
        "({(){}()})()({(){}()})(){()}",
        "{}()))(()()({}}{}",
        "}}}}",
        "))))",
        "{{{",
        "(((",
        "[]{}(){()}((())){{{}}}{()()}{{}{}}",
        "[[]][][]"
    ));
    inputs.forEach(input -> System.out.println(checkBrackets(input)));
  }

  private static boolean checkBrackets(String input) {
    Stack<Character> stack = new Stack<>();
    Map<Character, Character> brackets = new HashMap<Character, Character>() {{
      put('(', ')');
      put('{', '}');
      put('[', ']');
    }};
    for (Character c : input.toCharArray()) {
      if (brackets.containsKey(c)) {
        stack.push(c);
      } else if (brackets.containsValue(c)) {
        if (stack.empty()) {
          return false;
        }
        if (brackets.get(stack.pop()) != c) {
          return false;
        }
      }
    }

    return stack.empty();
  }
}
