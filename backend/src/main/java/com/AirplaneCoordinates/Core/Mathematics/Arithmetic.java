package com.AirplaneCoordinates.Core.Mathematics;

public interface Arithmetic<T> {
    public T plus(final T other);
    public T minus(final T other);
    public T times(final T other);
    public T divide(final T other);
    public T remainder(final T other);
}
