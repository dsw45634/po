package pl.dsw45634.po.ex_9;

import java.io.Serializable;
import java.time.LocalDate;

public class Student implements Serializable {

  private String name;
  private String surname;
  private LocalDate birthDate;
  private int sciencePoints;
  private int lifePoints;

  public Student() {
  }

  public Student(String name, String surname) {
    this.name = name;
    this.surname = surname;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public int getSciencePoints() {
    return sciencePoints;
  }

  public void setSciencePoints(int sciencePoints) {
    this.sciencePoints = sciencePoints;
  }

  public int getLifePoints() {
    return lifePoints;
  }

  public void setLifePoints(int lifePoints) {
    this.lifePoints = lifePoints;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", birthDate=" + birthDate +
        ", sciencePoints=" + sciencePoints +
        ", lifePoints=" + lifePoints +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Student)) {
      return false;
    }
    Student student = (Student) o;
    return this.surname.equals(student.surname) && this.name.equals(student.name);
  }

  public void learn(LocalDate from, LocalDate to) { }

  public void party(LocalDate from, LocalDate to) { }

  public boolean isGoodStudent() {
    return false;
  }
}
