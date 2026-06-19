package com.balistic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit tests for App main class.
 */
class AppTest {

    @Test
    @DisplayName("App main runs without exception")
    void testMainRuns() {
        App.main(new String[]{});
    }

    @Test
    @DisplayName("App class can be referenced")
    void testAppClassExists() {
        assertNotNull(App.class);
    }

    @Test
    @DisplayName("Gravity constant is correct")
    void testGravityConstant() {
        org.junit.jupiter.api.Assertions.assertEquals(
                9.81, App.GRAVITY, 0.001);
    }
}
