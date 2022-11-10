package com.AirplaneCoordinates.Core.PreciseDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public final class PreciseDecimalOperationsTest {
    @Test
    public final void opposite() {
        assertEquals(
            PreciseDecimal.from(1).opposite().toString(),
            PreciseDecimal.from(-1).toString()
        );
        assertEquals(
            PreciseDecimal.from(-2).opposite().toString(),
            PreciseDecimal.from(2).toString()
        );
        assertEquals(
            PreciseDecimal.from("0.33").opposite().toString(),
            PreciseDecimal.from("-0.33").toString()
        );
        assertEquals(
            PreciseDecimal.from("-2.22").opposite().toString(),
            PreciseDecimal.from("2.22").toString()
        );
        assertEquals(
            PreciseDecimal.from("487.732").opposite().toString(),
            PreciseDecimal.from("-487.732").toString()
        );
        assertEquals(
            PreciseDecimal.from("-8715.1347").opposite().toString(),
            PreciseDecimal.from("8715.1347").toString()
        );
        assertEquals(
            PreciseDecimal.from("1.414213562373095048801688724209698078569671875376948073176679737990732478462107038850387534327641573").opposite().toString(),
            PreciseDecimal.from("-1.414213562373095048801688724209698078569671875376948073176679737990732478462107038850387534327641573").toString()
        );
        assertEquals(
            PreciseDecimal.from("-983266465465.1092480947820932748923473854305686700340247236427845237842631093487230987520389571038972").opposite().toString(),
            PreciseDecimal.from("983266465465.1092480947820932748923473854305686700340247236427845237842631093487230987520389571038972").toString()
        );
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1",
        "1.25, 0.8",
        "2, 0.5",
        "4, 0.25",
        "5, 0.2",
        "8, 0.125",
        "10, 0.1",
    })
    public final void reverse(final String original, final String reversed) {
        assertEquals(
            PreciseDecimal.from(original).reverse().toString(),
            PreciseDecimal.from(reversed).toString()
        );
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1",
        "2, 4",
        "3, 9",
        "4, 16",
        "5, 25",
        "6, 36",
        "7, 49",
        "8, 64",
        "9, 81",
        "10, 100",
    })
    public final void perfectSquares(final int number, final int squared) {
        assertEquals(
            PreciseDecimal.from(number).square().toString(),
            PreciseDecimal.from(squared).toString()
        );
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1",
        "4, 2",
        "9, 3",
        "16, 4",
        "25, 5",
        "36, 6",
        "49, 7",
        "64, 8",
        "81, 9",
        "100, 10",
    })
    public final void perfectSqrts(final int number, final int squareRoot) {
        assertEquals(
            PreciseDecimal.from(number).sqrt().toString(),
            PreciseDecimal.from(squareRoot).toString()
        );
    }

    @Test
    public final void square() {
        assertEquals(
            PreciseDecimal.from("1.414213562373095048801688724209698078569671875376948073176679737990732478462107038850387534327641573").square().toString(),
            PreciseDecimal.from("2.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001").toString()
        );
        assertEquals(
            PreciseDecimal.from("1.732050807568877293527446341505872366942805253810380628055806979451933016908800037081146186757248576").square().toString(),
            PreciseDecimal.from("3.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001").toString()
        );
        assertEquals(
            PreciseDecimal.from("2.236067977499789696409173668731276235440618359611525724270897245410520925637804899414414408378782275").square().toString(),
            PreciseDecimal.from(5).toString()
        );
        assertEquals(
            PreciseDecimal.from("2.449489742783178098197284074705891391965947480656670128432692567250960377457315026539859433104640235").square().toString(),
            PreciseDecimal.from("6.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001").toString()
        );
        assertEquals(
            PreciseDecimal.from("2.645751311064590590501615753639260425710259183082450180368334459201068823230283627760392886474543611").square().toString(),
            PreciseDecimal.from("7.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002").toString()
        );
        assertEquals(
            PreciseDecimal.from("2.828427124746190097603377448419396157139343750753896146353359475981464956924214077700775068655283145").square().toString(),
            PreciseDecimal.from("7.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999997").toString()
        );
    }

    @Test
    public final void sqrt() {
        assertEquals(
            PreciseDecimal.from(2).sqrt().toString(),
            PreciseDecimal.from("1.414213562373095048801688724209698078569671875376948073176679737990732478462107038850387534327641573").toString()
        );
        assertEquals(
            PreciseDecimal.from("2.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001").sqrt().toString(),
            PreciseDecimal.from("1.414213562373095048801688724209698078569671875376948073176679737990732478462107038850387534327641573").toString()
        );
        assertEquals(
            PreciseDecimal.from(3).sqrt().toString(),
            PreciseDecimal.from("1.732050807568877293527446341505872366942805253810380628055806979451933016908800037081146186757248576").toString()
            );
        assertEquals(
            PreciseDecimal.from("3.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001").sqrt().toString(),
            PreciseDecimal.from("1.732050807568877293527446341505872366942805253810380628055806979451933016908800037081146186757248576").toString()
        );
        assertEquals(
            PreciseDecimal.from(5).sqrt().toString(),
            PreciseDecimal.from("2.236067977499789696409173668731276235440618359611525724270897245410520925637804899414414408378782275").toString()
        );
        assertEquals(
            PreciseDecimal.from(6).sqrt().toString(),
            PreciseDecimal.from("2.449489742783178098197284074705891391965947480656670128432692567250960377457315026539859433104640235").toString()
        );
        assertEquals(
            PreciseDecimal.from("6.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001").sqrt().toString(),
            PreciseDecimal.from("2.449489742783178098197284074705891391965947480656670128432692567250960377457315026539859433104640235").toString()
        );
        assertEquals(
            PreciseDecimal.from(7).sqrt().toString(),
            PreciseDecimal.from("2.645751311064590590501615753639260425710259183082450180368334459201068823230283627760392886474543611").toString()
        );
        assertEquals(
            PreciseDecimal.from("7.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002").sqrt().toString(),
            PreciseDecimal.from("2.645751311064590590501615753639260425710259183082450180368334459201068823230283627760392886474543611").toString()
        );
        assertEquals(
            PreciseDecimal.from(8).sqrt().toString(),
            PreciseDecimal.from("2.828427124746190097603377448419396157139343750753896146353359475981464956924214077700775068655283145").toString()
        );
        assertEquals(
            PreciseDecimal.from("7.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999997").sqrt().toString(),
            PreciseDecimal.from("2.828427124746190097603377448419396157139343750753896146353359475981464956924214077700775068655283145").toString()
        );
    }
}
