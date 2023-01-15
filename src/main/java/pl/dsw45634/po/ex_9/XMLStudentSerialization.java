package pl.dsw45634.po.ex_9;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

class XMLStudentSerialization extends StudentSerialization {

  private static final XMLStudentSerialization XML_STUDENT_SERIALIZATION = new XMLStudentSerialization();

  private XMLStudentSerialization() { }

  public static XMLStudentSerialization getInstance() {
    return XML_STUDENT_SERIALIZATION;
  }

  @Override
  public Student readStudent(String name, String surname) {
    String fileName = String.format("student_%s_%s.xml", surname, name);
    try (XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(fileName)))) {
      return (Student) xmlDecoder.readObject();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public void writeStudent(Student student) {
    String fileName = String.format("student_%s_%s.xml", student.getSurname(), student.getName());
    try (XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)))) {
      xmlEncoder.writeObject(student);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
