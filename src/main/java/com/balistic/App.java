package com.balistic;

/**
 * Main entry point for the Ballistic Calculator application.
 * Demonstrates projectile motion calculations.
 */
public final class App {

    /** Gravity constant in m/s^2. */
    public static final double GRAVITY = 9.81;

    private App() {
        // Utility class, no instantiation
    }

    /**
     * Main method that runs a demo calculation.
     *
     * @param args command line arguments (not used)
     */
    public static void main(final String[] args) {
        System.out.println("=== Ballistic Calculator ===");
        System.out.println();

        // Demo: launch a projectile at 45 degrees, 50 m/s
        double velocity = 50.0;
        double angleDegrees = 45.0;

        Projectile projectile = new Projectile(velocity, angleDegrees);

        System.out.println("Initial velocity: " + velocity + " m/s");
        System.out.println("Launch angle: " + angleDegrees + " degrees");
        System.out.println();

        System.out.println("--- Results ---");
        System.out.printf("Max height: %.2f m%n",
                BallisticCalculator.calculateMaxHeight(velocity, angleDegrees));
        System.out.printf("Range: %.2f m%n",
                BallisticCalculator.calculateRange(velocity, angleDegrees));
        System.out.printf("Time of flight: %.2f s%n",
                BallisticCalculator.calculateTimeOfFlight(velocity, angleDegrees));
        System.out.println();

        System.out.println("--- Trajectory Points ---");
        double[] xCoords = projectile.getTrajectoryX(10);
        double[] yCoords = projectile.getTrajectoryY(10);
        for (int i = 0; i < xCoords.length; i++) {
            System.out.printf("t=%.2f -> x=%.2f m, y=%.2f m%n",
                    i * (BallisticCalculator.calculateTimeOfFlight(
                            velocity, angleDegrees) / 10.0),
                    xCoords[i], yCoords[i]);
        }

        System.out.println();
        System.out.println("--- Unit Conversions ---");
        System.out.printf("50 m/s = %.2f km/h%n",
                UnitConverter.metersPerSecondToKmPerHour(50.0));
        System.out.printf("45 degrees = %.4f radians%n",
                UnitConverter.degreesToRadians(45.0));
    }
}
