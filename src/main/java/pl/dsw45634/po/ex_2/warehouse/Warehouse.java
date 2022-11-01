package pl.dsw45634.po.ex_2.warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import pl.dsw45634.po.ex_2.Container;
import pl.dsw45634.po.ex_2.commodity.Commodity;
import pl.dsw45634.po.ex_2.commodity.CommodityTypes;
import pl.dsw45634.po.ex_2.transport.Transport;
import pl.dsw45634.po.ex_2.transport.Transport.TypeOfTransport;

public class Warehouse {

  private final String city;
  private final Map<CommodityTypes, List<Commodity>> warehouse = new HashMap<>();
  private final List<Container> containersWarehouse;
  private final List<Transport> transportsWarehouse;
  private Transport dockedTransport;

  private Warehouse(String city) {
    this.city = city;
    this.containersWarehouse = new ArrayList<>();
    this.transportsWarehouse = new ArrayList<>();
  }

  private Warehouse(String city, List<Container> containersWarehouse, List<Transport> transportsWarehouse) {
    this.city = city;
    this.containersWarehouse = containersWarehouse;
    this.transportsWarehouse = transportsWarehouse;
  }

  static Warehouse init(String name) {
    switch (name) {
      case "Gdańsk": return warehouseWithAllResources(name);
      case "New York": return warehouseContractor(name);
      default: return emptyWarehouse(name);
    }
  }

  public String getCity() {
    return city;
  }

  public List<Container> getContainersWarehouse() {
    return containersWarehouse;
  }

  public void setDockedTransport(Transport transport) {
    this.dockedTransport = transport;
  }

  public void dockTransport(String transportName) {
    TypeOfTransport typeOfTransport = TypeOfTransport.valueOf(transportName.toUpperCase());
    Optional<Transport> transportOptional = transportsWarehouse.stream()
        .filter(t -> t.getTypeOfTransport().equals(typeOfTransport))
        .findFirst();
    if (transportOptional.isPresent()) {
      Transport transport = transportOptional.get();
      this.transportsWarehouse.remove(transport);
      this.dockedTransport = transport;
      System.out.printf("%s %s gotowy do załadowania kontenerów.\n", this.city, transport.getTypeOfTransport().name());
    } else {
      // to niech przyjedzie...
      System.out.printf("W %s nie ma %s\n", this.city, transportName);
      double random = Math.random();
      int randomTransport = (int) (random * CompanyResources.DSW_TRANSPORTS.size() + 1);
      Transport transport = CompanyResources.DSW_TRANSPORTS.get(transportName).get(randomTransport);
      transport.transportFromTo(transport.getLocation(), this);
    }
  }

  public void loadContainers() {
    this.dockedTransport.loadContainers(this.getContainers(this.dockedTransport.getTypeOfTransport().amountOfContainers));
  }

  public void loadContainers(CommodityTypes cT) {
    this.dockedTransport.loadContainers(this.getContainers(this.dockedTransport.getTypeOfTransport().amountOfContainers, cT));
  }

  private List<Container> getContainers(int limit, CommodityTypes cT) {
    List<Container> containers = this.containersWarehouse.stream()
        .filter(container -> container.getCommodityType().equals(cT))
        .limit(limit)
        .collect(Collectors.toList());
    removeContainers(containers);
    System.out.printf("%s Wydano %d kontenerów.\n", this.city, containers.size());
    return containers;
  }

  private List<Container> getContainers(int i) {
    List<Container> containers = this.containersWarehouse.stream()
        .limit(i)
        .collect(Collectors.toList());

    removeContainers(containers);
    System.out.printf("%s Wydano %d kontenerów.\n", this.city, containers.size());
    return containers;
  }

  private void removeContainers(List<Container> containers) {
    for (Container container : containers) {
      this.containersWarehouse.remove(container);
    }
  }

