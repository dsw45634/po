package pl.dsw45634.po.ex_9;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

class XMLUniversitySerialization extends UniversitySerialization {

  private static final XMLUniversitySerialization XML_UNIVERSITY_SERIALIZATION = new XMLUniversitySerialization();

  private XMLUniversitySerialization() { }

  public static UniversitySerialization getInstance() {
    return XML_UNIVERSITY_SERIALIZATION;
  }

  @Override
  University readUniversity() {
    University university = new University();
    try (XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("university.xml")))) {
      university = (University) xmlDecoder.readObject();
    } catch (FileNotFoundException ignored) { }
    return university;
  }

  @Override
  void writeUniversity(University university) {
    try (XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("university.xml")))) {
      xmlEncoder.writeObject(university);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
