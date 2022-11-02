package com.AirplaneCoordinates.Core.Trigonometry;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class DegreeTest {
    @Test
    public final void toStringTest() {
        assertEquals(
            Degree.from(
                PreciseDecimal.from("6.05")
            ).toString(),
            "6.05"
        );
    }

    @Test
    public final void toRad() {
        assertEquals(
            Degree.from(PreciseDecimal.from(0)).toRad().toString(),
            PreciseDecimal.from(0).toString()
        );
        assertEquals(
            Degree.from(PreciseDecimal.from(45)).toRad().toString(),
            PreciseDecimal.from("0.7853981633974483096156608458198757210492923498437764552437361480769541015715522496570087063355292672").toString()
        );
        assertEquals(
            Degree.from(PreciseDecimal.from(90)).toRad().toString(),
            PreciseDecimal.from("1.570796326794896619231321691639751442098584699687552910487472296153908203143104499314017412671058534").toString()
        );
        assertEquals(
            Degree.from(PreciseDecimal.from(135)).toRad().toString(),
            PreciseDecimal.from("2.356194490192344928846982537459627163147877049531329365731208444230862304714656748971026119006587801").toString()
        );
        assertEquals(
            Degree.from(PreciseDecimal.from(180)).toRad().toString(),
            PreciseDecimal.from("3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117068").toString()
        );
        assertEquals(
            Degree.from(PreciseDecimal.from(225)).toRad().toString(),
            PreciseDecimal.from("3.926990816987241548078304229099378605246461749218882276218680740384770507857761248285043531677646335").toString()
        );
        assertEquals(
            Degree.from(PreciseDecimal.from(270)).toRad().toString(),
            PreciseDecimal.from("4.712388980384689857693965074919254326295754099062658731462416888461724609429313497942052238013175602").toString()
        );
        assertEquals(
            Degree.from(PreciseDecimal.from(315)).toRad().toString(),
            PreciseDecimal.from("5.497787143782138167309625920739130047345046448906435186706153036538678711000865747599060944348704869").toString()
        );
        assertEquals(
            Degree.from(PreciseDecimal.from(360)).toRad().toString(),
            PreciseDecimal.from(0).toString()
        );
        assertEquals(
            Degree.from(PreciseDecimal.from(405)).toRad().toString(),
            PreciseDecimal.from("0.7853981633974483096156608458198757210492923498437764552437361480769541015715522496570087063355292672").toString()
        );
        assertEquals(
            Degree.from(PreciseDecimal.from(450)).toRad().toString(),
            PreciseDecimal.from("1.570796326794896619231321691639751442098584699687552910487472296153908203143104499314017412671058534").toString()
        );
        assertEquals(
            Degree.from(PreciseDecimal.from(495)).toRad().toString(),
            PreciseDecimal.from("2.356194490192344928846982537459627163147877049531329365731208444230862304714656748971026119006587801").toString()
        );
        assertEquals(
            Degree.from(PreciseDecimal.from(540)).toRad().toString(),
            PreciseDecimal.from("3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117068").toString()
        );
        assertEquals(
            Degree.from(PreciseDecimal.from(585)).toRad().toString(),
            PreciseDecimal.from("3.926990816987241548078304229099378605246461749218882276218680740384770507857761248285043531677646335").toString()
        );
        assertEquals(
            Degree.from(PreciseDecimal.from(630)).toRad().toString(),
            PreciseDecimal.from("4.712388980384689857693965074919254326295754099062658731462416888461724609429313497942052238013175602").toString()
        );
        assertEquals(
            Degree.from(PreciseDecimal.from(675)).toRad().toString(),
            PreciseDecimal.from("5.497787143782138167309625920739130047345046448906435186706153036538678711000865747599060944348704869").toString()
        );
        assertEquals(
            Degree.from(PreciseDecimal.from(720)).toRad().toString(),
            PreciseDecimal.from(0).toString()
        );
    }

    @ParameterizedTest
    @CsvSource({
        "360, 0",
        "405, 45",
        "-100, 260",
        "-1, 359",
        "-111.11, 248.89",
        "-0.1, 359.9",
        "0, 0",
        "765, 45",
        "10, 10",
        "90, 90",
        "111.11, 111.11",
    })
    public final void normalize(
        final String angle,
        final String normalizedAngle
    ) {
        assertEquals(
            Degree.from(PreciseDecimal.from(angle)).normalized().toString(),
            PreciseDecimal.from(normalizedAngle).toString()
        );
    }

    @ParameterizedTest
    @CsvSource({
        "0, false",
        "45, false",
        "90, true",
        "135, false",
        "180, false",
        "225, false",
        "270, true",
        "269.99999999, false",
        "270.00000001, false",
        "89.99999999, false",
        "90.00000001, false",
    })
    public final void isInfiniteTangent(
        final String angle,
        final boolean isInfinite 
    ) {
        assertEquals(
            Degree.from(PreciseDecimal.from(angle)).isInfiniteTangent(),
            isInfinite
        );
    }
}
