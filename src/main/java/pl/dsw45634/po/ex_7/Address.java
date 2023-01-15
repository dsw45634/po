package pl.dsw45634.po.ex_7;

import java.util.regex.Pattern;

class Address {

  private String street;
  private String number;
  private String postcode;
  private String city;

  private Address(String street, String number, String postcode, String city) {
    this.street = street;
    this.number = number;
    this.postcode = postcode;
    this.city = city;
  }

  public static Address address(String street, String number, String postcode, String city) {
    if (street == null) {
      throw new IllegalArgumentException("Street can not be null.");
    }
    if (city == null) {
      throw new IllegalArgumentException("City can not be null.");
    }
    if (!Pattern.compile("[0-9]+[a-z]|[0-9]+").matcher(number).matches()) {
      throw new IllegalArgumentException("Invalid number: " + number);
    }
    if (!Pattern.compile("[0-9][0-9]-[0-9][0-9][0-9]").matcher(postcode).matches()) {
      throw new IllegalArgumentException("Invalid postcode: " + postcode);
    }
    return new Address(street, number, postcode, city);
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
