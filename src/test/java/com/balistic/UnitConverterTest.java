package com.balistic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Unit tests for UnitConverter.
 */
class UnitConverterTest {

    private static final double DELTA = 0.01;

    @Test
    @DisplayName("Convert m/s to km/h")
    void testMpsToKmh() {
        assertEquals(180.0, UnitConverter.metersPerSecondToKmPerHour(50.0),
                DELTA);
    }

    @Test
    @DisplayName("Convert km/h to m/s")
    void testKmhToMps() {
        assertEquals(50.0, UnitConverter.kmPerHourToMetersPerSecond(180.0),
                DELTA);
    }

    @Test
    @DisplayName("Convert degrees to radians")
    void testDegreesToRadians() {
        assertEquals(Math.PI / 4, UnitConverter.degreesToRadians(45.0),
                DELTA);
    }

    @Test
    @DisplayName("Convert radians to degrees")
    void testRadiansToDegrees() {
        assertEquals(45.0, UnitConverter.radiansToDegrees(Math.PI / 4),
                DELTA);
    }

    @Test
    @DisplayName("Convert meters to feet")
    void testMetersToFeet() {
        assertEquals(328.08, UnitConverter.metersToFeet(100.0), DELTA);
    }

    @Test
    @DisplayName("Convert feet to meters")
    void testFeetToMeters() {
        assertEquals(100.0, UnitConverter.feetToMeters(328.084), DELTA);
    }

    @Test
    @DisplayName("Convert kg to pounds")
    void testKgToPounds() {
        assertEquals(220.46, UnitConverter.kgToPounds(100.0), DELTA);
    }

    @Test
    @DisplayName("Convert pounds to kg")
    void testPoundsToKg() {
        assertEquals(100.0, UnitConverter.poundsToKg(220.462), DELTA);
    }

    @Test
    @DisplayName("Zero m/s converts to zero km/h")
    void testZeroMpsToKmh() {
        assertEquals(0.0, UnitConverter.metersPerSecondToKmPerHour(0.0),
                DELTA);
    }

    @Test
    @DisplayName("Zero degrees converts to zero radians")
    void testZeroDegreesToRadians() {
        assertEquals(0.0, UnitConverter.degreesToRadians(0.0), DELTA);
    }

    @ParameterizedTest
    @CsvSource({
            "0.0, 0.0",
            "10.0, 36.0",
            "25.0, 90.0",
            "100.0, 360.0"
    })
    @DisplayName("Parameterized m/s to km/h conversion")
    void testMpsToKmhParameterized(double mps, double expectedKmh) {
        assertEquals(expectedKmh,
                UnitConverter.metersPerSecondToKmPerHour(mps), DELTA);
    }

    @ParameterizedTest
    @CsvSource({
            "0.0, 0.0",
            "90.0, 1.5708",
            "180.0, 3.1416",
            "360.0, 6.2832"
    })
    @DisplayName("Parameterized degrees to radians conversion")
    void testDegreesToRadiansParameterized(double degrees,
                                           double expectedRadians) {
        assertEquals(expectedRadians,
                UnitConverter.degreesToRadians(degrees), DELTA);
    }
}
