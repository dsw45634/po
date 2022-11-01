package pl.dsw45634.po.ex_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pl.dsw45634.po.ex_2.commodity.Commodity;
import pl.dsw45634.po.ex_2.commodity.CommodityTypes;

/**
 * Kontener – klasa reprezentująca kontener, zawiera pole przechowujące obiekt klasy Towar,
 * zawiera metody umożliwiające załadowanie i rozładowanie towaru.
 */

public class Container {

  private static final int WIDTH = 200;
  private static final int HEIGHT = 200;
  private static final int LENGTH = 1000;

  private Commodity[][][] space;
  private CommodityTypes commodityType;

  public static int countCommoditiesAmount(CommodityTypes cT) {
    int length = LENGTH / cT.length;
    int width = WIDTH / cT.width;
    int height = HEIGHT / cT.height;
    return length * width * height;
  }

  public CommodityTypes getCommodityType() {
    return commodityType;
  }

  public void prepareContainer(CommodityTypes cT) {
    this.commodityType = cT;
    this.space = new Commodity[LENGTH / cT.length][WIDTH / cT.width][HEIGHT / cT.height];
  }

  public void loadContainer(List<Commodity> commodities) {
    for (int lengthIndex = 0; lengthIndex < space.length; lengthIndex++) {
      for (int widthIndex = 0; widthIndex < space[lengthIndex].length; widthIndex++) {
        for (int heightIndex = 0; heightIndex < space[lengthIndex][widthIndex].length; heightIndex++) {
          this.space[lengthIndex][widthIndex][heightIndex] = commodities.get(commodities.size() - 1);
        }
      }
    }
  }

  public List<Commodity> unload() {
    List<Commodity> commodities = new ArrayList<>();
    for (Commodity[][] value : space) {
      for (Commodity[] item : value) {
        commodities.addAll(Arrays.asList(item).subList(0, item.length));
      }
    }
    this.space = null;
    this.commodityType = null;
    return commodities;
  }

  public boolean isEmpty() {
    return this.space == null;
  }
}
