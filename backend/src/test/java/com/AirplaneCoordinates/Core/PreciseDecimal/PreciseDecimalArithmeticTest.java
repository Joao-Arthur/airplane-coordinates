package com.AirplaneCoordinates.Core.PreciseDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public final class PreciseDecimalArithmeticTest {
    @ParameterizedTest
    @CsvSource({
        "0, 0, 0",
        "4, 2, 6",
        "-1, 2, 1",
        "7, -3, 4",
        "3, -3, 0",
        "7, 0, 7",
        "-9.11, 0.11, -9",
        "-3, 0, -3",
        "-1.11, -1.11, -2.22",
        "0.5, 2.5, 3",
        "-1, -1.1, -2.1",
        "2.2, 3.33, 5.53",
    })
    public final void plus(
        final String a,
        final String b,
        final String result
    ) {
        assertEquals(
            PreciseDecimal
                .from(a)
                .plus(PreciseDecimal.from(b))
                .toString(),
            PreciseDecimal.from(result).toString()
        );
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0, 0",
        "6, 4, 2",
        "-1, 1, -2",
        "4, 4, 0",
        "-1, -1, 0",
        "0, 3, -3",
        "8.11, 0, 8.11",
        "7, 7, 0",
        "-4.44, -4.44, 0",
        "2.22, 1.11, 1.11",
        "-7.2, 0.2, -7.4",
        "-0.35, -3.35, 3",
    })
    public final void minus(final String a, final String b, final String result) {
        assertEquals(
            PreciseDecimal
                .from(a)
                .minus(PreciseDecimal.from(b))
                .toString(),
            PreciseDecimal.from(result).toString()
        );
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0, 0",
        "4, 2, 8",
        "-1, 2, -2",
        "4, 0, 0",
        "0, -1, 0",
        "0, 7, 0",
        "-3, 0, 0",
        "1, 2, 2",
        "0.3, 2, 0.6",
        "1.2, -4, -4.8",
        "-2.2, -2.2, 4.84",
    })
    public final void times(final String a, final String b, final String result) {
        assertEquals(
            PreciseDecimal
                .from(a)
                .times(PreciseDecimal.from(b))
                .toString(),
            PreciseDecimal.from(result).toString()
        );
    }

    @ParameterizedTest
    @CsvSource({
        "0, 4, 0",
        "0, -1, 0",
        "8, 4, 2",
        "9, -3, -3",
        "-21, 7, -3",
        "-2, -1, 2",
        "0, 0.4, 0",
        "0, -1.3, 0",
        "8, 0.5, 16",
        "-10, 0.8, -12.5",
        "4, -0.8, -5",
        "-2, -0.1, 20",
    })
    public final void divide(final String a, final String b, final String result) {
        assertEquals(
            PreciseDecimal
                .from(a)
                .divide(PreciseDecimal.from(b))
                .toString(),
            PreciseDecimal.from(result).toString()
        );
    }

    @ParameterizedTest
    @CsvSource({
        "-100.277, 360, -100.277",
        "360, 360, 0",
        "720.111, 360, 0.111",
        "0, 360, 0",
        "0, 2, 0",
        "2.22, 1.11, 0",
        "10, 2, 0",
    })
    public final void remainder(
        final String a,
        final String b,
        final String result
    ) {
        assertEquals(
            PreciseDecimal
                .from(a)
                .remainder(PreciseDecimal.from(b))
                .toString(),
            PreciseDecimal.from(result).toString()
        );
    }

    @Test
    public final void preciseCalculations() { 
        assertEquals(
            PreciseDecimal
                .from("0.1")
                .plus(PreciseDecimal.from("0.2"))
                .toString(),
            PreciseDecimal.from("0.3").toString()
        );
        assertEquals(
            PreciseDecimal
                .from("0.1234567890123456789012345678901")
                .plus(PreciseDecimal.from("0.1234321003123432100312343210036"))
                .toString(),
            PreciseDecimal.from("0.2468888893246888889324688888937").toString()
        );
        assertEquals(
            PreciseDecimal
                .from("0.8937593473846237864238745")
                .times(PreciseDecimal.from("0.6986723567253716276345786345"))
                .toString(),
            PreciseDecimal.from("0.62444494958254521156041254853945406639389341840937025").toString()
        );
        assertEquals(
            PreciseDecimal
                .from("0.6244449495825452115604125485")
                .divide(PreciseDecimal.from("0.8937593473846237864238745"))
                .toString(),
            PreciseDecimal.from("0.6986723567253716276345786344558560517332249999067102148534359217562859252534394065632348653940470129").toString()
        );
        assertEquals(
            PreciseDecimal
                .from(1)
                .plus(PreciseDecimal.from("0.0000000000000000000000000001"))
                .toString(),
            PreciseDecimal.from("1.0000000000000000000000000001").toString()
        );
        assertEquals(
            PreciseDecimal
                .from("1.0000000000000000000000000001")
                .minus(PreciseDecimal.from("0.0000000000000000000000000001"))
                .toString(),
            PreciseDecimal.from("1").toString()
        );
    }
}
