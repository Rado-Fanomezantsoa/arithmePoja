package org.arithme.exo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ArithServiceTest {

  private final ArithService arithService;

  @Test
  void add_two_positive_numbers_should_return_their_sum() {
    var a = 5;
    var b = 10;

    var sum = arithService.add(a, b);

    assertEquals(15, sum);
  }

  @Test
  void add_negative_numbers_should_throw_exception() {
    var a = -5;
    var b = -10;

    assertThrows(IllegalArgumentException.class, () -> arithService.add(a, b));
  }

  @Test
  void add_numbers_cause_overflow_should_throw_arithmetic_exception() {
    int a = Integer.MAX_VALUE;
    int b = 1;

    assertThrows(ArithmeticException.class, () -> arithService.add(a, b));
  }

  @Test
  void add_large_positive_numbers_should_return_sum() {
    int a = 1_000_000_000;
    int b = 2_000_000_000;

    assertEquals(3_000_000_000L, (long) arithService.add(a, b));
  }

  // subtract tests
  @Test
  void subtract_two_positive_numbers_should_return_difference() {
    var a = 10;
    var b = 4;
    assertEquals(6, arithService.subtract(a, b));
  }

  @Test
  void subtract_equal_numbers_should_return_zero() {
    int a = 5;
    int b = 5;
    assertEquals(0, arithService.subtract(a, b));
  }

  @Test
  void subtract_with_negative_input_should_throw_exception() {

    // Teste a négatif
    assertThrows(IllegalArgumentException.class, () -> arithService.subtract(-5, 10));

    // Teste b négatif
    assertThrows(IllegalArgumentException.class, () -> arithService.subtract(10, -5));
  }

  // divise tests

  @Test
  void divide_two_positive_numbers_should_return_quotient() {
    assertEquals(5, arithService.divise(10, 2));
    assertEquals(2, arithService.divise(5, 2));
  }

  @Test
  void divide_by_zero_should_throw_illegalArgumentException() {
    int a = 10;
    int b = 0;

    Exception exception =
        assertThrows(IllegalArgumentException.class, () -> arithService.divise(a, b));
    assertTrue(exception.getMessage().contains("zero"));
  }

  @Test
  void divide_two_negatives_should_return_positive() {
    assertEquals(5, arithService.divise(-10, -2));
  }

  // multiply tests

  @Test
  void multiply_two_positive_numbers_should_return_product() {
    assertEquals(20, arithService.multiply(4, 5));
    assertEquals(100, arithService.multiply(10, 10));
  }

  @Test
  void multiply_large_numbers_cause_overflow_should_throw_arithmetic_exception() {
    int a = 40_000;
    int b = 60_000;

    assertThrows(ArithmeticException.class, () -> arithService.multiply(a, b));
  }

  @Test
  void multiply_max_value_by_two_should_throw_arithmetic_exception() {
    int a = Integer.MAX_VALUE;
    int b = 2;

    assertThrows(ArithmeticException.class, () -> arithService.multiply(a, b));
  }

  @Test
  void multiply_by_zero_should_throw_illegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> arithService.multiply(5, 0));
    assertThrows(IllegalArgumentException.class, () -> arithService.multiply(0, 5));
  }

  void multiply_by_one_should_return_same_value() {
    assertEquals(123, arithService.multiply(123, 1));
    assertEquals(Integer.MAX_VALUE, arithService.multiply(Integer.MAX_VALUE, 1));
  }

  @Test
  void multiply_with_negative_input_should_throw_exception() {
    assertThrows(IllegalArgumentException.class, () -> arithService.multiply(-5, 10));
    assertThrows(IllegalArgumentException.class, () -> arithService.multiply(10, -5));
    assertThrows(IllegalArgumentException.class, () -> arithService.multiply(-5, -5));
  }
}
