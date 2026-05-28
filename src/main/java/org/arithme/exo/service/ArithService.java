package org.arithme.exo.service;

import org.springframework.stereotype.Service;

@Service
public class ArithService {
  public int add(int a, int b) {
    if (a <= 0 || b <= 0) {
      throw new IllegalArgumentException("a and b must be positive");
    }

    if (a > 0 && b > Integer.MAX_VALUE - a) {
      throw new ArithmeticException("Integer overflow");
    }

    if (a == 0 || b == 0) {
      throw new IllegalArgumentException("a and b cannot be zero");
    }

    return a + b;
  }

  public int subtract(int a, int b) {
    if (a < 0 || b < 0) {
      throw new IllegalArgumentException("a and b must be positive");
    }

    if (a < b) {
      throw new IllegalArgumentException("Result cannot be negative: a must be >= b");
    }

    return a - b;
  }

  public int divise(int a, int b) {
    if (a < 0 || b < 0) {
      throw new IllegalArgumentException("a and b must be positive");
    }

    if (b == 0) {
      throw new IllegalArgumentException("b cannot be zero");
    }

    return a / b;
  }

  public int multiply(int a, int b) {
    if (a == 0 || b == 0) {
      throw new IllegalArgumentException("a and b cannot be zero");
    }

    if (a < 0 || b < 0) {
      throw new IllegalArgumentException("Factors must be non-negative");
    }

    return a * b;
  }
}
