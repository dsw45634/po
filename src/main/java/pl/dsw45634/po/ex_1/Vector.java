package pl.dsw45634.po.ex_1;

class Vector {

  private final Phrase phrase;
  private final Speed speed;

  Vector(Phrase phrase, Speed speed) {
    this.phrase = phrase;
    this.speed = speed;
  }

  Phrase getPhrase() {
    return phrase;
  }

  Speed getSpeed() {
    return speed;
  }

  Vector addVector(Vector windVector) {
    if (this.phrase.direction == windVector.phrase.direction) {
      if (notTheSameSpeedUnit(windVector)) {
        Speed speed = windVector.speed.convert();
        windVector = new Vector(windVector.phrase, speed);
      }
      double speedValue = this.phrase == windVector.phrase ? this.speed.value - windVector.speed.value
          : this.speed.value + windVector.speed.value;
      return speedValue < 0 ? new Vector(windVector.phrase, new MeterPerSecond(Math.abs(speedValue)))
          : new Vector(this.phrase, new MeterPerSecond(speedValue));
    }
    return this;
  }

  private boolean notTheSameSpeedUnit(Vector windVector) {
    return !(windVector.speed.getClass().equals(this.speed.getClass()));
  }
}
