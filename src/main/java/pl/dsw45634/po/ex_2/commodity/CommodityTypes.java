package pl.dsw45634.po.ex_2.commodity;

public enum CommodityTypes {

  ELECTRONIC(20, 20, 20),
  CELLPHONE(10, 10, 20),
  CLOTHES(40, 40, 40),
  SHOES(20, 20, 50);

  public int width;
  public int height;
  public int length;

  CommodityTypes(int width, int height, int length) {
    this.width = width;
    this.height = height;
    this.length = length;
  }
}
