package pl.dsw45634.po.ex_1;

class Rug {

  private static final Speed MAX_RUG_SPEED = Speed.speed("25");

  private Speed resultSpeed;
  private Phrase itsPhrase;

  private Rug(Phrase itsPhrase) {
    this.itsPhrase = itsPhrase;
  }

  Speed getResultSpeed() {
    return resultSpeed;
  }

  static Rug initRug(Phrase rugPhrase, Vector windVector) {
    Rug rug = new Rug(rugPhrase);
    rug.includeWind(windVector);
    return rug;
  }

  void includeWind(Vector windVector) {
    Vector itsVector = new Vector(itsPhrase, MAX_RUG_SPEED);
    Vector resultVector = itsVector.addVector(windVector);
    this.itsPhrase = resultVector.getPhrase();
    this.resultSpeed = resultVector.getSpeed();
  }

  public Time calculateTime(Distance distance) {
    return resultSpeed.calculateTime(distance);
  }

  public Distance calculateDistance(Time time) {
    return resultSpeed.calculateDistance(time);
  }
}
