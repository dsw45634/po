package pl.dsw45634.po.ex_2.transport;

import java.util.ArrayList;
import java.util.List;
import pl.dsw45634.po.ex_2.Container;
import pl.dsw45634.po.ex_2.warehouse.Warehouse;

/**
Transport (klasa abstrakcyjna) wspólna dla wszystkich form transportu, zawiera metody:
    – przetransportuj(z, do) - transportuje towar z miejsca A do miejsca B (wyświetla
    odpowiedni komunikat o dokonaniu transportu, dodatkowo podczas wywołania tej metody
    powinien wyświetlić się komunikat o formie transportu np. przetransportowano
    statkiem (funkcjonalność tę należy raczej zaimplementować w klasach potomnych)
    – metoda załaduj(...) umożliwia załadowanie towaru.
 */
public abstract class Transport {

  public static int transportCounter;

  protected final TypeOfTransport typeOfTransport;
  protected final Container[] containers;
  protected Warehouse location;

  protected Transport(TypeOfTransport typeOfTransport) {
    this.typeOfTransport = typeOfTransport;
    this.containers = new Container[typeOfTransport.amountOfContainers];
  }

  public TypeOfTransport getTypeOfTransport() {
    return typeOfTransport;
  }

  public Warehouse getLocation() {
    return location;
  }

  public void setLocation(Warehouse location) {
    this.location = location;
  }

  public static Transport create(String transport) {
    TypeOfTransport typeOfTransport = TypeOfTransport.valueOf(transport);
    switch (typeOfTransport) {
      case SHIP: return new Ship(typeOfTransport);
      case TRAIN: return new Train(typeOfTransport);
      case TRUCK: return new Truck(typeOfTransport);
      default: throw new IllegalArgumentException();
    }
  }

  public void transportFromTo(Warehouse from, Warehouse to) {
    transport(from, to);
    from.setDockedTransport(null);
    to.setDockedTransport(this);
    this.location = to;
    transportCounter++;
  }

  public void loadContainers(List<Container> containers) {
    load(containers.size());
    for (int i = 0; i < containers.size(); i++) {
      this.containers[i] = containers.get(i);
    }
  }

  public List<Container> unloadContainers() {
    List<Container> containers = new ArrayList<>();
    for (int i = 0; i < this.containers.length; i++) {
      if (this.containers[i] != null) {
        Container container = this.containers[i];
        this.containers[i] = null;
        containers.add(container);
      } else {
        unload(containers.size());
        return containers;
      }
    }
    unload(containers.size());
    return containers;
  }

  protected abstract void transport(Warehouse from, Warehouse to);
  protected abstract void load(int numOfContainers);
  protected abstract void unload(int numOfContainers);

  public enum TypeOfTransport {

    SHIP(90), TRAIN(20), TRUCK(1);

    public int amountOfContainers;

    TypeOfTransport(int amountOfContainers) {
      this.amountOfContainers = amountOfContainers;
    }
  }
}
