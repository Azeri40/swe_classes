"""Homework solutions for the assignment."""

from __future__ import annotations

from math import exp, pi, sqrt


IDEAL_GAS_CONSTANT = 8.31446261815324


def ideal_gas_moles(pressure: float, volume: float, temperature: float) -> float:
    """Return the number of moles from the ideal gas law: n = PV / (RT)."""
    if temperature <= 0:
        raise ValueError("temperature must be greater than 0")
    return (pressure * volume) / (IDEAL_GAS_CONSTANT * temperature)


def normal_pdf(mu: float, sigma: float, x: float) -> float:
    """Return the value of the normal distribution PDF at x."""
    if sigma <= 0:
        raise ValueError("sigma must be greater than 0")
    coefficient = 1.0 / (sigma * sqrt(2.0 * pi))
    exponent = -((x - mu) ** 2) / (2.0 * sigma**2)
    return coefficient * exp(exponent)


def geometric_series_terms(n: int) -> list[float]:
    """Return the terms of sum((3 + 2n) / 2^n) for n from 0 to N."""
    if n < 0:
        raise ValueError("n must be greater than or equal to 0")
    return [(3 + 2 * i) / (2**i) for i in range(n + 1)]


def geometric_series_sum(n: int) -> float:
    """Return the sum of the geometric-series-like terms up to N."""
    return sum(geometric_series_terms(n))


if __name__ == "__main__":
    print("Ideal gas law examples:")
    print(ideal_gas_moles(0.0, 0.25, 300.0))
    print(ideal_gas_moles(500.0, 1.0, 321.0))
    print(ideal_gas_moles(2.5e3, 1.0e-5, 350.0))

    print("\nNormal distribution examples:")
    print(normal_pdf(0.0, 1.0, 0.5))
    print(normal_pdf(3.0, 0.1, -2.8))
    print(normal_pdf(-1.0, 3.0, -1.1))

    print("\nGeometric series examples:")
    for value in (5, 10, 100):
        print(value, geometric_series_terms(value), geometric_series_sum(value))
