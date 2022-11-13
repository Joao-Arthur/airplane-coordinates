package com.AirplaneCoordinates.Core.Serialization;

import java.util.List;

public final class Serializer {
    public static final <T> String serialize(final List<T> items, final int padding) {
        return items
            .stream()
            .map(
                item -> " ".repeat(padding) + item + "," + '\n'
            )
            .reduce("", (a, b) -> a + b);
    }
}
