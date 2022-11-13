package com.AirplaneCoordinates.Core.Combination;

import java.util.ArrayList;
import java.util.List;

public final class Combination<T> {
    public final T a;
    public final T b;

    public Combination(
        final T a,
        final T b
    ) {
        this.a = a;
        this.b = b;
    }

    @Override
    public final String toString() {
        return "{ " +
            "a: " + this.a + ", " +
            "b: " + this.b +
        " }";
    }

    public static final <T> List<Combination<T>> getCombinations(final List<T> items) {
        final var result = new ArrayList<Combination<T>>();
        for (int i = 0; i < items.size() - 1; i++)
            for (int j = i + 1; j < items.size(); j++)
                result.add(
                    new Combination<T>(
                        items.get(i),
                        items.get(j)
                    )
                );
        return result;
    }
}
