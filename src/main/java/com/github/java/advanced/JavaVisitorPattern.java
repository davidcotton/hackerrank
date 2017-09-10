package com.github.java.advanced;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class JavaVisitorPattern {

  private static int[] values;
  private static Color[] colours;
  private static Map<Integer, Set<Integer>> map;

  public static void main(String[] args) {
    Tree root = solve();
    SumInLeavesVisitor sumInLeavesVisitor = new SumInLeavesVisitor();
    ProductOfRedNodesVisitor productOfRedNodesVisitor = new ProductOfRedNodesVisitor();
    FancyVisitor fancyVisitor = new FancyVisitor();

    root.accept(sumInLeavesVisitor);
    root.accept(productOfRedNodesVisitor);
    root.accept(fancyVisitor);

    int res1 = sumInLeavesVisitor.getResult();
    int res2 = productOfRedNodesVisitor.getResult();
    int res3 = fancyVisitor.getResult();

    System.out.println(res1);
    System.out.println(res2);
    System.out.println(res3);
  }

  private static Tree solve() {
    //read the tree from STDIN and return its root as a return value of this function
    Scanner scanner = new Scanner(System.in);
//    int n = scanner.nextInt();
//    values = new int[n + 1];
//    colours = new Color[n + 1];
//    for (int i = 1; i <= n; i++) {
//      values[i] = scanner.nextInt();
//    }
//    for (int i = 1; i <= n; i++) {
//      colours[i] = scanner.nextInt() == 1 ? Color.GREEN : Color.RED;
//    }

    ////////
    // TESTING VALUES
    int n = 5;
    values = new int[]{-1, 4, 7, 2, 5, 12};
    colours = new Color[]{null, Color.RED, Color.GREEN, Color.RED, Color.RED, Color.GREEN};
    int[][] edges = {{1, 2}, {1, 3}, {3, 4}, {3, 5}};
    ////////

    // build edges mapping
    map = new HashMap<>();
    for (int i = 0; i < n - 1; i++) {
//      int u = scanner.nextInt();
//      int v = scanner.nextInt();
      int u = edges[i][0];
      int v = edges[i][1];

      Set<Integer> uNeighbours = map.get(u);
      if (uNeighbours == null) {
        uNeighbours = new HashSet<>();
        map.put(u, uNeighbours);
      }
      uNeighbours.add(v);

      Set<Integer> vNeighbours = map.get(v);
      if (vNeighbours == null) {
        vNeighbours = new HashSet<>();
        map.put(v, vNeighbours);
      }
      vNeighbours.add(u);
    }

    scanner.close();

    // create tree
    if (n == 1) {
      return new TreeLeaf(values[1], colours[1], 0);
    }

    TreeNode root = new TreeNode(values[1], colours[1], 0);
    buildTree(root, 1);
    return root;
  }

  private static void buildTree(TreeNode parent, Integer parentNum) {
    for (Integer treeNum: map.get(parentNum)) {
      map.get(treeNum).remove(parentNum);

      Set<Integer> grandchildren = map.get(treeNum);
      boolean hasGrandchildren = grandchildren != null && !grandchildren.isEmpty();
      Tree tree;
      if (hasGrandchildren) {
        tree = new TreeNode(values[treeNum], colours[treeNum], parent.getDepth() + 1);
      } else {
        tree = new TreeLeaf(values[treeNum], colours[treeNum], parent.getDepth() + 1);
      }

      if (tree instanceof TreeNode) {
        buildTree((TreeNode) tree, treeNum);
      }

      parent.addChild(tree);
    }
  }
}

enum Color {
  RED, GREEN
}

abstract class Tree {
  private int value;
  private Color color;
  private int depth;

  Tree(int value, Color color, int depth) {
    this.value = value;
    this.color = color;
    this.depth = depth;
  }

  int getValue() {
    return value;
  }

  Color getColor() {
    return color;
  }

  int getDepth() {
    return depth;
  }

  public abstract void accept(TreeVisitor visitor);
}

class TreeNode extends Tree {
  private ArrayList<Tree> children = new ArrayList<>();

  TreeNode(int value, Color color, int depth) {
    super(value, color, depth);
  }

  @Override
  public void accept(TreeVisitor visitor) {
    visitor.visitNode(this);

    for (Tree child : children) {
      child.accept(visitor);
    }
  }

  void addChild(Tree child) {
    children.add(child);
  }
}

class TreeLeaf extends Tree {
  TreeLeaf(int value, Color color, int depth) {
    super(value, color, depth);
  }

  @Override
  public void accept(TreeVisitor visitor) {
    visitor.visitLeaf(this);
  }
}

interface TreeVisitor {
  int getResult();
  void visitNode(TreeNode node);
  void visitLeaf(TreeLeaf leaf);
}

class SumInLeavesVisitor implements TreeVisitor {
  private int result = 0;

  @Override
  public int getResult() {
    return result;
  }

  @Override
  public void visitNode(TreeNode node) {
    // do nothing
  }

  @Override
  public void visitLeaf(TreeLeaf leaf) {
    result += leaf.getValue();
  }
}

class ProductOfRedNodesVisitor implements TreeVisitor {
  private long result = 1;
  private final int mod = 1000000007;

  @Override
  public int getResult() {
    return (int) result;
  }

  @Override
  public void visitNode(TreeNode node) {
    if (node.getColor() == Color.RED) {
      result = (result * node.getValue()) % mod;
    }
  }

  @Override
  public void visitLeaf(TreeLeaf leaf) {
    if (leaf.getColor() == Color.RED) {
      result = (result * leaf.getValue()) % mod;
    }
  }
}

class FancyVisitor implements TreeVisitor {
  private int nonLeaf = 0;
  private int greenLeaf = 0;

  @Override
  public int getResult() {
    return Math.abs(nonLeaf - greenLeaf);
  }

  @Override
  public void visitNode(TreeNode node) {
    if (node.getDepth() % 2 == 0) {
      nonLeaf += node.getValue();
    }
  }

  @Override
  public void visitLeaf(TreeLeaf leaf) {
    if (leaf.getColor() == Color.GREEN) {
      greenLeaf += leaf.getValue();
    }
  }
}
