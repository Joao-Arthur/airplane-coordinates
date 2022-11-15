package com.AirplaneCoordinates.Plain.Core.Mechanics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Mechanics.Vector;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class VectorPlainTest {
    @Test
    public final void toObject() {
        assertEquals(
            new VectorPlain("1.11", "2.22").toObject().toString(),
            Vector.from(
                PreciseDecimal.from("1.11"),
                PreciseDecimal.from("2.22")
            ).toString()
        );
    }

    @Test
    public final void fromObject() {
        assertEquals(
            VectorPlain.fromObject(
                Vector.from(
                    PreciseDecimal.from("1.11"),
                    PreciseDecimal.from("2.22")
                )
            ).toObject().toString(),
            Vector.from(
                PreciseDecimal.from("1.11"),
                PreciseDecimal.from("2.22")
            ).toString()
        );
    }
}
