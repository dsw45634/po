package pl.dsw45634.po.ex_9;

import java.util.Scanner;

abstract class UniversitySerialization {

  abstract University readUniversity();
  abstract void writeUniversity(University university);

  public static University read() {
    String ans = readAns("wczytaj");
    switch (ans) {
      case "x":
        return XMLUniversitySerialization.getInstance().readUniversity();
      case "b":
        return BinUniversitySerialization.getInstance().readUniversity();
      default:
        throw new IllegalArgumentException();
    }
  }

  public static void write(University university) {
    String ans = readAns("Zapisz");
    switch (ans) {
      case "x":
        XMLUniversitySerialization.getInstance().writeUniversity(university);
        break;
      case "b":
        BinUniversitySerialization.getInstance().writeUniversity(university);
        break;
      default:
        throw new IllegalArgumentException();
    }
  }

  private static String readAns(String op) {
    System.out.printf("%s uniwersytet:\n", op);
    System.out.println("X - plik XML");
    System.out.println("B - plik bin");
    return new Scanner(System.in).nextLine().toLowerCase();
  }
}
