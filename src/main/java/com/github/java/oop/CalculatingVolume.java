package com.github.java.oop;

import java.io.*;
import java.util.*;
import java.security.Permission;

public class CalculatingVolume {

  public static void main(String[] args) {
    DoNotTerminate.forbidExit();
    try {
      Calculate cal = new Calculate();
      int T = cal.get_int_val();
      while (T-- > 0) {
        double volume = 0.0;
        int ch = cal.get_int_val();
        if (ch == 1) {
          int a = cal.get_int_val();
          volume = Calculate.do_calc().get_volume(a);
        } else if (ch == 2) {
          int l = cal.get_int_val();
          int b = cal.get_int_val();
          int h = cal.get_int_val();
          volume = Calculate.do_calc().get_volume(l, b, h);

        } else if (ch == 3) {
          double r = cal.get_double_val();
          volume = Calculate.do_calc().get_volume(r);

        } else if (ch == 4) {
          double r = cal.get_double_val();
          double h = cal.get_double_val();
          volume = Calculate.do_calc().get_volume(r, h);
        }
        cal.output.display(volume);
      }

    } catch (NumberFormatException e) {
      System.out.print(e);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (DoNotTerminate.ExitTrappedException e) {
      System.out.println("Unsuccessful Termination!!");
    }
  } //end of main
} //end of Solution


class Calculate {

  private Scanner scanner;
  Output output;

  Calculate() {
    scanner = new Scanner(System.in);
    output = new Output();
  }

  static Shape do_calc() {
    return new Shape();
  }

  int get_int_val() throws IOException {
    return scanner.nextInt();
  }

  double get_double_val() throws IOException {
    return scanner.nextDouble();
  }
}

class Shape {

  /**
   * Cube
   */
  double get_volume(int a) {
    checkPositive(a);
    return Math.pow(a, 3);
  }

  /**
   * Cuboid
   */
  double get_volume(int l, int b, int h) {
    checkPositive(l, b, h);
    return l * b * h;
  }

  /**
   * Hemisphere
   */
  double get_volume(double r) {
    checkPositive(r);
    return (2. / 3.) * Math.PI * Math.pow(r, 3);
  }

  /**
   * Cylinder
   */
  double get_volume(double r, double h) {
    checkPositive(r, h);
    return Math.PI * Math.pow(r, 2) * h;
  }

  private void checkPositive(int... ints) {
    for (int n : ints) {
      if (n <= 0) {
        throw new NumberFormatException("All the values must be positive");
      }
    }
  }

  private void checkPositive(double... doubles) {
    for (double n : doubles) {
      if (n <= 0) {
        throw new NumberFormatException("All the values must be positive");
      }
    }
  }
}

class Output {
  void display(double d) {
    System.out.println(String.format("%.3f", d));
  }
}

/**
 * This class prevents the user form using System.exit(0) from terminating the program abnormally.
 */
class DoNotTerminate {

  public static class ExitTrappedException extends SecurityException {
  }

  public static void forbidExit() {
    final SecurityManager securityManager = new SecurityManager() {
      @Override
      public void checkPermission(Permission permission) {
        if (permission.getName().contains("exitVM")) {
          throw new ExitTrappedException();
        }
      }
    };
    System.setSecurityManager(securityManager);
  }
} //end of Do_Not_Terminate
