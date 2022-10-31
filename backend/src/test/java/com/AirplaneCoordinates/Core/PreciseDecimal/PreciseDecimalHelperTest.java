package com.AirplaneCoordinates.Core.PreciseDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public final class PreciseDecimalHelperTest {
    @Test
    public final void bigDecimalToString() {
        assertEquals(
            PreciseDecimalHelper.bigDecimalToString(new BigDecimal("0", PreciseDecimalConstants.MATH_CONTEXT)),
            "0"
        );
        assertEquals(
            PreciseDecimalHelper.bigDecimalToString(new BigDecimal("0.0", PreciseDecimalConstants.MATH_CONTEXT)),
            "0"
        );
        assertEquals(
            PreciseDecimalHelper.bigDecimalToString(new BigDecimal("128397194.12986127861287461248026874653874653876437865", PreciseDecimalConstants.MATH_CONTEXT)),
            "128397194.12986127861287461248026874653874653876437865"
        );
        assertEquals(
            PreciseDecimalHelper.bigDecimalToString(
                new BigDecimal(
                    "-0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000008925923158962873287395684462014298936503822914355030584503253124672887066979806660820263610315112846",
                    PreciseDecimalConstants.MATH_CONTEXT
                )
            ),
            "0"
        );
        assertEquals(
            PreciseDecimalHelper.bigDecimalToString(
                new BigDecimal(
                    "-0.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001785168730185325876330195087697043801180875908126664775654369943120098476233794486654297087559171119",
                    PreciseDecimalConstants.MATH_CONTEXT
                )
            ),
            "0"
        );
        assertEquals(
            PreciseDecimalHelper.bigDecimalToString(
                new BigDecimal(
                    "0.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002677770460680870630367848597990798145006512910656987836884117554320577928487771481205784002962934467",
                    PreciseDecimalConstants.MATH_CONTEXT
                )
            ),
            "0"
        );
    }
}
