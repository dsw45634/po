package pl.dsw45634.po.ex_1;

class FlightSimulator {

  public void willIBeOnTime(String departure, String distance, Phrase rugPhrase,
      Phrase windPhrase, String windSpeed, String expectedTime) {

    Vector windVector = new Vector(windPhrase, Speed.speed(windSpeed));
    Rug rug = Rug.initRug(rugPhrase, windVector);

    Time maxFlightTime = Time.of(departure).difference(Time.of(expectedTime));
    Time resultTime = rug.calculateTime(Distance.of(distance));

    boolean result = resultTime.lessOrEqual(maxFlightTime);
    System.out.println("Odp a): " + result);
  }

  public void whenDoIGetToWroclaw(String departure, String distance, Phrase rugPhrase,
      String firstWindTime, Phrase firstWindPhrase, String firstWindSpeed,
      Phrase secondWindPhrase, String secondWindSpeed) {

    Vector firstWindVector = new Vector(firstWindPhrase, Speed.speed(firstWindSpeed));

    Rug rug = Rug.initRug(rugPhrase, firstWindVector);
    Time firstSpeedTime = Time.of(firstWindTime);

    Time departureTime = Time.of(departure);
    Time result;
    Distance firstDistance = rug.calculateDistance(firstSpeedTime);
    Distance allDistance = Distance.of(distance);
    if (firstDistance.graterThan(allDistance)) {
      Time time = rug.calculateTime(allDistance);
      result = departureTime.plus(time);
      System.out.println("Odp b): " + result);
      return;
    } else if (firstDistance.isEqualTo(allDistance)) {
      result = departureTime.plus(firstSpeedTime);
      System.out.println("Odp b): " + result);
      return;
    }

    Vector secondWindVector = new Vector(secondWindPhrase, Speed.speed(secondWindSpeed));
    rug.includeWind(secondWindVector);

    allDistance = allDistance.minus(firstDistance);
    Time secondTime = rug.calculateTime(allDistance);

    result = departureTime.plus(firstSpeedTime).plus(secondTime);
    System.out.println("Odp b): " + result);
  }

  public void meetingOnTheSummit(String firstDeparture, Phrase firstPhrase, String secondDeparture,
      Phrase secondPhrase, String distance, Phrase windPhrase, String windSpeed) {

    Vector windVector = new Vector(windPhrase, Speed.speed(windSpeed));
    Rug firstRug = Rug.initRug(firstPhrase, windVector);
    Rug secondRug = Rug.initRug(secondPhrase, windVector);

    Time firstTime = Time.of(firstDeparture);
    Time secondTime = Time.of(secondDeparture);

    Distance resultDistance = Distance.of(0);
    Distance firstDistance = Distance.of(0);
    Distance allDistance = Distance.of(distance);
    if (!firstTime.equals(secondTime)) {
      Time differenceTime = firstTime.difference(secondTime);
      if (firstTime.isBefore(secondTime)) {
        firstDistance = firstRug.calculateDistance(differenceTime);
        resultDistance = firstDistance;
      } else {
        firstDistance = secondRug.calculateDistance(differenceTime);
      }
      allDistance = allDistance.minus(firstDistance);
    }

    resultDistance = Distance.of((int) (resultDistance.getMeters() + ((allDistance.getMeters() * firstRug.getResultSpeed().value) / (secondRug.getResultSpeed().value + firstRug.getResultSpeed().value))));
    Time time = firstRug.calculateTime(resultDistance);
    System.out.printf("Odp c): Spotkanie magów %sm od Wrocławia o godzinie: %s\n", resultDistance, firstTime.plus(time));
  }

  public void speedControl(String speedLimit, String distance, String flightTime) {
    Distance s = Distance.of(distance);
    Time t = Time.of(flightTime);
    Speed rugSpeed = Speed.speed(s, t);
    Speed speedLimitKnot = Speed.speed(speedLimit);
    boolean result = rugSpeed.graterThan(speedLimitKnot);
    System.out.println("Odp d): " + result);
  }

  public static void main(String[] args) {
    FlightSimulator flightSimulator = new FlightSimulator();
    flightSimulator.willIBeOnTime("17:00", "300km", Phrase.W, Phrase.E, "10kt", "20:30");
    flightSimulator.whenDoIGetToWroclaw("11:20", "500km", Phrase.S, "2:30", Phrase.S, "2kt", Phrase.E, "3kt");
    flightSimulator.meetingOnTheSummit("10:15", Phrase.E, "10:30", Phrase.W, "270km", Phrase.W, "8kt");
    flightSimulator.speedControl("40kt",  "70km", "0:40");
  }

}
