package com.balistic;

/**
 * Utility class for unit conversions commonly used in ballistic calculations.
 */
public final class UnitConverter {

    private static final double KM_PER_HOUR_FACTOR = 3.6;
    private static final double FEET_PER_METER = 3.28084;
    private static final double POUNDS_PER_KG = 2.20462;

    private UnitConverter() {
        // Utility class, no instantiation
    }

    /**
     * Converts meters per second to kilometers per hour.
     *
     * @param mps speed in meters per second
     * @return speed in kilometers per hour
     */
    public static double metersPerSecondToKmPerHour(final double mps) {
        return mps * KM_PER_HOUR_FACTOR;
    }

    /**
     * Converts kilometers per hour to meters per second.
     *
     * @param kmh speed in kilometers per hour
     * @return speed in meters per second
     */
    public static double kmPerHourToMetersPerSecond(final double kmh) {
        return kmh / KM_PER_HOUR_FACTOR;
    }

    /**
     * Converts degrees to radians.
     *
     * @param degrees angle in degrees
     * @return angle in radians
     */
    public static double degreesToRadians(final double degrees) {
        return Math.toRadians(degrees);
    }

    /**
     * Converts radians to degrees.
     *
     * @param radians angle in radians
     * @return angle in degrees
     */
    public static double radiansToDegrees(final double radians) {
        return Math.toDegrees(radians);
    }

    /**
     * Converts meters to feet.
     *
     * @param meters distance in meters
     * @return distance in feet
     */
    public static double metersToFeet(final double meters) {
        return meters * FEET_PER_METER;
    }

    /**
     * Converts feet to meters.
     *
     * @param feet distance in feet
     * @return distance in meters
     */
    public static double feetToMeters(final double feet) {
        return feet / FEET_PER_METER;
    }

    /**
     * Converts kilograms to pounds.
     *
     * @param kg mass in kilograms
     * @return mass in pounds
     */
    public static double kgToPounds(final double kg) {
        return kg * POUNDS_PER_KG;
    }

    /**
     * Converts pounds to kilograms.
     *
     * @param pounds mass in pounds
     * @return mass in kilograms
     */
    public static double poundsToKg(final double pounds) {
        return pounds / POUNDS_PER_KG;
    }
}