  public void unloadContainers() {
    List<Container> unloaded = this.dockedTransport.unloadContainers();
    System.out.printf("%s rozładowano %d kontenerów z %s\n", this.city, unloaded.size(), this.dockedTransport.getTypeOfTransport());
    this.containersWarehouse.addAll(unloaded);
    this.transportsWarehouse.add(this.dockedTransport);
    this.dockedTransport = null;
  }

  public void sendTransport(Warehouse warehouse) {
    this.dockedTransport.transportFromTo(this, warehouse);
  }

  private static Warehouse emptyWarehouse(String name) {
    return new Warehouse(name);
  }

  private static Warehouse warehouseContractor(String name) {
    Warehouse warehouse = new Warehouse(name);
    warehouse.store(CommodityTypes.CELLPHONE, 500_000);
    warehouse.store(CommodityTypes.CLOTHES, 500_000);
    warehouse.store(CommodityTypes.ELECTRONIC, 500_000);
    warehouse.store(CommodityTypes.SHOES, 500_000);
    return warehouse;
  }

  private static Warehouse warehouseWithAllResources(String name) {
    List<Transport> transports = new ArrayList<>();
    for (Entry<String, List<Transport>> entrySet : CompanyResources.DSW_TRANSPORTS.entrySet()) {
      transports.addAll(entrySet.getValue());
    }
    Warehouse warehouse = new Warehouse(name, CompanyResources.DSW_CONTAINERS, transports);
    for (Transport transport : warehouse.transportsWarehouse) {
      transport.setLocation(warehouse);
    }
    return warehouse;
  }

  private void store(CommodityTypes commodityType, int i) {
    List<Commodity> commodities = new ArrayList<>();
    while (commodities.size() < i) {
      commodities.add(Commodity.of(commodityType));
    }
    this.warehouse.put(commodityType, commodities);
    System.out.printf("%s zmagazynowano %d %s.\n",  this.city, i, commodityType);
  }

  public void pack(CommodityTypes cT, int numOfContainers) {
    for (int i = 0; i < this.containersWarehouse.size() && this.warehouse.get(cT).size() > 0 && numOfContainers > 0; i++) {
      Container container = this.containersWarehouse.get(i);
      if (container.isEmpty()) {
        packContainerBy(container, cT);
        numOfContainers--;
      }
    }
  }

  public void pack(CommodityTypes cT) {
    for (int i = 0; i < this.containersWarehouse.size() && this.warehouse.get(cT).size() > 0; i++) {
      Container container = this.containersWarehouse.get(i);
      if (container.isEmpty()) {
        packContainerBy(container, cT);
      }
    }
  }

  private void packContainerBy(Container container, CommodityTypes cT) {
    List<Commodity> commodities = this.warehouse.get(cT);
    List<Commodity> commodityToLoad = new ArrayList<>();
    container.prepareContainer(cT);
    int num = Container.countCommoditiesAmount(cT);
    while (commodities.size() > 0 && commodityToLoad.size() < num) {
      Commodity commodity = commodities.get(commodities.size() - 1);
      commodities.remove(commodity);
      commodityToLoad.add(commodity);
    }
    container.loadContainer(commodityToLoad);
    System.out.printf("Kontener załadowany: %s: %d szt.\n", cT, commodityToLoad.size());
    System.out.println(this);
  }

  public void storeContainers() {
    for (Container container : this.containersWarehouse) {
      if (container.isEmpty()) {
        continue;
      }
      CommodityTypes commodityType = container.getCommodityType();
      List<Commodity> unloaded = container.unload();
      if (this.warehouse.get(commodityType) == null) {
        this.warehouse.put(commodityType, unloaded);
      } else {
        this.warehouse.get(commodityType).addAll(unloaded);
      }
      System.out.println("Rozładowano kontener, stan magazynu:");
      System.out.println(this);
    }
  }

  @Override
  public String toString() {
    StringBuilder sB = new StringBuilder();
    sB.append(String.format("%s:\n", this.city));
    for (Entry<CommodityTypes, List<Commodity>> next : this.warehouse.entrySet()) {
      sB.append(String.format("%s = %d\n", next.getKey(), next.getValue().size()));
    }
    return sB.toString();
  }
}
