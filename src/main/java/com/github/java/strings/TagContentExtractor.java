package com.github.java.strings;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class TagContentExtractor {

  public static void main(String[] args) {

    //Scanner scanner = new Scanner(System.in);
    //int testCases = Integer.parseInt(scanner.nextLine());
    int testCases = 1;
    String[] cases = {
//        "<SA premium>Imtiaz has a secret crush</SA premium>",
//        "<Amee>safat codes like a ninja</amee>",
//        "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>",
//        "<h1>Sanjay has no watch<h1></h1></h1><par>So wait for a while</par>",
        "<h1>Nayeem loves counseling</h1>",
//        "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<",
//        "<>hello</>",
//        "<h1>had<h1>public</h1></h1>",
//        "<h1><h1></h1></h1>",

//        "bMUGux)5n7L={M}e^`0xlSm5ce}ehiE}CJ6y0KPd~~B~ak5$PTdPGv}QnXpw6n9V8wVCVaTRTgLKkeF",
//        "bMUGux)5n7L={M}e^`0xlSm5ce}ehiE}CJ6y0KPd~~B~ak5$PTdPGv}QnXpw6n9V8wVCVaTRTgLKkeF",
    };

    while (testCases > 0) {
      //String line = scanner.nextLine();
      String line = cases[testCases - 1];

      //Write your code here
      System.out.println(regex(line));
      //System.out.println(stack(line));
      //System.out.println(xmlParser(line));

      testCases--;
    }
  }

  private static String regex(String line) {
    String regex = "<(.+)>([^<]+)</\\1>";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(line);
    String result = "";
    while (matcher.find()) {
      String match = matcher.group(2);
      if (match.length() > 0) {
        result += match + "\n";
      }
    }
    return result.length() > 0 ? result : "None\n";
  }

  private static String stack(String line) {
    List<String> tokens = tokenize(line);
    List<String> contents = extractContent(tokens);

    String result = "";
    if (contents.isEmpty()) {
      result = "None\n";
    } else {
      for (String content : contents) {
        result += content + "\n";
      }
    }

    return result;
  }

  /**
   * Extract the content from HTML/XML.
   */
  private static List<String> extractContent(List<String> tokens) {
    List<String> results = new ArrayList<>();
    Stack<String> stack = new Stack<>();
    for (String token : tokens) {
      if (isTag(token)) {
        if (isOpeningTag(token)) {
          if (!stack.empty() && !isTag(stack.peek())) {
            stack.pop();
          }
          stack.push(token);
        } else {
          if (stack.size() < 2) {
            continue;
          }
          String content = stack.pop();
          if (isTag(content)) {
            continue;
          }
          String openingTag = stack.pop();
          if (areMatchingTags(openingTag, token)) {
            results.add(content);
          }
        }
      } else {
        stack.push(token);
      }
    }

    return results;
  }

  /**
   * Is the token a valid XML tag.
   */
  private static boolean isTag(String token) {
    return (token.charAt(0) == '<') &&
        (token.length() > 2) &&
        (token.charAt(token.length() - 1) == '>') &&
        !token.equals("</>");
  }

  /**
   * Is a valid tag an opening tag?
   */
  private static boolean isOpeningTag(String tag) {
    return tag.charAt(1) != '/';
  }

  /**
   * Do a pair of tags match?
   */
  private static boolean areMatchingTags(String tag1, String tag2) {
    tag1 = stripEnds(tag1);
    tag2 = stripEnds(tag2);
    return tag1.equals(tag2.substring(1));
  }

  /**
   * Strip the ends from a tag.
   */
  public static String stripEnds(String tag) {
    return tag.substring(1, tag.length() - 1);
  }

  /**
   * Tokenize HTML into tags and elements.
   */
  private static List<String> tokenize(String str) {
    List<String> tags = new ArrayList<>();
    String regex = "((?<=>)|(?=<))";
    for (String token : str.split(regex)) {
      if (token.length() > 0) {
        tags.add(token);
      }
    }

    return tags;
  }

  public static String xmlParser(String line) {
    String result = "";
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(new ByteArrayInputStream(line.getBytes("UTF-8")));
      Element root = document.getDocumentElement();
      result = root.getTextContent();
    } catch (Exception e) {
      // do nothing
    }

    return result;
  }
}
