package pl.dsw45634.po.ex_9;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class University implements Serializable {

  private List<Student> students;

  public University() {
    this.students = new ArrayList<>();
  }

  public List<Student> getStudents() {
    return students;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }

  public void addStudent(Student student) {
    students.add(student);
  }

  public List<Student> getStudent(String name, String surname) {
    return this.students.stream()
        .filter(student -> student.getName().equals(name) && student.getSurname().equals(surname))
        .collect(Collectors.toList());
  }

  // first only?
  public boolean removeStudent(String name, String surname) {
    return this.students.remove(new Student(name, surname));
  }

}
