package pl.dsw45634.po.ex_10.builder.no_2;

// refactoring guru

class Main {

  public static void main(String[] args) {

    Director director = new Director();
    HouseBuilder houseBuilder = new HouseBuilder();
    CastleBuilder castleBuilder = new CastleBuilder();

    director.constructCastle(castleBuilder);
    Castle castle = castleBuilder.getResult();

    director.constructBigHouse(houseBuilder);
    House house = houseBuilder.getResult();

    System.out.println(castle);
    System.out.println(house);
  }

}
