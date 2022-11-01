package pl.dsw45634.po.ex_1;

class MeterPerSecond extends Speed {

  MeterPerSecond(double value) {
    super(value);
  }

  @Override
  public Speed convert() {
    double speedKnot = this.value * 1.96;
    return new Knot(speedKnot);
  }

  @Override
  Time calculateTime(Distance distance) {
    double time = distance.getMeters() / this.value;
    return Time.of((int) time);
  }

  @Override
  Distance calculateDistance(Time time) {
    double distanceKm = this.value * time.getSeconds();
    return Distance.of((int) distanceKm);
  }

  @Override
  boolean graterThan(Speed speed) {
    if (!(speed instanceof Knot)) {
      speed = speed.convert();
    }
    return this.value > speed.value;
  }
}
