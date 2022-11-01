package pl.dsw45634.po.ex_1;

abstract class Speed {

  protected final double value;

  static Speed speed(String value) {
    if (value.contains("kt")) {
      String kt = value.replace("kt", "");
      double v = Double.parseDouble(kt);
      return new Knot(v);
    }
    double v = Double.parseDouble(value);
    return new MeterPerSecond(v);
  }

  static Speed speed(double value) {
    return new MeterPerSecond(value);
  }

  static Speed speed(Distance distance, Time time) {
    double v = ((double) distance.getMeters()) / time.getSeconds();
    return new MeterPerSecond(v);
  }

  protected Speed(double value) {
    this.value = value;
  }

  abstract Speed convert();

  abstract Time calculateTime(Distance distance);

  abstract Distance calculateDistance(Time time);

  abstract boolean graterThan(Speed speed);
}
