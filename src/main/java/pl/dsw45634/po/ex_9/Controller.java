package pl.dsw45634.po.ex_9;

import java.util.List;
import java.util.Scanner;

class Controller {

  private University university;

  public void run() {
    this.university = UniversitySerialization.read();
    String option = "";
    while (!option.equals("c")) {
      System.out.println("Wybierz:");
      System.out.println("a - dodaj studenta");
      System.out.println("f - znajdź studenta");
      System.out.println("r - usuń studenta");
      System.out.println("s - zapisz zmiany w uniwersytecie");
      System.out.println("l - znajdź studenta w osobnym spisie");
      System.out.println("c - zamknij program");
      option = new Scanner(System.in).nextLine().toLowerCase();
      switch (option) {
        case "a":
          Student student = createStudent();
          saveStudent(student);
          university.addStudent(student);
          break;
        case "f":
          findStudent();
          break;
        case "r":
          removeStudent();
          break;
        case "s":
          UniversitySerialization.write(this.university);
          break;
        case "l":
          findInStudentsSet();
          break;
        case "c":
          System.out.println("Zamykanie programu");
          break;
        default:
          System.out.println("Niepoprawna operacja: " + option);
      }
    }
  }

  private void findInStudentsSet() {
    Student studentInStudents = findStudentInStudents();
    if (studentInStudents != null) {
      System.out.println(studentInStudents);
    } else {
      System.err.println("Nie znaleziono");
    }
  }

  private Student findStudentInStudents() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj imię:");
    String name = scanner.nextLine();
    System.out.println("Podaj nazwisko:");
    String surname = scanner.nextLine();

    return StudentSerialization.read(name, surname);
  }

  private void removeStudent() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj imię:");
    String name = scanner.nextLine();
    System.out.println("Podaj nazwisko:");
    String surname = scanner.nextLine();

    boolean isRemoved = this.university.removeStudent(name, surname);

    String message = isRemoved ? "Usunięto: " + name + " " + surname : "Nie znaleziono: " + name + " " + surname;
    System.out.println(message);
  }

  private void findStudent() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj imię:");
    String name = scanner.nextLine();
    System.out.println("Podaj nazwisko:");
    String surname = scanner.nextLine();

    List<Student> students = this.university.getStudent(name, surname);

    students.forEach(System.out::println);
  }

  private Student createStudent() {
    Scanner scanner = new Scanner(System.in);
    String name = "";
    String surname = "";
    while (name.equals("") || surname.equals("")) {
      System.out.println("Podaj imię:");
      name = scanner.nextLine();
      System.out.println("Podaj nazwisko:");
      surname = scanner.nextLine();
    }
    return new Student(name, surname);
  }

  private void saveStudent(Student student) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Zapisać studenta w osobnym spisie? t/n");
    String ans = scanner.nextLine();
    if (ans.equalsIgnoreCase("t")) {
      StudentSerialization.write(student);
      System.out.println("Zapisano studenta:");
      System.out.println(student);
    }
  }

}
