package pl.dsw45634.po.ex_2.transport;

import pl.dsw45634.po.ex_2.warehouse.Warehouse;

/**
 * Statek, Pociąg, Ciężarówka – klasy dziedziczące po klasie Transport rozszerzającej jej
 * metody oraz implementujące metody charakterystyczne dla danego środka transportu. Zdefiniuj
 * pojemność każdego ze środka transportu: statek – 90 kontenerów, pociąg 20 kontenerów,
 * ciężarówka 1 kontener
 */

class Ship extends Transport {

  protected Ship(TypeOfTransport typeOfTransport) {
    super(typeOfTransport);
  }

  @Override
  protected void transport(Warehouse from, Warehouse to) {
    System.out.printf("%s wypływa z %s do %s\n", this.typeOfTransport, from.getCity(), to.getCity());
  }

  @Override
  protected void load(int numOfContainers) {
    System.out.printf("Załadowano %d kontenerów na %s\n", numOfContainers, this.typeOfTransport.name());
  }

  @Override
  protected void unload(int numOfContainers) {
    System.out.printf("Rozładowano %d kontenerów z %s\n", numOfContainers, this.typeOfTransport);
  }

}
