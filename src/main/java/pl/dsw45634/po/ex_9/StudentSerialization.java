package pl.dsw45634.po.ex_9;

import java.util.Scanner;

abstract class StudentSerialization {

  abstract Student readStudent(String name, String surname);
  abstract void writeStudent(Student student);

  public static Student read(String name, String surname) {
    String ans = readAns("Wczytaj");
    switch (ans) {
      case "x":
        return XMLStudentSerialization.getInstance().readStudent(name, surname);
      case "b":
        return BinStudentSerialization.getInstance().readStudent(name, surname);
      default:
        throw new IllegalArgumentException();
    }
  }

  public static void write(Student student) {
    String ans = readAns("Zapisz");
    switch (ans) {
      case "x":
        XMLStudentSerialization.getInstance().writeStudent(student);
        break;
      case "b":
        BinStudentSerialization.getInstance().writeStudent(student);
        break;
      default:
        throw new IllegalArgumentException();
    }
  }

  private static String readAns(String op) {
    System.out.printf("%s studenta:\n", op);
    System.out.println("X - plik XML");
    System.out.println("B - plik bin");
    return new Scanner(System.in).nextLine().toLowerCase();
  }
}
