package com.github.java.datastructures;

public class Java2DArray {

  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    int arr[][] = new int[6][6];
//    for (int i = 0; i < 6; i++) {
//      for (int j = 0; j < 6; j++) {
//        arr[i][j] = scanner.nextInt();
//      }
//    }

//    int arr[][] = {
//        {1, 1, 1, 0, 0, 0},
//        {0, 1, 0, 0, 0, 0},
//        {1, 1, 1, 0, 0, 0},
//        {0, 0, 2, 4, 4, 0},
//        {0, 0, 0, 2, 0, 0},
//        {0, 0, 1, 2, 4, 0},
//    };

    int arr[][] = {
        {-1, -1,  0, -9, -2, -2},
        {-2, -1, -6, -8, -2, -5},
        {-1, -1, -1, -2, -3, -4},
        {-1, -9, -2, -4, -4, -5},
        {-7, -3, -3, -2, -9, -9},
        {-1, -3, -1, -2, -4, -5},
    };

    int max = Integer.MIN_VALUE;
    for (int x = 0; x < 6; x++) {
      for (int y = 0; y < 6; y++) {
        int val = value(arr, x, y);
        if (val > max) {
          max = val;
        }
      }
    }
    System.out.println(max);

  }

  private static int value(int[][] arr, int x, int y) {
    // don't go off the edges
    if (x == 0 || x == 5 || y == 0 || y == 5) {
      return Integer.MIN_VALUE;
    }

    int tl, tm, tr, m, bl, bm, br;
    tl = arr[x+1][y-1];
    tm = arr[x+1][y];
    tr = arr[x+1][y+1];
    m = arr[x][y];
    bl = arr[x-1][y-1];
    bm = arr[x-1][y];
    br = arr[x-1][y+1];

    int value = tl + tm + tr + m + bl + bm + br;
    return value;

//    return arr[x+1][y-1] + arr[x+1][y] + arr[x+1][y+1] +
//        arr[x][y] +
//        arr[x-1][y-1] + arr[x-1][y] + arr[x-1][y+1];
  }
}
