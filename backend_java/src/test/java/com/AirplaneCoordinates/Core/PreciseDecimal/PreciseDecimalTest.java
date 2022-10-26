package com.AirplaneCoordinates.Core.PreciseDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public final class PreciseDecimalTest {
    @Test
    public final void from() {
        assertEquals(
            new PreciseDecimal("28.37185"),
            PreciseDecimal.from("28.37185")
        );
        assertEquals(
            new PreciseDecimal("-1046.438682"), 
            PreciseDecimal.from("-1046.438682")
        );
        assertEquals(
            new PreciseDecimal("983"),
            PreciseDecimal.from(983)
        );
        assertEquals(
            new PreciseDecimal("-4"),
            PreciseDecimal.from(-4)
        );
    }

    @Test
    public final void square() {
        assertEquals(
            PreciseDecimal.from(1).square().value,
            PreciseDecimal.from(1).value
        );
        assertEquals(
            PreciseDecimal.from("1.414213562373095048801688724209698078569671875376948073176679737990732478462107038850387534327641573").square().value,
            PreciseDecimal.from("2.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001").value
        );
        assertEquals(
            PreciseDecimal.from("1.732050807568877293527446341505872366942805253810380628055806979451933016908800037081146186757248576").square().value,
            PreciseDecimal.from("3.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001").value
        );
        assertEquals(
            PreciseDecimal.from("2").square(),
            PreciseDecimal.from("4")
        );
        assertEquals(
            PreciseDecimal.from("2.828427124746190097603377448419396157139343750753896146353359475981464956924214077700775068655283145").square().value,
            PreciseDecimal.from("7.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999997").value
        );


    }

    @Test
    public final void sqrt() {
        assertEquals(
            PreciseDecimal.from(1).sqrt().value,
            PreciseDecimal.from(1).value
        );
        assertEquals(
            PreciseDecimal.from("2").sqrt().value,
            PreciseDecimal.from("1.414213562373095048801688724209698078569671875376948073176679737990732478462107038850387534327641573").value
        );
        assertEquals(
            PreciseDecimal.from("3").sqrt().value,
            PreciseDecimal.from("1.732050807568877293527446341505872366942805253810380628055806979451933016908800037081146186757248576").value
        );
        assertEquals(
            PreciseDecimal.from(4).sqrt().value,
            PreciseDecimal.from(2).value
        );
        assertEquals(
            PreciseDecimal.from(8).sqrt().value,
            PreciseDecimal.from("2.828427124746190097603377448419396157139343750753896146353359475981464956924214077700775068655283145").value
        );
    }
}
