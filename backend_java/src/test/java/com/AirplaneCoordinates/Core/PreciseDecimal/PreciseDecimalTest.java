package com.AirplaneCoordinates.Core.PreciseDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    public final void opposite() {
        assertEquals(
            PreciseDecimal.from(1).opposite().value,
            PreciseDecimal.from(-1).value
        );
        assertEquals(
            PreciseDecimal.from(-2).opposite().value,
            PreciseDecimal.from(2).value
        );
        assertEquals(
            PreciseDecimal.from("0.33").opposite().value,
            PreciseDecimal.from("-0.33").value
        );
        assertEquals(
            PreciseDecimal.from("-2.22").opposite().value,
            PreciseDecimal.from("2.22").value
        );
        assertEquals(
            PreciseDecimal.from("487.732").opposite().value,
            PreciseDecimal.from("-487.732").value
        );
        assertEquals(
            PreciseDecimal.from("-8715.1347").opposite().value,
            PreciseDecimal.from("8715.1347").value
        );
        assertEquals(
            PreciseDecimal.from("1.414213562373095048801688724209698078569671875376948073176679737990732478462107038850387534327641573").opposite().value,
            PreciseDecimal.from("-1.414213562373095048801688724209698078569671875376948073176679737990732478462107038850387534327641573").value
        );
        assertEquals(
            PreciseDecimal.from("-983266465465.1092480947820932748923473854305686700340247236427845237842631093487230987520389571038972").opposite().value,
            PreciseDecimal.from("983266465465.1092480947820932748923473854305686700340247236427845237842631093487230987520389571038972").value
        );
    }

    @ParameterizedTest()
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
            PreciseDecimal.from(number).square().value,
            PreciseDecimal.from(squared).value
        );
    }

    @ParameterizedTest()
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
            PreciseDecimal.from(number).sqrt().value,
            PreciseDecimal.from(squareRoot).value
        );
    }

    @Test
    public final void square() {
        assertEquals(
            PreciseDecimal.from("1.414213562373095048801688724209698078569671875376948073176679737990732478462107038850387534327641573").square().value,
            PreciseDecimal.from("2.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001").value
        );
        assertEquals(
            PreciseDecimal.from("1.732050807568877293527446341505872366942805253810380628055806979451933016908800037081146186757248576").square().value,
            PreciseDecimal.from("3.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001").value
        );
        assertEquals(
            PreciseDecimal.from("2.236067977499789696409173668731276235440618359611525724270897245410520925637804899414414408378782275").square().value,
            PreciseDecimal.from(5).value
        );
        assertEquals(
            PreciseDecimal.from("2.449489742783178098197284074705891391965947480656670128432692567250960377457315026539859433104640235").square().value,
            PreciseDecimal.from("6.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001").value
        );
        assertEquals(
            PreciseDecimal.from("2.645751311064590590501615753639260425710259183082450180368334459201068823230283627760392886474543611").square().value,
            PreciseDecimal.from("7.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002").value
        );
        assertEquals(
            PreciseDecimal.from("2.828427124746190097603377448419396157139343750753896146353359475981464956924214077700775068655283145").square().value,
            PreciseDecimal.from("7.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999997").value
        );
    }

    @Test
    public final void sqrt() {
        assertEquals(
            PreciseDecimal.from(2).sqrt().value,
            PreciseDecimal.from("1.414213562373095048801688724209698078569671875376948073176679737990732478462107038850387534327641573").value
        );
        assertEquals(
            PreciseDecimal.from("2.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001").sqrt().value,
            PreciseDecimal.from("1.414213562373095048801688724209698078569671875376948073176679737990732478462107038850387534327641573").value
        );
        assertEquals(
            PreciseDecimal.from(3).sqrt().value,
            PreciseDecimal.from("1.732050807568877293527446341505872366942805253810380628055806979451933016908800037081146186757248576").value
            );
        assertEquals(
            PreciseDecimal.from("3.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001").sqrt().value,
            PreciseDecimal.from("1.732050807568877293527446341505872366942805253810380628055806979451933016908800037081146186757248576").value
        );
        assertEquals(
            PreciseDecimal.from(5).sqrt().value,
            PreciseDecimal.from("2.236067977499789696409173668731276235440618359611525724270897245410520925637804899414414408378782275").value
        );
        assertEquals(
            PreciseDecimal.from(6).sqrt().value,
            PreciseDecimal.from("2.449489742783178098197284074705891391965947480656670128432692567250960377457315026539859433104640235").value
        );
        assertEquals(
            PreciseDecimal.from("6.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001").sqrt().value,
            PreciseDecimal.from("2.449489742783178098197284074705891391965947480656670128432692567250960377457315026539859433104640235").value
        );
        assertEquals(
            PreciseDecimal.from(7).sqrt().value,
            PreciseDecimal.from("2.645751311064590590501615753639260425710259183082450180368334459201068823230283627760392886474543611").value
        );
        assertEquals(
            PreciseDecimal.from("7.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002").sqrt().value,
            PreciseDecimal.from("2.645751311064590590501615753639260425710259183082450180368334459201068823230283627760392886474543611").value
        );
        assertEquals(
            PreciseDecimal.from(8).sqrt().value,
            PreciseDecimal.from("2.828427124746190097603377448419396157139343750753896146353359475981464956924214077700775068655283145").value
        );
        assertEquals(
            PreciseDecimal.from("7.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999997").sqrt().value,
            PreciseDecimal.from("2.828427124746190097603377448419396157139343750753896146353359475981464956924214077700775068655283145").value
        );
    }

    @Test
    public final void sin() {
        assertEquals(
            PreciseDecimal.from(0).sin().value,
            PreciseDecimal.from("0").value
        );
        assertEquals(
            PreciseDecimal.from(1).sin().value,
            PreciseDecimal.from("0.8414709848078965066525023216302989996225630607983710656727517099919104043912396689486397435430526959").value
        );
        assertEquals(
            PreciseDecimal.from(2).sin().value,
            PreciseDecimal.from("0.9092974268256816953960198659117448427022549714478902683789730115309673015407835446201266889249593803").value
        );
        assertEquals(
            PreciseDecimal.from(3).sin().value,
            PreciseDecimal.from("0.1411200080598672221007448028081102798469332642522655841518826412324220099670144719112821728534498638").value
        );
        assertEquals(
            PreciseDecimal.from(4).sin().value,
            PreciseDecimal.from("-0.7568024953079282513726390945118290941359128873364725714854167734013104936191794164235728105624227481").value
        );
        assertEquals(
            PreciseDecimal.from(5).sin().value,
            PreciseDecimal.from("-0.9589242746631384688931544061559939733524615439646017781316724542351025580865596030769959554295328666").value
        );
        assertEquals(
            PreciseDecimal.from(6).sin().value,
            PreciseDecimal.from("-0.2794154981989258728115554466118947596279948643182043184833513696533111540586443348546689384528422476").value
        );
        assertEquals(
            PreciseDecimal.from(7).sin().value,
            PreciseDecimal.from("0.6569865987187890903969990915936351779368700104974900746578543341892928371312270315099351216010552127").value
        );
    }

    @Test
    public final void cos() {
        assertEquals(
            PreciseDecimal.from(0).cos().value,
            PreciseDecimal.from(1).value
        );
        assertEquals(
            PreciseDecimal.from(1).cos().value,
            PreciseDecimal.from("0.5403023058681397174009366074429766037323104206179222276700972553811003947744717645179518560871830893").value
        );
        assertEquals(
            PreciseDecimal.from(2).cos().value,
            PreciseDecimal.from("-0.4161468365471423869975682295007621897660007710755448907551499737819649361240791690745317778601691404").value
        );
        assertEquals(
            PreciseDecimal.from(3).cos().value,
            PreciseDecimal.from("-0.9899924966004454572715727947312613023936790966155883288140859329283291975131332204282944793556926022").value
        );
        assertEquals(
            PreciseDecimal.from(4).cos().value,
            PreciseDecimal.from("-0.6536436208636119146391681830977503814241335966462182470070102838527376558106033799012306456461788582").value
        );
        assertEquals(
            PreciseDecimal.from(5).cos().value,
            PreciseDecimal.from("0.2836621854632262644666391715135573083344225922522159449303590665861514567673827022861769816683445732").value
        );
        assertEquals(
            PreciseDecimal.from(6).cos().value,
            PreciseDecimal.from("0.9601702866503660205456522979229244054519376792110126981292864260535458585549931066464416113637612995").value
        );
        assertEquals(
            PreciseDecimal.from(7).cos().value,
            PreciseDecimal.from("0.7539022543433046381411975217191820122183133914601268395436138808138760267207174056254283910893024825").value
        );
    }
}
