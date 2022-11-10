package com.AirplaneCoordinates.Core.PreciseDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public final class PreciseDecimalComparisionTest {
    @Test
    public final void compareAsc() {
        final var items = new ArrayList<PreciseDecimal>();
        items.add(PreciseDecimal.from(10));
        items.add(PreciseDecimal.from(-2));
        items.add(PreciseDecimal.from(3));
        items.add(PreciseDecimal.from("46.5"));
        items.add(PreciseDecimal.from(3));

        final var actual = items
            .stream()
            .sorted(PreciseDecimal::compareAsc)
            .collect(Collectors.toList());

        final var expected = new ArrayList<PreciseDecimal>();
        expected.add(PreciseDecimal.from(-2));
        expected.add(PreciseDecimal.from(3));
        expected.add(PreciseDecimal.from(3));
        expected.add(PreciseDecimal.from(10));
        expected.add(PreciseDecimal.from("46.5"));

        assertEquals(
            Arrays.toString(actual.toArray()),
            Arrays.toString(expected.toArray())
        );
    }

    @Test
    public final void compareDesc() {
        final var items = new ArrayList<PreciseDecimal>();
        items.add(PreciseDecimal.from(10));
        items.add(PreciseDecimal.from(-2));
        items.add(PreciseDecimal.from(3));
        items.add(PreciseDecimal.from("46.5"));
        items.add(PreciseDecimal.from(3));

        final var actual = items
            .stream()
            .sorted(PreciseDecimal::compareDesc)
            .collect(Collectors.toList());

        final var expected = new ArrayList<PreciseDecimal>();
        expected.add(PreciseDecimal.from("46.5"));
        expected.add(PreciseDecimal.from(10));
        expected.add(PreciseDecimal.from(3));
        expected.add(PreciseDecimal.from(3));
        expected.add(PreciseDecimal.from(-2));

        assertEquals(
            Arrays.toString(actual.toArray()),
            Arrays.toString(expected.toArray())
        );
    }
}
