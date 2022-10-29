package com.AirplaneCoordinates.Core.PreciseDecimal;

import java.math.BigDecimal;

public final class PreciseDecimalHelper {
    public static final String bigDecimalToString(final BigDecimal value) {
        final var plainValue = value.stripTrailingZeros().toPlainString();
        if (!plainValue.contains("."))
            return plainValue;
        final var arr = plainValue.split("\\.");
        final var integerPart = arr[0];
        final var decimalPart = arr[1];
        if(decimalPart.length() <= PreciseDecimalConstants.PRECISION)
            return plainValue;
        final var finalValue =  integerPart + "." + decimalPart.substring(0, PreciseDecimalConstants.PRECISION);
        return new BigDecimal(finalValue).stripTrailingZeros().toPlainString();
    }

    public static final String bigDecimalToRoundedString(final BigDecimal value) {
        final var plainValue = value.stripTrailingZeros().toPlainString();
        if (!plainValue.contains("."))
            return plainValue;
        final var arr = plainValue.split("\\.");
        final var integerPart = arr[0];
        final var decimalPart = arr[1];
        if(decimalPart.length() <= PreciseDecimalConstants.ROUNDING_PRECISION)
            return plainValue;
        final var finalValue =  integerPart + "." + decimalPart.substring(0, PreciseDecimalConstants.ROUNDING_PRECISION);
        return new BigDecimal(finalValue).stripTrailingZeros().toPlainString();
    }
}
