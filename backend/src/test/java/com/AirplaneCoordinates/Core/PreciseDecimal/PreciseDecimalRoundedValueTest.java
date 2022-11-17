package com.AirplaneCoordinates.Core.PreciseDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public final class PreciseDecimalRoundedValueTest {
    @Test
    public final void roundedValue() {
        assertEquals(
            PreciseDecimal.from(7).roundedValue().toString(),
            PreciseDecimal.from(7).toString()
        );
        assertEquals(
            PreciseDecimal.from(0).roundedValue().toString(),
            PreciseDecimal.from(0).toString()
        );
        assertEquals(
            PreciseDecimal.from("0").roundedValue().toString(),
            PreciseDecimal.from(0).toString()
        );
        assertEquals(
            PreciseDecimal.from(-3).roundedValue().toString(),
            PreciseDecimal.from(-3).toString()
        );
        assertEquals(
            PreciseDecimal.from("3.17").roundedValue().toString(),
            PreciseDecimal.from("3.17").toString()
        );
        assertEquals(
            PreciseDecimal.from("-24.287494").roundedValue().toString(),
            PreciseDecimal.from("-24.287494").toString()
        );
        assertEquals(
            PreciseDecimal.from("234.2938623478634786234782364726317836192371983719382739824623785647562349875634987563249875263498752").roundedValue().toString(),
            PreciseDecimal.from("234.293862347863478623478236472631783619237198371938273982462378564756234987563498756324987526").toString()
        );
        assertEquals(
            PreciseDecimal.from("111.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001").roundedValue().toString(),
            PreciseDecimal.from(111).toString()
        );
        assertEquals(
            PreciseDecimal.from("286.9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999992").roundedValue().toString(),
            PreciseDecimal.from(287).toString()
        );
        assertEquals(
            PreciseDecimal.from("-779.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000031").roundedValue().toString(),
            PreciseDecimal.from(-779).toString()
        );
        assertEquals(
            PreciseDecimal.from("2.220000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000022").roundedValue().toString(),
            PreciseDecimal.from("2.22").toString()
        );
        assertEquals(
            PreciseDecimal.from("2.200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000022").roundedValue().toString(),
            PreciseDecimal.from("2.2").toString()
        );
        assertEquals(
            PreciseDecimal.from("2.219999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999994").roundedValue().toString(),
            PreciseDecimal.from("2.22").toString()
        );
        assertEquals(
            PreciseDecimal.from("2.199999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999989").roundedValue().toString(),
            PreciseDecimal.from("2.2").toString()
        );
        assertEquals(
            PreciseDecimal.from("7.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004").roundedValue().toString(),
            PreciseDecimal.from(7).toString()
        );
        assertEquals(
            PreciseDecimal.from("0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000267779").roundedValue().toString(),
            PreciseDecimal.from(0).toString()
        );
        assertEquals(
            PreciseDecimal.from("0.0").roundedValue().toString(),
            PreciseDecimal.from(0).toString()
        );
        assertEquals(
            PreciseDecimal.from("128397194.12986127861287461248026874653874653876437865").roundedValue().toString(),
            PreciseDecimal.from("128397194.12986127861287461248026874653874653876437865").toString()
        );
        assertEquals(
            PreciseDecimal.from(
                "-0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000008925923158962873287395684462014298936503822914355030584503253124672887066979806660820263610315112846"
            ).roundedValue().toString(),
            PreciseDecimal.from(0).toString()
        );
        assertEquals(
            PreciseDecimal.from(
                "-0.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001785168730185325876330195087697043801180875908126664775654369943120098476233794486654297087559171119"
            ).roundedValue().toString(),
            PreciseDecimal.from(0).toString()
        );
        assertEquals(
            PreciseDecimal.from(
                "0.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002677770460680870630367848597990798145006512910656987836884117554320577928487771481205784002962934467"
            ).roundedValue().toString(),
            PreciseDecimal.from(0).toString()
        );
    }
}
