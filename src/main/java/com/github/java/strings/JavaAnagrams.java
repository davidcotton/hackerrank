package com.github.java.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaAnagrams {

  public static void main(String[] args) {

    //Scanner scanner = new Scanner(System.in);
    //String a = scanner.next();
    //String b = scanner.next();
    //scanner.close();
    String a, b;
    a = "anagram";
    b = "margana";

    boolean ret = isAnagram(a, b);
    System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
  }

  static boolean isAnagram(String a, String b) {

    // Complete the function by writing your code here.
    List<String> aList, bList;
    aList = new ArrayList<>(Arrays.asList(a.toLowerCase().split("")));
    bList = new ArrayList<>(Arrays.asList(b.toLowerCase().split("")));

    for (String c : aList) {
      if (bList.contains(c)) {
        bList.remove(c);
      } else  {
        return false;
      }
    }

    return bList.isEmpty();
  }

  static boolean isAnagram2(String a, String b) {
    char[] aList, bList;

    aList = a.toLowerCase().toCharArray();
    bList = b.toLowerCase().toCharArray();
    Arrays.sort(aList);
    Arrays.sort(bList);

    return Arrays.equals(aList, bList);
  }
}
