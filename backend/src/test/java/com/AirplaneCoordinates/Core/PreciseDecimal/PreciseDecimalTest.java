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

    @Test
    public final void sin() {
        assertEquals(
            PreciseDecimal.from(0).sin().toString(),
            PreciseDecimal.from("0").toString()
        );
        assertEquals(
            PreciseDecimal.from(1).sin().toString(),
            PreciseDecimal.from("0.8414709848078965066525023216302989996225630607983710656727517099919104043912396689486397435430526959").toString()
        );
        assertEquals(
            PreciseDecimal.from(2).sin().toString(),
            PreciseDecimal.from("0.9092974268256816953960198659117448427022549714478902683789730115309673015407835446201266889249593803").toString()
        );
        assertEquals(
            PreciseDecimal.from(3).sin().toString(),
            PreciseDecimal.from("0.1411200080598672221007448028081102798469332642522655841518826412324220099670144719112821728534498638").toString()
        );
        assertEquals(
            PreciseDecimal.from(4).sin().toString(),
            PreciseDecimal.from("-0.7568024953079282513726390945118290941359128873364725714854167734013104936191794164235728105624227481").toString()
        );
        assertEquals(
            PreciseDecimal.from(5).sin().toString(),
            PreciseDecimal.from("-0.9589242746631384688931544061559939733524615439646017781316724542351025580865596030769959554295328666").toString()
        );
        assertEquals(
            PreciseDecimal.from(6).sin().toString(),
            PreciseDecimal.from("-0.2794154981989258728115554466118947596279948643182043184833513696533111540586443348546689384528422476").toString()
        );
        assertEquals(
            PreciseDecimal.from(7).sin().toString(),
            PreciseDecimal.from("0.6569865987187890903969990915936351779368700104974900746578543341892928371312270315099351216010552127").toString()
        );
    }

    @Test
    public final void cos() {
        assertEquals(
            PreciseDecimal.from(0).cos().toString(),
            PreciseDecimal.from(1).toString()
        );
        assertEquals(
            PreciseDecimal.from(1).cos().toString(),
            PreciseDecimal.from("0.5403023058681397174009366074429766037323104206179222276700972553811003947744717645179518560871830893").toString()
        );
        assertEquals(
            PreciseDecimal.from(2).cos().toString(),
            PreciseDecimal.from("-0.4161468365471423869975682295007621897660007710755448907551499737819649361240791690745317778601691404").toString()
        );
        assertEquals(
            PreciseDecimal.from(3).cos().toString(),
            PreciseDecimal.from("-0.9899924966004454572715727947312613023936790966155883288140859329283291975131332204282944793556926022").toString()
        );
        assertEquals(
            PreciseDecimal.from(4).cos().toString(),
            PreciseDecimal.from("-0.6536436208636119146391681830977503814241335966462182470070102838527376558106033799012306456461788582").toString()
        );
        assertEquals(
            PreciseDecimal.from(5).cos().toString(),
            PreciseDecimal.from("0.2836621854632262644666391715135573083344225922522159449303590665861514567673827022861769816683445732").toString()
        );
        assertEquals(
            PreciseDecimal.from(6).cos().toString(),
            PreciseDecimal.from("0.9601702866503660205456522979229244054519376792110126981292864260535458585549931066464416113637612995").toString()
        );
        assertEquals(
            PreciseDecimal.from(7).cos().toString(),
            PreciseDecimal.from("0.7539022543433046381411975217191820122183133914601268395436138808138760267207174056254283910893024825").toString()
        );
    }

    @Test
    public final void tan() {
        assertEquals(
            PreciseDecimal.from(1).tan().toString(),
            PreciseDecimal.from("1.557407724654902230506974807458360173087250772381520038383946605698861397151727289555099965202242984").toString()
        );
        assertEquals(
            PreciseDecimal.from(2).tan().toString(),
            PreciseDecimal.from("-2.185039863261518991643306102313682543432017746227663164562955869966773747209194182319743542104728548").toString()
        );
        assertEquals(
            PreciseDecimal.from(3).tan().toString(),
            PreciseDecimal.from("-0.1425465430742778052956354105339134932260922849018046476332389766888585952215385380591060583477669114").toString()
        );
        assertEquals(
            PreciseDecimal.from(4).tan().toString(),
            PreciseDecimal.from("1.157821282349577583137342418267323923119762767367142130084857189358985762063503791325897570132020188").toString()
        );
        assertEquals(
            PreciseDecimal.from(5).tan().toString(),
            PreciseDecimal.from("-3.380515006246585636982705879447343908709569208285459877176820980918346010201206056831791856009410428").toString()
        );
        assertEquals(
            PreciseDecimal.from(6).tan().toString(),
            PreciseDecimal.from("-0.2910061913847491570536995888681755428311555709123391316088271933046559131122021519996248059475229616").toString()
        );
        assertEquals(
            PreciseDecimal.from(7).tan().toString(),
            PreciseDecimal.from("0.8714479827243187364564508896003135663222034245984200644480154523301674476556679351044748556811165168").toString()
        );
    }
    
    @Test
    public final void tanSpecialCases() {
        assertEquals(
            PreciseDecimal.from(0).tan().toString(),
            PreciseDecimal.from(0).toString()
        );
        assertEquals(
            PreciseDecimal.from("1.570796326794896619231321691639751442098584699687552910487472296153908203143104499314017412671058534").tan().toString(),
            PreciseDecimal.from("-112032808158913938772094286859147368891405526253541322435135714436774805871368562873093748017071649400").toString()
        );
        assertEquals(
            PreciseDecimal.halfPi().tan().toString(),
            PreciseDecimal.from("-112032808158913938772094286859147368891405526253541322435135714436774805871368562873093748017071649400").toString()
        );
        assertEquals(
            PreciseDecimal.pi().tan().toString(),
            PreciseDecimal.from(0).toString()
        );
        assertEquals(
            PreciseDecimal.threeQuartsPi().tan().toString(),
            PreciseDecimal.from("-37344269010629053986830498754167863778272117607896815375322900893940380370381984136818683625176921760").toString()
        );
    }

    @Test
    public final void round() {
        assertEquals(
            PreciseDecimal.from(7).round().toString(),
            PreciseDecimal.from(7).toString()
        );
        assertEquals(
            PreciseDecimal.from(0).round().toString(),
            PreciseDecimal.from(0).toString()
        );
        assertEquals(
            PreciseDecimal.from(-3).round().toString(),
            PreciseDecimal.from(-3).toString()
        );
        assertEquals(
            PreciseDecimal.from("3.17").round().toString(),
            PreciseDecimal.from("3.17").toString()
        );
        assertEquals(
            PreciseDecimal.from("-24.287494").round().toString(),
            PreciseDecimal.from("-24.287494").toString()
        );
        assertEquals(
            PreciseDecimal.from("234.2938623478634786234782364726317836192371983719382739824623785647562349875634987563249875263498752").round().toString(),
            PreciseDecimal.from("234.2938623478634786234782364726317836192371983719382739824623785647562349875634987563249875263498752").toString()
        );
        assertEquals(
            PreciseDecimal.from("111.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001").round().toString(),
            PreciseDecimal.from(111).toString()
        );
        assertEquals(
            PreciseDecimal.from("286.9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999992").round().toString(),
            PreciseDecimal.from(287).toString()
        );
        assertEquals(
            PreciseDecimal.from("-779.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000031").round().toString(),
            PreciseDecimal.from(-779).toString()
        );
        assertEquals(
            PreciseDecimal.from("2.220000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000022").round().toString(),
            PreciseDecimal.from("2.22").toString()
        );
        assertEquals(
            PreciseDecimal.from("2.200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000022").round().toString(),
            PreciseDecimal.from("2.2").toString()
        );
        assertEquals(
            PreciseDecimal.from("2.219999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999994").round().toString(),
            PreciseDecimal.from("2.22").toString()
        );
        assertEquals(
            PreciseDecimal.from("2.199999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999989").round().toString(),
            PreciseDecimal.from("2.2").toString()
        );
        assertEquals(
            PreciseDecimal.from("7.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004").round().toString(),
            PreciseDecimal.from(7).toString()
        );
    }
}
