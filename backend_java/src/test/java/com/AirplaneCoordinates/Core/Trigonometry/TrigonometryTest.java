package com.AirplaneCoordinates.Core.Trigonometry;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class TrigonometryTest {
    @Test
    public final void radToDeg() {
        assertEquals(
            Trigonometry.radToDeg(
                PreciseDecimal.from("0.7853981633974483096156608458198757210492923498437764552437361480769541015715522496570087063355292672")
            ).toString(),
            PreciseDecimal.from("45.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001").toString()
        );
        assertEquals(
            Trigonometry.radToDeg(
                PreciseDecimal.from("1.570796326794896619231321691639751442098584699687552910487472296153908203143104499314017412671058534")
            ).toString(),
            PreciseDecimal.from("89.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999").toString()
        );
        assertEquals(
            Trigonometry.radToDeg(
                PreciseDecimal.from("2.356194490192344928846982537459627163147877049531329365731208444230862304714656748971026119006587801")
            ).toString(),
            PreciseDecimal.from(135).toString()
        );
        assertEquals(
            Trigonometry.radToDeg(
                PreciseDecimal.from("3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117068")
            ).toString(),
            PreciseDecimal.from(180).toString()
        );
        assertEquals(
            Trigonometry.radToDeg(
                PreciseDecimal.from("3.9269908169872415480783042290993786052464617492188822762186807403847705078577612482850435316776463")
            ).toString(),
            PreciseDecimal.from("224.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999998").toString()
        );
        assertEquals(
            Trigonometry.radToDeg(
                PreciseDecimal.from("4.712388980384689857693965074919254326295754099062658731462416888461724609429313497942052238013175602")
            ).toString(),
            PreciseDecimal.from(270).toString()
        );
        assertEquals(
            Trigonometry.radToDeg(
                PreciseDecimal.from("5.497787143782138167309625920739130047345046448906435186706153036538678711000865747599060944348704869")
            ).toString(),
            PreciseDecimal.from(315).toString()
        );
        assertEquals(
            Trigonometry.radToDeg(
                PreciseDecimal.from("6.283185307179586476925286766559005768394338798750211641949889184615632812572417997256069650684234133")
            ).toString(),
            PreciseDecimal.from("359.9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999998").toString()
        );
    }   

    @Test
    public final void degToRad() {
        assertEquals(
            Trigonometry.degToRad(PreciseDecimal.from(0)).toString(),
            PreciseDecimal.from(0).toString()
        );
        assertEquals(
            Trigonometry.degToRad(PreciseDecimal.from(45)).toString(),
            PreciseDecimal.from("0.7853981633974483096156608458198757210492923498437764552437361480769541015715522496570087063355292672").toString()
        );
        assertEquals(
            Trigonometry.degToRad(PreciseDecimal.from(90)).toString(),
            PreciseDecimal.from("1.570796326794896619231321691639751442098584699687552910487472296153908203143104499314017412671058534").toString()
        );
        assertEquals(
            Trigonometry.degToRad(PreciseDecimal.from(135)).toString(),
            PreciseDecimal.from("2.356194490192344928846982537459627163147877049531329365731208444230862304714656748971026119006587801").toString()
        );
        assertEquals(
            Trigonometry.degToRad(PreciseDecimal.from(180)).toString(),
            PreciseDecimal.from("3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117068").toString()
        );
        assertEquals(
            Trigonometry.degToRad(PreciseDecimal.from(225)).toString(),
            PreciseDecimal.from("3.926990816987241548078304229099378605246461749218882276218680740384770507857761248285043531677646335").toString()
        );
        assertEquals(
            Trigonometry.degToRad(PreciseDecimal.from(270)).toString(),
            PreciseDecimal.from("4.712388980384689857693965074919254326295754099062658731462416888461724609429313497942052238013175602").toString()
        );
        assertEquals(
            Trigonometry.degToRad(PreciseDecimal.from(315)).toString(),
            PreciseDecimal.from("5.497787143782138167309625920739130047345046448906435186706153036538678711000865747599060944348704869").toString()
        );
        assertEquals(
            Trigonometry.degToRad(PreciseDecimal.from(360)).toString(),
            PreciseDecimal.from("6.283185307179586476925286766559005768394338798750211641949889184615632812572417997256069650684234133").toString()
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
    public final void normalizeAngle(
        final String angle,
        final String normalizedAngle
    ) {
        assertEquals(
            Trigonometry.normalizeAngle(PreciseDecimal.from(angle)).toString(),
            PreciseDecimal.from(normalizedAngle).toString()
        );
    }
}
