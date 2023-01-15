package pl.dsw45634.po.ex_9;

import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

class Starost extends Student {

  private String groupName;

  public Starost(String name, String surname) {
    super(name, surname);
  }

  public void postponeColloquium(LocalDate date) { }

  private void writeObject(ObjectOutputStream stream) throws NotSerializableException {
    throw new NotSerializableException();
  }

  private void readObject(ObjectInputStream stream) throws NotSerializableException {
    throw new NotSerializableException();
  }
}
