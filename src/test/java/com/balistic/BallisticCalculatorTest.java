package com.balistic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Unit tests for BallisticCalculator.
 */
class BallisticCalculatorTest {

    private static final double DELTA = 0.01;

    @Test
    @DisplayName("Max height at 45 degrees with 50 m/s")
    void testMaxHeight45Degrees() {
        double result = BallisticCalculator.calculateMaxHeight(50.0, 45.0);
        assertEquals(63.71, result, DELTA);
    }

    @Test
    @DisplayName("Range at 45 degrees with 50 m/s")
    void testRange45Degrees() {
        double result = BallisticCalculator.calculateRange(50.0, 45.0);
        assertEquals(254.84, result);
    }

    @Test
    @DisplayName("Time of flight at 45 degrees with 50 m/s")
    void testTimeOfFlight45Degrees() {
        double result = BallisticCalculator.calculateTimeOfFlight(50.0, 45.0);
        assertEquals(7.21, result, DELTA);
    }

    @Test
    @DisplayName("Max height at 0 degrees should be 0")
    void testMaxHeight0Degrees() {
        double result = BallisticCalculator.calculateMaxHeight(50.0, 0.0);
        assertEquals(0.0, result, DELTA);
    }

    @Test
    @DisplayName("Max height at 90 degrees (straight up)")
    void testMaxHeight90Degrees() {
        double result = BallisticCalculator.calculateMaxHeight(50.0, 90.0);
        assertEquals(127.42, result, DELTA);
    }

    @Test
    @DisplayName("Range at 90 degrees should be 0")
    void testRange90Degrees() {
        double result = BallisticCalculator.calculateRange(50.0, 90.0);
        assertEquals(0.0, result, DELTA);
    }

    @Test
    @DisplayName("Zero velocity produces zero range")
    void testZeroVelocity() {
        double result = BallisticCalculator.calculateRange(0.0, 45.0);
        assertEquals(0.0, result, DELTA);
    }

    @Test
    @DisplayName("Negative velocity throws exception")
    void testNegativeVelocity() {
        assertThrows(IllegalArgumentException.class, () ->
                BallisticCalculator.calculateMaxHeight(-10.0, 45.0));
    }

    @Test
    @DisplayName("Angle above 90 throws exception")
    void testAngleAbove90() {
        assertThrows(IllegalArgumentException.class, () ->
                BallisticCalculator.calculateRange(50.0, 95.0));
    }

    @Test
    @DisplayName("Negative angle throws exception")
    void testNegativeAngle() {
        assertThrows(IllegalArgumentException.class, () ->
                BallisticCalculator.calculateTimeOfFlight(50.0, -5.0));
    }

    @ParameterizedTest
    @CsvSource({
            "10.0, 30.0, 1.27",
            "20.0, 45.0, 10.19",
            "30.0, 60.0, 34.40"
    })
    @DisplayName("Parameterized max height tests")
    void testMaxHeightParameterized(double velocity, double angle,
                                    double expected) {
        double result = BallisticCalculator.calculateMaxHeight(velocity, angle);
        assertEquals(expected, result, DELTA);
    }

    @ParameterizedTest
    @CsvSource({
            "10.0, 30.0, 8.83",
            "20.0, 45.0, 40.77",
            "30.0, 60.0, 79.45"
    })
    @DisplayName("Parameterized range tests")
    void testRangeParameterized(double velocity, double angle,
                                double expected) {
        double result = BallisticCalculator.calculateRange(velocity, angle);
        assertEquals(expected, result, DELTA);
    }

    @Test
    @DisplayName("Optimal angle should be 45 degrees")
    void testOptimalAngle() {
        assertEquals(45.0, BallisticCalculator.getOptimalAngle(), DELTA);
    }

    @Test
    @DisplayName("Calculate X position at time 0 should be 0")
    void testCalculateXAtTime0() {
        double result = BallisticCalculator.calculateX(50.0, 45.0, 0.0);
        assertEquals(0.0, result, DELTA);
    }

    @Test
    @DisplayName("Calculate Y position at time 0 should be 0")
    void testCalculateYAtTime0() {
        double result = BallisticCalculator.calculateY(50.0, 45.0, 0.0);
        assertEquals(0.0, result, DELTA);
    }

    @Test
    @DisplayName("Calculate X position at some time")
    void testCalculateXAtTime() {
        double result = BallisticCalculator.calculateX(50.0, 45.0, 2.0);
        assertEquals(70.71, result, DELTA);
    }

    @Test
    @DisplayName("Calculate Y position at some time")
    void testCalculateYAtTime() {
        double result = BallisticCalculator.calculateY(50.0, 45.0, 2.0);
        assertEquals(51.09, result, DELTA);
    }
}
