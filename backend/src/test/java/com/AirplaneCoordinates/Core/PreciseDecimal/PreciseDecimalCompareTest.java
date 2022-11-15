package com.AirplaneCoordinates.Core.PreciseDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.List.CustomArrayList;

public final class PreciseDecimalCompareTest {
    @Test
    public final void compareAsc() {
        assertEquals(
            Arrays.toString(
                new CustomArrayList<PreciseDecimal>()
                    .insert(PreciseDecimal.from(10))
                    .insert(PreciseDecimal.from(-2))
                    .insert(PreciseDecimal.from(3))
                    .insert(PreciseDecimal.from("46.5"))
                    .insert(PreciseDecimal.from(3))
                    .stream()
                    .sorted(PreciseDecimal::compareAsc)
                    .collect(Collectors.toList())
                    .toArray()
            ),
            Arrays.toString(
                new CustomArrayList<PreciseDecimal>()
                    .insert(PreciseDecimal.from(-2))
                    .insert(PreciseDecimal.from(3))
                    .insert(PreciseDecimal.from(3))
                    .insert(PreciseDecimal.from(10))
                    .insert(PreciseDecimal.from("46.5"))
                    .toArray()
            )
        );
    }

    @Test
    public final void compareDesc() {
        assertEquals(
            Arrays.toString(
                new CustomArrayList<PreciseDecimal>()
                    .insert(PreciseDecimal.from(10))
                    .insert(PreciseDecimal.from(-2))
                    .insert(PreciseDecimal.from(3))
                    .insert(PreciseDecimal.from("46.5"))
                    .insert(PreciseDecimal.from(3))
                    .stream()
                    .sorted(PreciseDecimal::compareDesc)
                    .collect(Collectors.toList())
                    .toArray()
            ),
            Arrays.toString(
                new CustomArrayList<PreciseDecimal>()
                    .insert(PreciseDecimal.from("46.5"))
                    .insert(PreciseDecimal.from(10))
                    .insert(PreciseDecimal.from(3))
                    .insert(PreciseDecimal.from(3))
                    .insert(PreciseDecimal.from(-2))
                    .toArray()
                )
        );
    }
}
