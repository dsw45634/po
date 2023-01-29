package pl.dsw45634.po.ex_10.builder.no_2;

// refactoring guru

class HouseBuilder implements Builder {

  private String foundation;
  private String walls;
  private String doors;
  private Integer floors;
  private Integer rooms;
  private String roof;
  private String pool;
  private String garden;

  @Override
  public void setFoundation(String foundation) {
    this.foundation = foundation;
  }

  @Override
  public void setWalls(String walls) {
    this.walls = walls;
  }

  @Override
  public void setDoors(String doors) {
    this.doors = doors;
  }

  @Override
  public void setFloors(Integer floors) {
    this.floors = floors;
  }

  @Override
  public void setRooms(Integer rooms) {
    this.rooms = rooms;
  }

  @Override
  public void setRoof(String roof) {
    this.roof = roof;
  }

  @Override
  public void setPool(String pool) {
    this.pool = pool;
  }

  @Override
  public void setGarden(String garden) {
    this.garden = garden;
  }

  public House getResult() {
    return new House(this.foundation, this.walls, this.doors, this.floors,
        this.rooms, this.roof, this.pool, this.garden);
  }

}
