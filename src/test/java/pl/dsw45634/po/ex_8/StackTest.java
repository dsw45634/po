package pl.dsw45634.po.ex_8;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StackTest {

  private static final int NUMBER = 3;
  private static final int FIRST_ADDED = 1;
  private static final int SECOND_ADDED = 2;

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11})
  public void shouldCreateStack(int maxStackSize) {
//     Konstruktor przyjmuje wartość która określa maksymalny rozmiar stosu, ale po utworzeniu
//     jest pusty - dlatego pole size typu prostego int przyjmuje domyślną wartość 0
    Stack stack = new Stack(maxStackSize);

    Assertions.assertThat(stack.size()).isEqualTo(0);
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10, -11})
  public void shouldThrowIllegalArgumentExceptionWhenNegativeNumberIsGivenTest(int maxStackSize) {
    Throwable throwable = Assertions.catchThrowable(() -> new Stack(maxStackSize));

    Assertions.assertThat(throwable)
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Invalid Argument: " + maxStackSize);
  }

  @Test
  public void shouldPushTest() {
    // given
    Stack stack = new Stack(1);
    // when
    stack.push(NUMBER);
    // then
    Assertions.assertThat(stack.size()).isEqualTo(1);
  }

  @Test
  public void shouldThrowStackFullExceptionWhenTryingToPushToFullStackTest() {
    // given
    Stack stack = new Stack(0);
    // when
    Throwable throwable = Assertions.catchThrowable(() -> stack.push(NUMBER));
    // then
    Assertions.assertThat(throwable)
        .isInstanceOf(StackFullException.class);
  }

  @Test
  public void shouldThrowStackFullExceptionWhenTryingToPushToFullStackSecondTest() {
    // given
    Stack stack = new Stack(1);
    stack.push(NUMBER);
    // when
    Throwable throwable = Assertions.catchThrowable(() -> stack.push(NUMBER));
    // then
    Assertions.assertThat(throwable)
        .isInstanceOf(StackFullException.class);
  }

  @Test
  public void shouldPopTest() {
    // given
    Stack stack = new Stack(2);
    // when
    stack.push(FIRST_ADDED);
    stack.push(SECOND_ADDED);
    // then
    Assertions.assertThat(stack.size()).isEqualTo(2);

    // Nie wiem czy taki test ma sens...
    int firstResult = stack.pop();
    Assertions.assertThat(firstResult).isEqualTo(SECOND_ADDED);
    int secondResult = stack.pop();
    Assertions.assertThat(secondResult).isEqualTo(FIRST_ADDED);
  }

  @Test
  public void shouldThrowStackEmptyExceptionWhenTryingToPopFromEmptyStackTest() {
    // given
    Stack stack = new Stack(0);
    // when
    Throwable throwable = Assertions.catchThrowable(stack::pop);
    // then
    Assertions.assertThat(throwable)
        .isInstanceOf(StackEmptyException.class);
  }

  @Test
  public void shouldClearStackTest() {
    // given
    Stack stack = new Stack(3);
    stack.push(FIRST_ADDED);
    stack.push(SECOND_ADDED);
    stack.push(NUMBER);
    // when
    stack.clear();
    // then
    Assertions.assertThat(stack.size()).isEqualTo(0);
  }

  @Test
  public void shouldIncreaseSizeTest() {
    Stack stack = new Stack(3);
    Assertions.assertThat(stack.size()).isEqualTo(0);

    stack.push(FIRST_ADDED);
    Assertions.assertThat(stack.size()).isEqualTo(1);

    stack.push(SECOND_ADDED);
    Assertions.assertThat(stack.size()).isEqualTo(2);

    stack.push(NUMBER);
    Assertions.assertThat(stack.size()).isEqualTo(3);
  }

  @Test
  public void shouldDecreaseSizeWhenPoppingTest() {
    Stack stack = new Stack(3);
    stack.push(FIRST_ADDED);
    stack.push(SECOND_ADDED);
    stack.push(NUMBER);
    Assertions.assertThat(stack.size()).isEqualTo(3);

    stack.pop();
    Assertions.assertThat(stack.size()).isEqualTo(2);

    stack.pop();
    Assertions.assertThat(stack.size()).isEqualTo(1);

    stack.pop();
    Assertions.assertThat(stack.size()).isEqualTo(0);
  }
}
