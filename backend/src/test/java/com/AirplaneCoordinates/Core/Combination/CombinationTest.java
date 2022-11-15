package com.AirplaneCoordinates.Core.Combination;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.List.CustomArrayList;

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
        assertEquals(
            Arrays.toString(
                Combination.getCombinations(
                    new CustomArrayList<Long>()
                        .insert(10l)
                        .insert(20l)
                        .insert(30l)
                        .insert(40l)
                    ).toArray()
                ),
            Arrays.toString(
                new CustomArrayList<Combination<Long>>()
                    .insert(new Combination<Long>(10l, 20l))
                    .insert(new Combination<Long>(10l, 30l))
                    .insert(new Combination<Long>(10l, 40l))
                    .insert(new Combination<Long>(20l, 30l))
                    .insert(new Combination<Long>(20l, 40l))
                    .insert(new Combination<Long>(30l, 40l))
                    .toArray()
            )
        );
    }
}
