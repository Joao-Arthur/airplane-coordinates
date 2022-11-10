package com.AirplaneCoordinates.Core.Mathematics;

public interface Comparision<T> {
    public boolean greaterThan(final T other);
    public boolean greaterOrEquals(final T other);
    public boolean smallerThan(final T other);
    public boolean smallerOrEquals(final T other);
}
