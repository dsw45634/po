package pl.dsw45634.po.ex_7;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class AddressTest {

  private static final String STREET = "Karmelkowa";
  private static final String CITY = "Wroclaw";

  @ParameterizedTest
  @MethodSource(value = "provideCorrectData")
  public void shouldCreateAddressTest(String number, String postcode) {
    Address result = Address.address(STREET, number, postcode, CITY);

    Assertions.assertThat(result.getNumber()).isNotNull();
    Assertions.assertThat(result.getPostcode()).isNotNull();
  }

  @ParameterizedTest
  @MethodSource(value = "provideDataWithIncorrectNumber")
  public void shouldThrowIllegalArgumentExceptionWhenNumberIsIncorrectTest(String number, String postcode) {
    Throwable throwable = Assertions.catchThrowable(() -> Address.address(STREET, number, postcode, CITY));
    Assertions.assertThat(throwable)
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Invalid number: " + number);
  }

  @ParameterizedTest
  @MethodSource(value = "provideDataWithIncorrectPostcode")
  public void shouldThrowIllegalArgumentExceptionWhenPostcodeIsIncorrectTest(String number, String postcode) {
    Throwable throwable = Assertions.catchThrowable(() -> Address.address(STREET, number, postcode, CITY));
    Assertions.assertThat(throwable)
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Invalid postcode: " + postcode);
  }

  private static List provideCorrectData() {
    return Arrays.asList(new Object[][] {
        {"1", "11-111"},
        {"1b", "99-999"},
        {"1121323d", "00-000"},
        {"1121323", "23-983"}
    });
  }

  private static List provideDataWithIncorrectNumber() {
    return Arrays.asList(new Object[][] {
        {" 1", "11-111"},
        {"1ww", "99-999"},
        {"r1121323d", "00-000"},
        {"s", "23-983"},
        {" ", "23-983"}
    });
  }

  private static List provideDataWithIncorrectPostcode() {
    return Arrays.asList(new Object[][] {
        {"1", "11 111"},
        {"1b", " 99-999"},
        {"1121323d", "w0-000"},
        {"1121323", "u23-983"},
        {"1121323", "23x983"},
        {"1121323", "23x98e"}
    });
  }
}
