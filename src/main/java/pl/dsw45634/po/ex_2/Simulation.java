package pl.dsw45634.po.ex_2;

import pl.dsw45634.po.ex_2.commodity.CommodityTypes;
import pl.dsw45634.po.ex_2.transport.Transport;
import pl.dsw45634.po.ex_2.warehouse.Warehouse;
import pl.dsw45634.po.ex_2.warehouse.Warehouses;

/**
 * 1. Dodaj produkty: części elektroniczne, telefony komórkowe, buty, odzież
 * 2. Dodaj do zasobów firmy 40 kontenerów
 * 3. Dodaj do zasobów firmy: 1 statek, 2 pociągi, 10 ciężarówek. Wykorzystaj do tego celu mapę
 * (HashMap), której kluczami są nazwy środków transportu, a wartości to listy zawierające
 * konkretne obiekty
 * 4. Zdefiniuj magazyny firmy: Gdańsk, Wrocław, Kraków, Poznań
 * 5. Załaduj do kontenerów:
 * • 10 kontenerów z częściami elektronicznymi
 * • 20 kontenerów z telefonami
 * • po 5 kontenerów z butami i odzieżą
 * 6. Załaduj wszystkie kontenery na statek płynący z Nowego Jorku do Gdańska
 * 7. Rozładuj statek
 * 8. Załaduj kontenery na pociągi, które jadą do Wrocławia. W miarę przybywania pociągów do
 * Wrocławia rozładowuj je oraz wyświetlaj stan magazynu
 * 9. Przetransportuj wszystkie buty i odzież do Poznania ciężarówkami (pamiętaj o rozładowaniu
 * do magazynu)
 * 10. Przetransportuj wszystkie elementy elektronicznie ciężarówkami do Krakowa
 * 11. Podaj ile łącznie kursów wykonały wszystkie środki transportu posiadane przez firmę (wykorzystaj
 * do tego celu statyczne pole klasy)
 * Uwaga: na początku symulacji wszystkie środki transportu znajdują się w magazynie w Gdańsku.
 * Możliwa jest sytuacja, w której konieczny jest przejazd "na pusto"to znaczy bez załadowanego
 * towaru (pamiętaj, o ograniczeniach ładunkowych).
 */

public class Simulation {

  public static void main(String[] args) {
    Warehouses.GDANSK.dockTransport("ship");
    Warehouses.GDANSK.loadContainers();
    Warehouses.GDANSK.sendTransport(Warehouses.NEW_YORK);
    Warehouses.NEW_YORK.unloadContainers();
    Warehouses.NEW_YORK.pack(CommodityTypes.ELECTRONIC, 10);
    Warehouses.NEW_YORK.pack(CommodityTypes.CELLPHONE, 20);
    Warehouses.NEW_YORK.pack(CommodityTypes.CLOTHES, 5);
    Warehouses.NEW_YORK.pack(CommodityTypes.SHOES, 5);
    Warehouses.NEW_YORK.dockTransport("ship");
    Warehouses.NEW_YORK.loadContainers();
    Warehouses.NEW_YORK.sendTransport(Warehouses.GDANSK);
    Warehouses.GDANSK.unloadContainers(); // 7

    Warehouses.GDANSK.dockTransport("train");
    Warehouses.GDANSK.loadContainers();
    Warehouses.GDANSK.sendTransport(Warehouses.WROCLAW);
    Warehouses.WROCLAW.unloadContainers();
    Warehouses.WROCLAW.storeContainers();

    Warehouses.GDANSK.dockTransport("train");
    Warehouses.GDANSK.loadContainers();
    Warehouses.GDANSK.sendTransport(Warehouses.WROCLAW);
    Warehouses.WROCLAW.unloadContainers();
    Warehouses.WROCLAW.storeContainers(); // 8

    Warehouses.WROCLAW.pack(CommodityTypes.SHOES);
    Warehouses.WROCLAW.pack(CommodityTypes.CLOTHES);
//    Warehouses.WROCLAW.pack(CommodityTypes.CELLPHONE);
    Warehouses.WROCLAW.pack(CommodityTypes.ELECTRONIC);

    sendAllPreparedContainers();

    System.out.printf("Łączna ilość przejazdów: %d", Transport.transportCounter);
  }

  private static void sendAllPreparedContainers() {
    int size = Warehouses.WROCLAW.getContainersWarehouse().size();
    int skippingVariable = 0;
    for (int i = 0; i < size; i++) {
      Container container = Warehouses.WROCLAW.getContainersWarehouse().get(
          Warehouses.WROCLAW.getContainersWarehouse().size() - 1 - skippingVariable
      );
      if (container.isEmpty()) {
        skippingVariable++;
      } else {
        send(container);
      }
    }
  }

  private static void send(Container container) {
    CommodityTypes commodityType = container.getCommodityType();
    switch (commodityType) {
      case CLOTHES:
      case SHOES:
        sendTo(commodityType, Warehouses.POZNAN);
        break;
//      case CELLPHONE:
      case ELECTRONIC:
        sendTo(commodityType, Warehouses.KRAKOW);
        break;
      default: throw new IllegalArgumentException();
    }
  }

  private static void sendTo(CommodityTypes commodityType, Warehouse warehouse) {
    Warehouses.WROCLAW.dockTransport("truck");
    Warehouses.WROCLAW.loadContainers(commodityType);
    Warehouses.WROCLAW.sendTransport(warehouse);
    warehouse.unloadContainers();
    warehouse.storeContainers();
  }

}
