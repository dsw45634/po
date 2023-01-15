package pl.dsw45634.po.ex_9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class BinStudentSerialization extends StudentSerialization {

  private static final BinStudentSerialization BIN_STUDENT_SERIALIZATION = new BinStudentSerialization();

  private BinStudentSerialization() { }

  public static BinStudentSerialization getInstance() {
    return BIN_STUDENT_SERIALIZATION;
  }

  @Override
  public Student readStudent(String name, String surname) {
    String fileName = String.format("student_%s_%s.bin", surname, name);
    try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(fileName))) {
      return (Student) stream.readObject();
    } catch (IOException | ClassNotFoundException ioException) {
      ioException.printStackTrace();
      return null;
    }
  }

  @Override
  public void writeStudent(Student student) {
    String fileName = String.format("student_%s_%s.bin", student.getSurname(), student.getName());
    try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fileName))) {
      stream.writeObject(student);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
