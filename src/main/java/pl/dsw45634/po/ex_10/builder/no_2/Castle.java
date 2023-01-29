package pl.dsw45634.po.ex_10.builder.no_2;

class Castle {

  private final String foundation;
  private final String walls;
  private final String doors;
  private final Integer floors;
  private final Integer rooms;
  private final String roof;
  private final String pool;
  private final String garden;

  public Castle(String foundation, String walls, String doors, Integer floors,
      Integer rooms, String roof, String pool, String garden) {
    this.foundation = foundation;
    this.walls = walls;
    this.doors = doors;
    this.floors = floors;
    this.rooms = rooms;
    this.roof = roof;
    this.pool = pool;
    this.garden = garden;
  }

  public String getFoundation() {
    return foundation;
  }

  public String getWalls() {
    return walls;
  }

  public String getDoors() {
    return doors;
  }

  public Integer getFloors() {
    return floors;
  }

  public Integer getRooms() {
    return rooms;
  }

  public String getRoof() {
    return roof;
  }

  public String getPool() {
    return pool;
  }

  public String getGarden() {
    return garden;
  }

  @Override
  public String toString() {
    return "Castle{" +
        "foundation='" + foundation + '\'' +
        ", walls='" + walls + '\'' +
        ", doors='" + doors + '\'' +
        ", floors=" + floors +
        ", rooms=" + rooms +
        ", roof='" + roof + '\'' +
        ", pool='" + pool + '\'' +
        ", garden='" + garden + '\'' +
        '}';
  }
}
