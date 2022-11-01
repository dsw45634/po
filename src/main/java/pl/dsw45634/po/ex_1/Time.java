package pl.dsw45634.po.ex_1;

import java.util.Objects;

class Time {

  private int hours;
  private int minutes;
  private int seconds;

  private Time() {}

  static Time of(String time) {
    Time t = new Time();
    String[] split = time.split(":");
    t.hours = Integer.parseInt(split[0]);
    t.minutes = Integer.parseInt(split[1]);
    if (split.length > 2) {
      t.seconds = Integer.parseInt(split[2]);
    }
    return t;
  }

  static Time of(int seconds) {
    Time time = new Time();
    time.seconds = seconds % 60;
    int minutes = seconds / 60;
    time.minutes = minutes % 60;
    time.hours = minutes / 60;
    return time;
  }

  Time difference(Time time) {
    int s1 = this.hours * 3600 + this.minutes * 60 + this.seconds;
    int s2 = time.hours * 3600 + time.minutes * 60 + time.seconds;
    int result = Math.abs(s1 - s2);
    return Time.of(result);
  }

  int getSeconds() {
    return this.hours * 60 * 60 + this.minutes * 60 + this.seconds;
  }

  Time plus(Time time) {
    int seconds = this.getSeconds() + time.getSeconds();
    return Time.of(seconds);
  }

  boolean isBefore(Time time) {
    return this.getSeconds() < time.getSeconds();
  }

  boolean lessOrEqual(Time time) {
    return this.getSeconds() <= time.getSeconds();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Time)) {
      return false;
    }
    Time time = (Time) o;
    return hours == time.hours && minutes == time.minutes && seconds == time.seconds;
  }

  @Override
  public int hashCode() {
    return Objects.hash(hours, minutes, seconds);
  }

  @Override
  public String toString() {
    String HH = this.hours < 10 ? "0" + this.hours : "" + this.hours;
    String mm = this.minutes < 10 ? "0" + this.minutes : "" + this.minutes;
    String ss = this.seconds < 10 ? "0" + this.seconds : "" + this.seconds;
    return String.format("%s:%s:%s", HH, mm, ss);
  }
}
