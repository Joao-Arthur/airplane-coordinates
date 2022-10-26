package com.AirplaneCoordinates.Core.PreciseDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PreciseDecimalTest {

    @Test
    @DisplayName("Should return the precise decimal from the values")
    public final void from() {
        assertEquals(
            new PreciseDecimal("28.37185").value,
            PreciseDecimal.from("28.37185").value
        );
        assertEquals(
            new PreciseDecimal("-1046.438682").value, 
            PreciseDecimal.from("-1046.438682").value
        );
        assertEquals(
            new PreciseDecimal("983").value,
            PreciseDecimal.from(983).value
        );
        assertEquals(
            new PreciseDecimal("-4").value,
            PreciseDecimal.from(-4).value
        );
    }
}
