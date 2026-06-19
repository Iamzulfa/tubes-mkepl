package com.balistic;

/**
 * Provides ballistic calculation methods for projectile motion.
 * All calculations assume ideal conditions (no air resistance).
 */
public final class BallisticCalculator {

    private BallisticCalculator() {
        // Utility class, no instantiation
    }

    /**
     * Calculates the maximum height of a projectile.
     *
     * @param velocity     initial velocity in m/s
     * @param angleDegrees launch angle in degrees
     * @return maximum height in meters
     * @throws IllegalArgumentException if velocity is negative or angle is out of range
     */
    public static double calculateMaxHeight(final double velocity,
                                            final double angleDegrees) {
        validateInputs(velocity, angleDegrees);
        double angleRad = UnitConverter.degreesToRadians(angleDegrees);
        double sinAngle = Math.sin(angleRad);
        return (velocity * velocity * sinAngle * sinAngle)
                / (2.0 * App.GRAVITY);
    }

    /**
     * Calculates the horizontal range of a projectile.
     *
     * @param velocity     initial velocity in m/s
     * @param angleDegrees launch angle in degrees
     * @return horizontal range in meters
     * @throws IllegalArgumentException if velocity is negative or angle is out of range
     */
    public static double calculateRange(final double velocity,
                                        final double angleDegrees) {
        validateInputs(velocity, angleDegrees);
        double angleRad = UnitConverter.degreesToRadians(angleDegrees);
        return (velocity * velocity * Math.sin(2.0 * angleRad))
                / App.GRAVITY;
    }

    /**
     * Calculates the total time of flight of a projectile.
     *
     * @param velocity     initial velocity in m/s
     * @param angleDegrees launch angle in degrees
     * @return time of flight in seconds
     * @throws IllegalArgumentException if velocity is negative or angle is out of range
     */
    public static double calculateTimeOfFlight(final double velocity,
                                               final double angleDegrees) {
        validateInputs(velocity, angleDegrees);
        double angleRad = UnitConverter.degreesToRadians(angleDegrees);
        return (2.0 * velocity * Math.sin(angleRad)) / App.GRAVITY;
    }

    /**
     * Calculates the horizontal position at a given time.
     *
     * @param velocity     initial velocity in m/s
     * @param angleDegrees launch angle in degrees
     * @param time         elapsed time in seconds
     * @return horizontal position in meters
     */
    public static double calculateX(final double velocity,
                                    final double angleDegrees,
                                    final double time) {
        double angleRad = UnitConverter.degreesToRadians(angleDegrees);
        return velocity * Math.cos(angleRad) * time;
    }

    /**
     * Calculates the vertical position at a given time.
     *
     * @param velocity     initial velocity in m/s
     * @param angleDegrees launch angle in degrees
     * @param time         elapsed time in seconds
     * @return vertical position in meters
     */
    public static double calculateY(final double velocity,
                                    final double angleDegrees,
                                    final double time) {
        double angleRad = UnitConverter.degreesToRadians(angleDegrees);
        return velocity * Math.sin(angleRad) * time
                - 0.5 * App.GRAVITY * time * time;
    }

    /**
     * Finds the optimal launch angle for maximum range.
     *
     * @return optimal angle in degrees (always 45 for flat terrain)
     */
    public static double getOptimalAngle() {
        return 45.0;
    }

    /**
     * Validates input parameters.
     *
     * @param velocity     initial velocity
     * @param angleDegrees launch angle
     */
    private static void validateInputs(final double velocity,
                                       final double angleDegrees) {
        if (velocity < 0) {
            throw new IllegalArgumentException(
                    "Velocity cannot be negative: " + velocity);
        }
        if (angleDegrees < 0 || angleDegrees > 90) {
            throw new IllegalArgumentException(
                    "Angle must be between 0 and 90 degrees: " + angleDegrees);
        }
    }
}
