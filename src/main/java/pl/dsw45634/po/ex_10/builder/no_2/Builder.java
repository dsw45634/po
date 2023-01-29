package pl.dsw45634.po.ex_10.builder.no_2;

// refactoring guru

interface Builder {

  void setFoundation(String foundation);
  void setWalls(String walls);
  void setDoors(String doors);
  void setFloors(Integer floors);
  void setRooms(Integer rooms);
  void setRoof(String roof);
  void setPool(String pool);
  void setGarden(String garden);

}
