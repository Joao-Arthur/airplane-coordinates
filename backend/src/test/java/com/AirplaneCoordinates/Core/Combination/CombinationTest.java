package com.AirplaneCoordinates.Core.Combination;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public final class CombinationTest {
    @Test
    public final void toStringTest() {
        assertEquals(
            new Combination<Long>(1l, 2l).toString(),
            "{ a: 1, b: 2 }"
        );
    }

    @Test
    public final void getCombinations() {
        final var items = new ArrayList<Long>();
        items.add(10l);
        items.add(20l);
        items.add(30l);
        items.add(40l);

        final var actual = Combination.getCombinations(items);

        final var expected = new ArrayList<Combination<Long>>();
        expected.add(new Combination<Long>(10l, 20l));
        expected.add(new Combination<Long>(10l, 30l));
        expected.add(new Combination<Long>(10l, 40l));
        expected.add(new Combination<Long>(20l, 30l));
        expected.add(new Combination<Long>(20l, 40l));
        expected.add(new Combination<Long>(30l, 40l));

        assertEquals(
            Arrays.toString(actual.toArray()),
            Arrays.toString(expected.toArray())
        );
    }
}
