package com.AirplaneCoordinates.Core.PreciseDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

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
        assertEquals(
            PreciseDecimal.from("0").round().toString(),
            PreciseDecimal.from("0").toString()
        );
        assertEquals(
            PreciseDecimal.from("0.0").round().toString(),
            PreciseDecimal.from("0").toString()
        );
        assertEquals(
            PreciseDecimal.from("128397194.12986127861287461248026874653874653876437865").round().toString(),
            PreciseDecimal.from("128397194.12986127861287461248026874653874653876437865").toString()
        );
        assertEquals(
            PreciseDecimal.from(
                "-0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000008925923158962873287395684462014298936503822914355030584503253124672887066979806660820263610315112846"
            ).round().toString(),
            PreciseDecimal.from("0").toString()
        );
        assertEquals(
            PreciseDecimal.from(
                "-0.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001785168730185325876330195087697043801180875908126664775654369943120098476233794486654297087559171119"
            ).round().toString(),
            PreciseDecimal.from("0").toString()
        );
        assertEquals(
            PreciseDecimal.from(
                "0.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002677770460680870630367848597990798145006512910656987836884117554320577928487771481205784002962934467"
            ).round().toString(),
            PreciseDecimal.from("0").toString()
        );
    }

    @Test
    public final void format() {
        assertEquals(
            PreciseDecimal.from("1.38").format(),
            "+1.38"
        );
        assertEquals(
            PreciseDecimal.from("-0.6").format(),
            "-0.6"
        );
        assertEquals(
            PreciseDecimal.from("0.0000000000000000000000000000").format(),
            "0"
        );
    }

    @Test
    public final void toStringTest() {
        assertEquals(
            PreciseDecimal.from("3.8909").toString(),
            "3.8909"
        );
    }

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
            PreciseDecimal.sum(
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
            PreciseDecimal.sub(
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
            PreciseDecimal.mul(
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
            PreciseDecimal.div(
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
            PreciseDecimal.rem(
                PreciseDecimal.from(a),
                PreciseDecimal.from(b)
            ).toString(),
            PreciseDecimal.from(result).toString()
        );
    }

    @Test
    public final void preciseCalculations() { 
        assertEquals(
            PreciseDecimal.sum(
                PreciseDecimal.from("0.1"),
                PreciseDecimal.from("0.2")
            ).toString(),
            PreciseDecimal.from("0.3").toString()
        );
        assertEquals(
            PreciseDecimal.sum(
                PreciseDecimal.from("0.1234567890123456789012345678901"),
                PreciseDecimal.from("0.1234321003123432100312343210036")
            ).toString(),
            PreciseDecimal.from("0.2468888893246888889324688888937").toString()
        );
        assertEquals(
            PreciseDecimal.mul(
                PreciseDecimal.from("0.8937593473846237864238745"),
                PreciseDecimal.from("0.6986723567253716276345786345")
            ).toString(),
            PreciseDecimal.from("0.62444494958254521156041254853945406639389341840937025").toString()
        );
        assertEquals(
            PreciseDecimal.div(
                PreciseDecimal.from("0.6244449495825452115604125485"),
                PreciseDecimal.from("0.8937593473846237864238745")
            ).toString(),
            PreciseDecimal.from("0.6986723567253716276345786344558560517332249999067102148534359217562859252534394065632348653940470129").toString()
        );
        assertEquals(
            PreciseDecimal.sum(
                PreciseDecimal.from(1),
                PreciseDecimal.from("0.0000000000000000000000000001")
            ).toString(),
            PreciseDecimal.from("1.0000000000000000000000000001").toString()
        );
        assertEquals(
            PreciseDecimal.sub(
                PreciseDecimal.from("1.0000000000000000000000000001"),
                PreciseDecimal.from("0.0000000000000000000000000001")
            ).toString(),
            PreciseDecimal.from("1").toString()
        );
    }

    @Test
    public final void atan() {
        assertEquals(
            PreciseDecimal.atan(
                PreciseDecimal.from(1),
                PreciseDecimal.from(1)
            ).toString(),
            PreciseDecimal.from("0.785398163397448309615660845819875721049292349843776455243736148076954101571552249657008706335529267").toString()
        );
        assertEquals(
            PreciseDecimal.atan(
                PreciseDecimal.from(3),
                PreciseDecimal.from(1)
            ).toString(),
            PreciseDecimal.from("1.24904577239825442582991707728109012307782940412989671905466923679715196573729395495760899032041716").toString()
        );
        assertEquals(
            PreciseDecimal.atan(
                PreciseDecimal.from(4),
                PreciseDecimal.from(2)
            ).toString(),
            PreciseDecimal.from("1.107148717794090503017065460178537040070047645401432646676539207433710338977362794013417128686170641").toString()
        );
        assertEquals(
            PreciseDecimal.atan(
                PreciseDecimal.from(8),
                PreciseDecimal.from(3)
            ).toString(),
            PreciseDecimal.from("1.212025656524324398835401627713290942321609043806637130847073429399205018921975170570753003401633161").toString()
        );
        assertEquals(
            PreciseDecimal.atan(
                PreciseDecimal.from(1),
                PreciseDecimal.from(2)
            ).toString(),
            PreciseDecimal.from("0.4636476090008061162142562314612144020285370542861202638109330887201978641657417053006002839848878926").toString()
        );
        assertEquals(
            PreciseDecimal.atan(
                PreciseDecimal.from(-8),
                PreciseDecimal.from(3)
            ).toString(),
            PreciseDecimal.from("-1.212025656524324398835401627713290942321609043806637130847073429399205018921975170570753003401633161").toString()
        );
    }

    @Test
    public final void compareAsc() {
        final var items = new ArrayList<PreciseDecimal>();
        items.add(PreciseDecimal.from(10));
        items.add(PreciseDecimal.from(-2));
        items.add(PreciseDecimal.from(3));
        items.add(PreciseDecimal.from("46.5"));
        items.add(PreciseDecimal.from(3));

        final var actual = items
            .stream()
            .sorted(PreciseDecimal::compareAsc)
            .collect(Collectors.toList());

        final var expected = new ArrayList<PreciseDecimal>();
        expected.add(PreciseDecimal.from(-2));
        expected.add(PreciseDecimal.from(3));
        expected.add(PreciseDecimal.from(3));
        expected.add(PreciseDecimal.from(10));
        expected.add(PreciseDecimal.from("46.5"));

        assertEquals(
            Arrays.toString(actual.toArray()),
            Arrays.toString(expected.toArray())
        );
    }

    @Test
    public final void compareDesc() {
        final var items = new ArrayList<PreciseDecimal>();
        items.add(PreciseDecimal.from(10));
        items.add(PreciseDecimal.from(-2));
        items.add(PreciseDecimal.from(3));
        items.add(PreciseDecimal.from("46.5"));
        items.add(PreciseDecimal.from(3));

        final var actual = items
            .stream()
            .sorted(PreciseDecimal::compareDesc)
            .collect(Collectors.toList());

        final var expected = new ArrayList<PreciseDecimal>();
        expected.add(PreciseDecimal.from("46.5"));
        expected.add(PreciseDecimal.from(10));
        expected.add(PreciseDecimal.from(3));
        expected.add(PreciseDecimal.from(3));
        expected.add(PreciseDecimal.from(-2));

        assertEquals(
            Arrays.toString(actual.toArray()),
            Arrays.toString(expected.toArray())
        );
    }
}
