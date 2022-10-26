package com.AirplaneCoordinates.Core.PreciseDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public final class PreciseDecimalOperationsTest {
    @Test
    public final void sum() {
        assertEquals(
            PreciseDecimalOperations.sum(PreciseDecimal.from(4), PreciseDecimal.from(2)).value,
            PreciseDecimal.from(6).value
        );
        assertEquals(
            PreciseDecimalOperations.sum(PreciseDecimal.from(-1), PreciseDecimal.from(2)).value,
            PreciseDecimal.from(1).value
        );
        assertEquals(
            PreciseDecimalOperations.sum(PreciseDecimal.from(7), PreciseDecimal.from(-3)).value,
            PreciseDecimal.from(4).value
        );
        assertEquals(
            PreciseDecimalOperations.sum(PreciseDecimal.from(3), PreciseDecimal.from(-3)).value,
            PreciseDecimal.from(0).value
        );
        assertEquals(
            PreciseDecimalOperations.sum(PreciseDecimal.from(7), PreciseDecimal.from(0)).value,
            PreciseDecimal.from(7).value
        );
    }

    @Test
    public final void sub() {
        assertEquals(
            PreciseDecimalOperations.sub(PreciseDecimal.from(6), PreciseDecimal.from(4)).value,
            PreciseDecimal.from(2).value
        );
        assertEquals(
            PreciseDecimalOperations.sub(PreciseDecimal.from(-1), PreciseDecimal.from(1)).value,
            PreciseDecimal.from(-2).value
        );
        assertEquals(
            PreciseDecimalOperations.sub(PreciseDecimal.from(4), PreciseDecimal.from(4)).value,
            PreciseDecimal.from(0).value
        );
        assertEquals(
            PreciseDecimalOperations.sub(PreciseDecimal.from(-1), PreciseDecimal.from(-1)).value,
            PreciseDecimal.from(0).value
        );
        assertEquals(
            PreciseDecimalOperations.sub(PreciseDecimal.from(0), PreciseDecimal.from(3)).value,
            PreciseDecimal.from(-3).value
        );
        assertEquals(
            PreciseDecimalOperations.sub(PreciseDecimal.from(7), PreciseDecimal.from(7)).value,
            PreciseDecimal.from(0).value
        );
        assertEquals(
            PreciseDecimalOperations.sub(PreciseDecimal.from(3), PreciseDecimal.from(3)).value,
            PreciseDecimal.from(0).value
        );
    }

    @Test
    public final void mul() {
        assertEquals(
            PreciseDecimalOperations.mul(PreciseDecimal.from(4), PreciseDecimal.from(2)).value,
            PreciseDecimal.from(8).value
        );
        assertEquals(
            PreciseDecimalOperations.mul(PreciseDecimal.from(-1), PreciseDecimal.from(2)).value,
            PreciseDecimal.from(-2).value
        );
        assertEquals(
            PreciseDecimalOperations.mul(PreciseDecimal.from(4), PreciseDecimal.from(0)).value,
            PreciseDecimal.from(0).value
        );
        assertEquals(
            PreciseDecimalOperations.mul(PreciseDecimal.from(-1), PreciseDecimal.from(0)).value,
            PreciseDecimal.from(0).value
        );
        assertEquals(
            PreciseDecimalOperations.mul(PreciseDecimal.from(7), PreciseDecimal.from(-3)).value,
            PreciseDecimal.from(-21).value
        );
        assertEquals(
            PreciseDecimalOperations.mul(PreciseDecimal.from(3), PreciseDecimal.from(-3)).value,
            PreciseDecimal.from(-9).value
        );
        assertEquals(
            PreciseDecimalOperations.mul(PreciseDecimal.from(7), PreciseDecimal.from(0)).value,
            PreciseDecimal.from(0).value
        );
        assertEquals(
            PreciseDecimalOperations.mul(PreciseDecimal.from(3), PreciseDecimal.from(0)).value,
            PreciseDecimal.from(0).value
        );
    }

    @Test
    public final void div() {
        assertEquals(
            PreciseDecimalOperations.div(PreciseDecimal.from(8), PreciseDecimal.from(4)).value,
            PreciseDecimal.from(2).value
        );
        assertEquals(
            PreciseDecimalOperations.div(PreciseDecimal.from(-2), PreciseDecimal.from(-1)).value,
            PreciseDecimal.from(2).value
        );
        assertEquals(
            PreciseDecimalOperations.div(PreciseDecimal.from(0), PreciseDecimal.from(4)).value,
            PreciseDecimal.from(0).value
        );
        assertEquals(
            PreciseDecimalOperations.div(PreciseDecimal.from(0), PreciseDecimal.from(-1)).value,
            PreciseDecimal.from(0).value
        );
        assertEquals(
            PreciseDecimalOperations.div(PreciseDecimal.from(-21), PreciseDecimal.from(7)).value,
            PreciseDecimal.from(-3).value
        );
        assertEquals(
            PreciseDecimalOperations.div(PreciseDecimal.from(-9), PreciseDecimal.from(3)).value,
            PreciseDecimal.from(-3).value
        );
        assertEquals(
            PreciseDecimalOperations.div(PreciseDecimal.from(0), PreciseDecimal.from(7)).value,
            PreciseDecimal.from(0).value
        );
        assertEquals(
            PreciseDecimalOperations.div(PreciseDecimal.from(0), PreciseDecimal.from(3)).value,
            PreciseDecimal.from(0).value
        );
    }

    @Test
    public final void rem() {
        assertEquals(
            PreciseDecimalOperations.rem(PreciseDecimal.from("-100.277"), PreciseDecimal.from(360)).value,
            PreciseDecimal.from("-100.277").value
        );
        assertEquals(
            PreciseDecimalOperations.rem(PreciseDecimal.from(360), PreciseDecimal.from(360)).value,
            PreciseDecimal.from(0).value
        );
        assertEquals(
            PreciseDecimalOperations.rem(PreciseDecimal.from("720.111"), PreciseDecimal.from(360)).value,
            PreciseDecimal.from("0.111").value
        );
        assertEquals(
            PreciseDecimalOperations.rem(PreciseDecimal.from(0), PreciseDecimal.from(360)).value,
            PreciseDecimal.from(0).value
        );
    }

    @Test
    public final void preciseCalculations() { 
        assertEquals(
            PreciseDecimalOperations.sum(
                PreciseDecimal.from("0.1"),
                PreciseDecimal.from("0.2")
            ).value,
            PreciseDecimal.from("0.3").value
        );
        assertEquals(
            PreciseDecimalOperations.sum(
                PreciseDecimal.from("0.1234567890123456789012345678901"),
                PreciseDecimal.from("0.1234321003123432100312343210036")
            ).value,
            PreciseDecimal.from("0.2468888893246888889324688888937").value
        );
        assertEquals(
            PreciseDecimalOperations.mul(
                PreciseDecimal.from("0.8937593473846237864238745"),
                PreciseDecimal.from("0.6986723567253716276345786345")
            ).value,
            PreciseDecimal.from("0.62444494958254521156041254853945406639389341840937025").value
        );
        assertEquals(
            PreciseDecimalOperations.div(
                PreciseDecimal.from("0.6244449495825452115604125485"),
                PreciseDecimal.from("0.8937593473846237864238745")
            ).value,
            PreciseDecimal.from("0.6986723567253716276345786344558560517332249999067102148534359217562859252534394065632348653940470129").value
        );
        assertEquals(
            PreciseDecimalOperations.sum(
                PreciseDecimal.from(1),
                PreciseDecimal.from("0.0000000000000000000000000001")
            ).value,
            PreciseDecimal.from("1.0000000000000000000000000001").value
        );
        assertEquals(
            PreciseDecimalOperations.sub(
                PreciseDecimal.from("1.0000000000000000000000000001"),
                PreciseDecimal.from("0.0000000000000000000000000001")
            ).value,
            PreciseDecimal.from("1").value
        );
    }

    @Test
    public final void atan() {
        assertEquals(
            PreciseDecimalOperations.atan(
                PreciseDecimal.from("1"),
                PreciseDecimal.from("1")
            ).value,
            PreciseDecimal.from("0.785398163397448309615660845819875721049292349843776455243736148076954101571552249657008706335529267").value
        );
        assertEquals(
            PreciseDecimalOperations.atan(
                PreciseDecimal.from("4"),
                PreciseDecimal.from("2")
            ).value,
            PreciseDecimal.from("1.107148717794090503017065460178537040070047645401432646676539207433710338977362794013417128686170641").value
        );
        assertEquals(
            PreciseDecimalOperations.atan(
                PreciseDecimal.from("8"),
                PreciseDecimal.from("3")
            ).value,
            PreciseDecimal.from("1.212025656524324398835401627713290942321609043806637130847073429399205018921975170570753003401633161").value
        );
        assertEquals(
            PreciseDecimalOperations.atan(
                PreciseDecimal.from("-8"),
                PreciseDecimal.from("3")
            ).value,
            PreciseDecimal.from("-1.212025656524324398835401627713290942321609043806637130847073429399205018921975170570753003401633161").value
        );
    }
}