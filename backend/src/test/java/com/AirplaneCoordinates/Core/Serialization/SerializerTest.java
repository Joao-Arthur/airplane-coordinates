package com.AirplaneCoordinates.Core.Serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.List.CustomArrayList;

public final class SerializerTest {
    @Test
    public final void serializeInt() {
        assertEquals(
            Serializer.serialize(
                new CustomArrayList<Integer>()
                    .insert(-127)
                    .insert(483)
                    .insert(1298)
                    .insert(2347),
                0
            ),
            "-127,\n" +
            "483,\n" +
            "1298,\n" +
            "2347,\n"
        );
    }

    @Test
    public final void serializeString() {
        assertEquals(
            Serializer.serialize(
                new CustomArrayList<String>()
                    .insert("{ name: Paul McCartney, isAlive: true }")
                    .insert("{ name: Ringo Starr, isAlive: true }")
                    .insert("{ name: John Lennon, isAlive: false }")
                    .insert("{ name: George Harrison, isAlive: false }"),
                4
            ),
            "    { name: Paul McCartney, isAlive: true },\n" +
            "    { name: Ringo Starr, isAlive: true },\n" +
            "    { name: John Lennon, isAlive: false },\n" +
            "    { name: George Harrison, isAlive: false },\n"
        );
    }
}
