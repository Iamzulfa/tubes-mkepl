package com.balistic;

/**
 * Represents a projectile with initial velocity and launch angle.
 * Provides methods to compute trajectory points.
 */
public class Projectile {

    private final double velocity;
    private final double angleDegrees;

    /**
     * Creates a new Projectile.
     *
     * @param velocity     initial velocity in m/s
     * @param angleDegrees launch angle in degrees
     */
    public Projectile(final double velocity, final double angleDegrees) {
        if (velocity < 0) {
            throw new IllegalArgumentException(
                    "Velocity cannot be negative: " + velocity);
        }
        if (angleDegrees < 0 || angleDegrees > 90) {
            throw new IllegalArgumentException(
                    "Angle must be between 0 and 90 degrees: " + angleDegrees);
        }
        this.velocity = velocity;
        this.angleDegrees = angleDegrees;
    }

    /**
     * Gets the initial velocity.
     *
     * @return velocity in m/s
     */
    public double getVelocity() {
        return velocity;
    }

    /**
     * Gets the launch angle.
     *
     * @return angle in degrees
     */
    public double getAngleDegrees() {
        return angleDegrees;
    }

    /**
     * Calculates the maximum height of this projectile.
     *
     * @return maximum height in meters
     */
    public double getMaxHeight() {
        return BallisticCalculator.calculateMaxHeight(velocity, angleDegrees);
    }

    /**
     * Calculates the horizontal range of this projectile.
     *
     * @return range in meters
     */
    public double getRange() {
        return BallisticCalculator.calculateRange(velocity, angleDegrees);
    }

    /**
     * Calculates the time of flight of this projectile.
     *
     * @return time of flight in seconds
     */
    public double getTimeOfFlight() {
        return BallisticCalculator.calculateTimeOfFlight(velocity, angleDegrees);
    }

    /**
     * Generates an array of horizontal positions along the trajectory.
     *
     * @param points number of points to generate
     * @return array of x-coordinates
     */
    public double[] getTrajectoryX(final int points) {
        if (points < 2) {
            throw new IllegalArgumentException(
                    "Number of points must be at least 2: " + points);
        }
        double totalTime = getTimeOfFlight();
        double[] trajectory = new double[points];
        for (int i = 0; i < points; i++) {
            double time = totalTime * i / (points - 1);
            trajectory[i] = BallisticCalculator.calculateX(
                    velocity, angleDegrees, time);
        }
        return trajectory;
    }

    /**
     * Generates an array of vertical positions along the trajectory.
     *
     * @param points number of points to generate
     * @return array of y-coordinates
     */
    public double[] getTrajectoryY(final int points) {
        if (points < 2) {
            throw new IllegalArgumentException(
                    "Number of points must be at least 2: " + points);
        }
        double totalTime = getTimeOfFlight();
        double[] trajectory = new double[points];
        for (int i = 0; i < points; i++) {
            double time = totalTime * i / (points - 1);
            trajectory[i] = BallisticCalculator.calculateY(
                    velocity, angleDegrees, time);
        }
        return trajectory;
    }

    @Override
    public final String toString() {
        return String.format(
                "Projectile{velocity=%.1f m/s, angle=%.1f deg, "
                        + "maxHeight=%.2f m, range=%.2f m}",
                velocity, angleDegrees, getMaxHeight(), getRange());
    }
}
