package com.AirplaneCoordinates.Core.PreciseDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PreciseDecimalComparisionOperationsTest {
    @Test
    public final void smallerThan() {
        assertEquals(
            PreciseDecimal.from(1).smallerThan(
                PreciseDecimal.from(0)
            ),
            false
        );
        assertEquals(
            PreciseDecimal.from("3.33332").smallerThan(
                PreciseDecimal.from("3.33332")
            ),
            false
        );
        assertEquals(
            PreciseDecimal.from("5.5555554").smallerThan(
                PreciseDecimal.from("5.5555555")
            ),
            true
        );
    }

    @Test
    public final void smallerOrEquals() {
        assertEquals(
            PreciseDecimal.from(1).smallerOrEquals(
                PreciseDecimal.from(0)
            ),
            false
        );
        assertEquals(
            PreciseDecimal.from("3.33332").smallerOrEquals(
                PreciseDecimal.from("3.33332")
            ),
            true
        );
        assertEquals(
            PreciseDecimal.from("5.5555554").smallerOrEquals(
                PreciseDecimal.from("5.5555555")
            ),
            true
        );
    }

    @Test
    public final void greaterThan() {
        assertEquals(
            PreciseDecimal.from(1).greaterThan(
                PreciseDecimal.from(0)
            ),
            true
        );
        assertEquals(
            PreciseDecimal.from("3.33332").greaterThan(
                PreciseDecimal.from("3.33332")
            ),
            false
        );
        assertEquals(
            PreciseDecimal.from("5.5555554").greaterThan(
                PreciseDecimal.from("5.5555555")
            ),
            false
        );
    }

    @Test
    public final void greaterOrEquals() {
        assertEquals(
            PreciseDecimal.from(1).greaterOrEquals(
                PreciseDecimal.from(0)
            ),
            true
        );
        assertEquals(
            PreciseDecimal.from("3.33332").greaterOrEquals(
                PreciseDecimal.from("3.33332")
            ),
            true
        );
        assertEquals(
            PreciseDecimal.from("5.5555554").greaterOrEquals(
                PreciseDecimal.from("5.5555555")
            ),
            false
        );
    }
}
