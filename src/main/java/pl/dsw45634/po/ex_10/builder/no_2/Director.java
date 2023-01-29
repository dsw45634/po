package pl.dsw45634.po.ex_10.builder.no_2;

class Director {

  public void constructHouse(Builder builder) {
    builder.setFoundation("Foundation");
    builder.setWalls("Drywall");
    builder.setDoors("Plywood");
    builder.setFloors(1);
    builder.setRooms(8);
    builder.setRoof("Tiles");
  }

  public void constructBigHouse(Builder builder) {
    builder.setFoundation("Foundation");
    builder.setWalls("Brick");
    builder.setDoors("Wooden");
    builder.setFloors(2);
    builder.setRooms(16);
    builder.setRoof("Tiles");
    builder.setPool("Pool");
    builder.setGarden("Garden");
  }

  public void constructCastle(Builder builder) {
    builder.setFoundation("Foundation");
    builder.setWalls("Stones");
    builder.setDoors("Wooden");
    builder.setFloors(4);
    builder.setRooms(55);
    builder.setGarden("Garden");
  }

}
