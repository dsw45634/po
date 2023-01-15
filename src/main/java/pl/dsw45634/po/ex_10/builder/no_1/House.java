package pl.dsw45634.po.ex_10.builder.no_1;

class House {

  private final String foundation;
  private final String walls;
  private final String doors;
  private final Integer floors;
  private final Integer rooms;
  private final String roof;
  private final String pool;
  private final String garden;

  private House(String foundation, String walls, String doors, Integer floors, Integer rooms,
      String roof, String pool, String garden) {
    this.foundation = foundation;
    this.walls = walls;
    this.doors = doors;
    this.floors = floors;
    this.rooms = rooms;
    this.roof = roof;
    this.pool = pool;
    this.garden = garden;
  }

  public static Builder builder() {
    return new Builder();
  }

  static class Builder {

    private String foundation;
    private String walls;
    private String doors;
    private Integer floors;
    private Integer rooms;
    private String roof;
    private String pool;
    private String garden;

    public Builder foundation(String foundation) {
      this.foundation = foundation;
      return this;
    }

    public Builder walls(String walls) {
      this.walls = walls;
      return this;
    }

    public Builder doors(String doors) {
      this.doors = doors;
      return this;
    }

    public Builder floors(Integer floors) {
      this.floors = floors;
      return this;
    }

    public Builder rooms(Integer rooms) {
      this.rooms = rooms;
      return this;
    }

    public Builder roof(String roof) {
      this.roof = roof;
      return this;
    }

    public Builder pool(String pool) {
      this.pool = pool;
      return this;
    }

    public Builder garden(String garden) {
      this.garden = garden;
      return this;
    }

    public House build() {
      return new House(this.foundation, this.walls, this.doors, this.floors, this.rooms,
          this.roof, this.pool, this.garden);
    }
  }
}
