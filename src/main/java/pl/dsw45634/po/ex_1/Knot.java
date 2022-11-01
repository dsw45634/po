package pl.dsw45634.po.ex_1;

class Knot extends Speed {

  Knot(double value) {
    super(value);
  }

  @Override
  public Speed convert() {
    double speedMeterPerSeconds = this.value * 0.51;
    return new MeterPerSecond(speedMeterPerSeconds);
  }

  @Override
  Time calculateTime(Distance distance) {
    Speed meterPerSeconds = this.convert();
    double time = distance.getMeters() / meterPerSeconds.value;
    return Time.of((int) time);
  }

  @Override
  Distance calculateDistance(Time time) {
    Speed meterPerSeconds = this.convert();
    double distanceKm = (meterPerSeconds.value * time.getSeconds());
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
