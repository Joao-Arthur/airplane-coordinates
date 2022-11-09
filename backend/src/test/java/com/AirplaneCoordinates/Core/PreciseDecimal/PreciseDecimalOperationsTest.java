package com.AirplaneCoordinates.Core.PreciseDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public final class PreciseDecimalOperationsTest {
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
    public final void sum(final String a, final String b, final String result) {
        assertEquals(
            PreciseDecimalOperations.sum(
                PreciseDecimal.from(a),
                PreciseDecimal.from(b)
            ).toString(),
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
    public final void sub(final String a, final String b, final String result) {
        assertEquals(
            PreciseDecimalOperations.sub(
                PreciseDecimal.from(a),
                PreciseDecimal.from(b)
            ).toString(),
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
    public final void mul(final String a, final String b, final String result) {
        assertEquals(
            PreciseDecimalOperations.mul(
                PreciseDecimal.from(a),
                PreciseDecimal.from(b)
            ).toString(),
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
    public final void div(final String a, final String b, final String result) {
        assertEquals(
            PreciseDecimalOperations.div(
                PreciseDecimal.from(a),
                PreciseDecimal.from(b)
            ).toString(),
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
    public final void rem(
        final String a,
        final String b,
        final String result
    ) {
        assertEquals(
            PreciseDecimalOperations.rem(
                PreciseDecimal.from(a),
                PreciseDecimal.from(b)
            ).toString(),
            PreciseDecimal.from(result).toString()
        );
    }

    @Test
    public final void preciseCalculations() { 
        assertEquals(
            PreciseDecimalOperations.sum(
                PreciseDecimal.from("0.1"),
                PreciseDecimal.from("0.2")
            ).toString(),
            PreciseDecimal.from("0.3").toString()
        );
        assertEquals(
            PreciseDecimalOperations.sum(
                PreciseDecimal.from("0.1234567890123456789012345678901"),
                PreciseDecimal.from("0.1234321003123432100312343210036")
            ).toString(),
            PreciseDecimal.from("0.2468888893246888889324688888937").toString()
        );
        assertEquals(
            PreciseDecimalOperations.mul(
                PreciseDecimal.from("0.8937593473846237864238745"),
                PreciseDecimal.from("0.6986723567253716276345786345")
            ).toString(),
            PreciseDecimal.from("0.62444494958254521156041254853945406639389341840937025").toString()
        );
        assertEquals(
            PreciseDecimalOperations.div(
                PreciseDecimal.from("0.6244449495825452115604125485"),
                PreciseDecimal.from("0.8937593473846237864238745")
            ).toString(),
            PreciseDecimal.from("0.6986723567253716276345786344558560517332249999067102148534359217562859252534394065632348653940470129").toString()
        );
        assertEquals(
            PreciseDecimalOperations.sum(
                PreciseDecimal.from(1),
                PreciseDecimal.from("0.0000000000000000000000000001")
            ).toString(),
            PreciseDecimal.from("1.0000000000000000000000000001").toString()
        );
        assertEquals(
            PreciseDecimalOperations.sub(
                PreciseDecimal.from("1.0000000000000000000000000001"),
                PreciseDecimal.from("0.0000000000000000000000000001")
            ).toString(),
            PreciseDecimal.from("1").toString()
        );
    }

    @Test
    public final void atan() {
        assertEquals(
            PreciseDecimalOperations.atan(
                PreciseDecimal.from(1),
                PreciseDecimal.from(1)
            ).toString(),
            PreciseDecimal.from("0.785398163397448309615660845819875721049292349843776455243736148076954101571552249657008706335529267").toString()
        );
        assertEquals(
            PreciseDecimalOperations.atan(
                PreciseDecimal.from(3),
                PreciseDecimal.from(1)
            ).toString(),
            PreciseDecimal.from("1.24904577239825442582991707728109012307782940412989671905466923679715196573729395495760899032041716").toString()
        );
        assertEquals(
            PreciseDecimalOperations.atan(
                PreciseDecimal.from(4),
                PreciseDecimal.from(2)
            ).toString(),
            PreciseDecimal.from("1.107148717794090503017065460178537040070047645401432646676539207433710338977362794013417128686170641").toString()
        );
        assertEquals(
            PreciseDecimalOperations.atan(
                PreciseDecimal.from(8),
                PreciseDecimal.from(3)
            ).toString(),
            PreciseDecimal.from("1.212025656524324398835401627713290942321609043806637130847073429399205018921975170570753003401633161").toString()
        );
        assertEquals(
            PreciseDecimalOperations.atan(
                PreciseDecimal.from(1),
                PreciseDecimal.from(2)
            ).toString(),
            PreciseDecimal.from("0.4636476090008061162142562314612144020285370542861202638109330887201978641657417053006002839848878926").toString()
        );
        assertEquals(
            PreciseDecimalOperations.atan(
                PreciseDecimal.from(-8),
                PreciseDecimal.from(3)
            ).toString(),
            PreciseDecimal.from("-1.212025656524324398835401627713290942321609043806637130847073429399205018921975170570753003401633161").toString()
        );
    }

    @Test
    public final void smaller() {
        assertEquals(
            PreciseDecimalOperations.smaller(
                PreciseDecimal.from(1),
                PreciseDecimal.from(0)
            ),
            true
        );
        assertEquals(
            PreciseDecimalOperations.smaller(
                PreciseDecimal.from("3.33332"),
                PreciseDecimal.from("3.33332")
            ),
            false
        );
        assertEquals(
            PreciseDecimalOperations.smaller(
                PreciseDecimal.from("5.5555554"),
                PreciseDecimal.from("5.5555555")
            ),
            false
        );
    }

    @Test
    public final void smallerOrEquals() {
        assertEquals(
            PreciseDecimalOperations.smallerOrEquals(
                PreciseDecimal.from(1),
                PreciseDecimal.from(0)
            ),
            false
        );
        assertEquals(
            PreciseDecimalOperations.smallerOrEquals(
                PreciseDecimal.from("3.33332"),
                PreciseDecimal.from("3.33332")
            ),
            true
        );
        assertEquals(
            PreciseDecimalOperations.smallerOrEquals(
                PreciseDecimal.from("5.5555554"),
                PreciseDecimal.from("5.5555555")
            ),
            true
        );
    }

    @Test
    public final void greater() {
        assertEquals(
            PreciseDecimalOperations.greater(
                PreciseDecimal.from(1),
                PreciseDecimal.from(0)
            ),
            true
        );
        assertEquals(
            PreciseDecimalOperations.greater(
                PreciseDecimal.from("3.33332"),
                PreciseDecimal.from("3.33332")
            ),
            false
        );
        assertEquals(
            PreciseDecimalOperations.greater(
                PreciseDecimal.from("5.5555554"),
                PreciseDecimal.from("5.5555555")
            ),
            false
        );
    }
}
