package com.github.java.datastructures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class JavaComparator {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    Player[] player = new Player[n];
    Checker checker = new Checker();

    for (int i = 0; i < n; i++) {
      player[i] = new Player(scanner.next(), scanner.nextInt());
    }
    scanner.close();

    Arrays.sort(player, checker);
    for (int i = 0; i < player.length; i++) {
      System.out.printf("%s %s\n", player[i].name, player[i].score);
    }
  }
}

class Checker implements Comparator<Player> {

  @Override
  public int compare(Player o1, Player o2) {
    int compare = Integer.compare(o2.score, o1.score);
    return compare == 0 ? o1.name.compareTo(o2.name) : compare;
  }
}

class Player {
  String name;
  int score;

  Player(String name, int score) {
    this.name = name;
    this.score = score;
  }
}
