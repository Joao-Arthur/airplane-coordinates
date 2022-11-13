package com.AirplaneCoordinates.Core.Serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public final class SerializerTest {
    @Test
    public final void serializeInt() {
        final var intPoints = new ArrayList<Integer>();
        intPoints.add(-127);
        intPoints.add(483);
        intPoints.add(1298);
        intPoints.add(2347);

        assertEquals(
            Serializer.serialize(intPoints, 0),
            "-127,\n" +
            "483,\n" +
            "1298,\n" +
            "2347,\n"
        );
    }

    @Test
    public final void serializeString() {
        final var intPoints = new ArrayList<String>();
        intPoints.add("{ name: Paul McCartney, isAlive: true }");
        intPoints.add("{ name: Ringo Starr, isAlive: true }");
        intPoints.add("{ name: John Lennon, isAlive: false }");
        intPoints.add("{ name: George Harrison, isAlive: false }");

        assertEquals(
            Serializer.serialize(intPoints, 4),
            "    { name: Paul McCartney, isAlive: true },\n" +
            "    { name: Ringo Starr, isAlive: true },\n" +
            "    { name: John Lennon, isAlive: false },\n" +
            "    { name: George Harrison, isAlive: false },\n"
        );
    }
}
