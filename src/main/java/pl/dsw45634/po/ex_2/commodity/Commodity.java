package pl.dsw45634.po.ex_2.commodity;

/**
 Towar – klasa reprezentująca towar, zawiera potrzebne pola i metody
 */

public abstract class Commodity {

  protected final int width;
  protected final int height;
  protected final int length;

  public Commodity(int width, int height, int length) {
    this.width = width;
    this.height = height;
    this.length = length;
  }

  public static Commodity of(CommodityTypes cT) {
    switch (cT) {
      case SHOES: return new Shoes(cT.width, cT.height, cT.length);
      case CLOTHES: return new Clothes(cT.width, cT.height, cT.length);
      case ELECTRONIC: return new Electronic(cT.width, cT.height, cT.length);
      case CELLPHONE: return new Cellphone(cT.width, cT.height, cT.length);
      default: throw new IllegalArgumentException("Commodity does not exist.");
    }
  }
}
