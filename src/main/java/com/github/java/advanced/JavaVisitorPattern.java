//package test.java.com.github.java.advanced;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class JavaVisitorPattern {
//
//  //private static int[] values;
//
//  public static Tree solve() {
//    //read the tree from STDIN and return its root as a return value of this function
//    Scanner scanner = new Scanner(System.in);
////    int n = scanner.nextInt();
////    int[] values = new int[n];
////    Color[] colours = new Color[n];
////    for (int i = 0; i < n; i++) {
////      values[i] = scanner.nextInt();
////    }
////    for (int i = 0; i < n; i++) {
////      colours[i] = scanner.nextInt() == 1 ? Color.GREEN : Color.RED;
////    }
//
//    ////////
//    // TESTING VALUES
//    int n = 5;
//    int[] values = {4, 7, 2, 5, 12};
//    Color[] colours = {Color.RED, Color.GREEN, Color.RED, Color.RED, Color.GREEN};
//    ////////
//
//    // create all the nodes
//    Tree[] trees = new Tree[n];
//    Tree root = new TreeNode(values[0], colours[0], 0);
//    trees[0] = root;
//    for (int i  = 1; i < n; i++) {
//      int value = values[i];
//      Color colour = colours[i];
//      trees[i] = new TreeLeaf(value, colour, -1);
//    }
//
//    // link all the nodes
//    while (scanner.hasNextInt()) {
//      int nParent, nChild;
//      Tree parent1, child;
//      TreeNode parent2;
//
//      nParent = scanner.nextInt();
//      nChild = scanner.nextInt();
//
//      child = trees[nChild];
//      parent1 = trees[nParent];
//      if (parent1 instanceof TreeLeaf) {
//        parent2 = new TreeNode(
//            trees[nParent].getValue(),
//            trees[nParent].getColor(),
//            trees[nParent].getDepth()
//        );
//      } else if (parent1 instanceof TreeNode) {
//        parent2 = parent1;
//      }
//
//      parent2.addChild(child);
//    }
//
//    return root;
//  }
//
//  public static void main(String[] args) {
//    Tree root = solve();
//    SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
//    ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
//    FancyVisitor vis3 = new FancyVisitor();
//
//    root.accept(vis1);
//    root.accept(vis2);
//    root.accept(vis3);
//
//    int res1 = vis1.getResult();
//    int res2 = vis2.getResult();
//    int res3 = vis3.getResult();
//
//    System.out.println(res1);
//    System.out.println(res2);
//    System.out.println(res3);
//  }
//
//}
//
//enum Color {
//  RED, GREEN
//}
//
//abstract class Tree {
//
//  private int value;
//  private Color color;
//  private int depth;
//
//  public Tree(int value, Color color, int depth) {
//    this.value = value;
//    this.color = color;
//    this.depth = depth;
//  }
//
//  public int getValue() {
//    return value;
//  }
//
//  public Color getColor() {
//    return color;
//  }
//
//  public int getDepth() {
//    return depth;
//  }
//
//  public abstract void accept(TreeVis visitor);
//}
//
//class TreeNode extends Tree {
//
//  private ArrayList<Tree> children = new ArrayList<>();
//
//  public TreeNode(int value, Color color, int depth) {
//    super(value, color, depth);
//  }
//
//  public void accept(TreeVis visitor) {
//    visitor.visitNode(this);
//
//    for (Tree child : children) {
//      child.accept(visitor);
//    }
//  }
//
//  public void addChild(Tree child) {
//    children.add(child);
//  }
//}
//
//class TreeLeaf extends Tree {
//
//  public TreeLeaf(int value, Color color, int depth) {
//    super(value, color, depth);
//  }
//
//  public void accept(TreeVis visitor) {
//    visitor.visitLeaf(this);
//  }
//}
//
//abstract class TreeVis {
//  public abstract int getResult();
//
//  public abstract void visitNode(TreeNode node);
//
//  public abstract void visitLeaf(TreeLeaf leaf);
//
//}
//
//class SumInLeavesVisitor extends TreeVis {
//  public int getResult() {
//    //implement this
//    return 0;
//  }
//
//  public void visitNode(TreeNode node) {
//    //implement this
//  }
//
//  public void visitLeaf(TreeLeaf leaf) {
//    //implement this
//  }
//}
//
//class ProductOfRedNodesVisitor extends TreeVis {
//  public int getResult() {
//    //implement this
//    return 1;
//  }
//
//  public void visitNode(TreeNode node) {
//    //implement this
//  }
//
//  public void visitLeaf(TreeLeaf leaf) {
//    //implement this
//  }
//}
//
//class FancyVisitor extends TreeVis {
//  public int getResult() {
//    //implement this
//    return 0;
//  }
//
//  public void visitNode(TreeNode node) {
//    //implement this
//  }
//
//  public void visitLeaf(TreeLeaf leaf) {
//    //implement this
//  }
//}
