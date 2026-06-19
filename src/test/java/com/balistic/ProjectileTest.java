package com.balistic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit tests for Projectile.
 */
class ProjectileTest {

    private static final double DELTA = 0.01;

    @Test
    @DisplayName("Create projectile with valid parameters")
    void testCreateProjectile() {
        Projectile p = new Projectile(50.0, 45.0);
        assertNotNull(p);
        assertEquals(50.0, p.getVelocity(), DELTA);
        assertEquals(45.0, p.getAngleDegrees(), DELTA);
    }

    @Test
    @DisplayName("Negative velocity throws exception")
    void testNegativeVelocity() {
        assertThrows(IllegalArgumentException.class, () ->
                new Projectile(-10.0, 45.0));
    }

    @Test
    @DisplayName("Angle above 90 throws exception")
    void testAngleAbove90() {
        assertThrows(IllegalArgumentException.class, () ->
                new Projectile(50.0, 95.0));
    }

    @Test
    @DisplayName("Negative angle throws exception")
    void testNegativeAngle() {
        assertThrows(IllegalArgumentException.class, () ->
                new Projectile(50.0, -5.0));
    }

    @Test
    @DisplayName("Max height matches calculator")
    void testGetMaxHeight() {
        Projectile p = new Projectile(50.0, 45.0);
        assertEquals(63.71, p.getMaxHeight(), DELTA);
    }

    @Test
    @DisplayName("Range matches calculator")
    void testGetRange() {
        Projectile p = new Projectile(50.0, 45.0);
        assertEquals(254.84, p.getRange(), DELTA);
    }

    @Test
    @DisplayName("Time of flight matches calculator")
    void testGetTimeOfFlight() {
        Projectile p = new Projectile(50.0, 45.0);
        assertEquals(7.21, p.getTimeOfFlight(), DELTA);
    }

    @Test
    @DisplayName("Trajectory X has correct number of points")
    void testTrajectoryXPoints() {
        Projectile p = new Projectile(50.0, 45.0);
        double[] xCoords = p.getTrajectoryX(10);
        assertEquals(10, xCoords.length);
    }

    @Test
    @DisplayName("Trajectory Y has correct number of points")
    void testTrajectoryYPoints() {
        Projectile p = new Projectile(50.0, 45.0);
        double[] yCoords = p.getTrajectoryY(10);
        assertEquals(10, yCoords.length);
    }

    @Test
    @DisplayName("Trajectory X starts at 0")
    void testTrajectoryXStartsAtZero() {
        Projectile p = new Projectile(50.0, 45.0);
        double[] xCoords = p.getTrajectoryX(10);
        assertEquals(0.0, xCoords[0], DELTA);
    }

    @Test
    @DisplayName("Trajectory Y starts at 0")
    void testTrajectoryYStartsAtZero() {
        Projectile p = new Projectile(50.0, 45.0);
        double[] yCoords = p.getTrajectoryY(10);
        assertEquals(0.0, yCoords[0], DELTA);
    }

    @Test
    @DisplayName("Trajectory Y ends near 0")
    void testTrajectoryYEndsNearZero() {
        Projectile p = new Projectile(50.0, 45.0);
        double[] yCoords = p.getTrajectoryY(10);
        assertEquals(0.0, yCoords[yCoords.length - 1], DELTA);
    }

    @Test
    @DisplayName("Less than 2 points throws exception for X")
    void testTrajectoryXLessThan2Points() {
        Projectile p = new Projectile(50.0, 45.0);
        assertThrows(IllegalArgumentException.class, () ->
                p.getTrajectoryX(1));
    }

    @Test
    @DisplayName("Less than 2 points throws exception for Y")
    void testTrajectoryYLessThan2Points() {
        Projectile p = new Projectile(50.0, 45.0);
        assertThrows(IllegalArgumentException.class, () ->
                p.getTrajectoryY(1));
    }

    @Test
    @DisplayName("toString contains expected info")
    void testToString() {
        Projectile p = new Projectile(50.0, 45.0);
        String str = p.toString();
        assertNotNull(str);
        assertEquals(true, str.contains("50.0"));
        assertEquals(true, str.contains("45.0"));
    }
}
