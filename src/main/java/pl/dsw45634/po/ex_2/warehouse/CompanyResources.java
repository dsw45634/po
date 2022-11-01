package pl.dsw45634.po.ex_2.warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import pl.dsw45634.po.ex_2.Container;
import pl.dsw45634.po.ex_2.transport.Transport;

class CompanyResources {

  public static final Map<String, List<Transport>> DSW_TRANSPORTS = new HashMap<>();
  public static final List<Container> DSW_CONTAINERS = new ArrayList<>();

  private CompanyResources() {}

  static {
    addTransport("ship", 1);
    addTransport("train", 2);
    addTransport("truck", 10);
    addContainers(40);
  }

  private static void addContainers(int i) {
    while (DSW_CONTAINERS.size() < i) {
      DSW_CONTAINERS.add(new Container());
    }
  }

  private static void addTransport(String transport, int i) {
    List<Transport> t = new ArrayList<>();
    while (t.size() < i) {
      t.add(Transport.create(transport.toUpperCase(Locale.ROOT)));
    }
    DSW_TRANSPORTS.put(transport, t);
  }
}
