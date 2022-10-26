package com.AirplaneCoordinates.Core.PreciseDecimal;

public final class PreciseDecimal {
    public final String value;

    public PreciseDecimal(final String value) {
        this.value = value;
    }

    public static final PreciseDecimal from(final String value) {
        return new PreciseDecimal(value);
    }

    public static final PreciseDecimal from(final int value) {
        return new PreciseDecimal(String.valueOf(value));
    } 
}
