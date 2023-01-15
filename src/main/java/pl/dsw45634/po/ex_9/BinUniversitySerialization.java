package pl.dsw45634.po.ex_9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class BinUniversitySerialization extends UniversitySerialization {

  private static final BinUniversitySerialization BIN_UNIVERSITY_SERIALIZATION = new BinUniversitySerialization();

  private BinUniversitySerialization() { }

  public static BinUniversitySerialization getInstance() {
    return BIN_UNIVERSITY_SERIALIZATION;
  }

  @Override
  public University readUniversity() {
    University university = new University();
    try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream("university.bin"))) {
      university = (University) stream.readObject();
    } catch (IOException | ClassNotFoundException ignored) { }
    return university;
  }

  @Override
  public void writeUniversity(University university) {
    try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("university.bin"))) {
      stream.writeObject(university);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
