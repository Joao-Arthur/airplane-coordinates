package com.AirplaneCoordinates.Core.Trigonometry;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class TrigonometryTest {
    @Test
    public final void radToDeg() {
        assertEquals(
            Trigonometry.radToDeg(
                PreciseDecimal.from("0.7853981633974483096156608458198757210492923498437764552437361480769541015715522496570087063355292672")
            ).value,
            PreciseDecimal.from("45.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001").value
        );
        assertEquals(
            Trigonometry.radToDeg(
                PreciseDecimal.from("1.570796326794896619231321691639751442098584699687552910487472296153908203143104499314017412671058534")
            ).value,
            PreciseDecimal.from("89.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999").value
        );
        assertEquals(
            Trigonometry.radToDeg(
                PreciseDecimal.from("2.356194490192344928846982537459627163147877049531329365731208444230862304714656748971026119006587801")
            ).value,
            PreciseDecimal.from(135).value
        );
        assertEquals(
            Trigonometry.radToDeg(
                PreciseDecimal.from("3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117068")
            ).value,
            PreciseDecimal.from(180).value
        );
        assertEquals(
            Trigonometry.radToDeg(
                PreciseDecimal.from("3.9269908169872415480783042290993786052464617492188822762186807403847705078577612482850435316776463")
            ).value,
            PreciseDecimal.from("224.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999998").value
        );
        assertEquals(
            Trigonometry.radToDeg(
                PreciseDecimal.from("4.712388980384689857693965074919254326295754099062658731462416888461724609429313497942052238013175602")
            ).value,
            PreciseDecimal.from(270).value
        );
        assertEquals(
            Trigonometry.radToDeg(
                PreciseDecimal.from("5.497787143782138167309625920739130047345046448906435186706153036538678711000865747599060944348704869")
            ).value,
            PreciseDecimal.from(315).value
        );
        assertEquals(
            Trigonometry.radToDeg(
                PreciseDecimal.from("6.283185307179586476925286766559005768394338798750211641949889184615632812572417997256069650684234133")
            ).value,
            PreciseDecimal.from("359.9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999998").value
        );
    }   

    @Test
    public final void degToRad() {
        assertEquals(
            Trigonometry.degToRad(PreciseDecimal.from(0)).value,
            PreciseDecimal.from(0).value
        );
        assertEquals(
            Trigonometry.degToRad(PreciseDecimal.from(45)).value,
            PreciseDecimal.from("0.7853981633974483096156608458198757210492923498437764552437361480769541015715522496570087063355292672").value
        );
        assertEquals(
            Trigonometry.degToRad(PreciseDecimal.from(90)).value,
            PreciseDecimal.from("1.570796326794896619231321691639751442098584699687552910487472296153908203143104499314017412671058534").value
        );
        assertEquals(
            Trigonometry.degToRad(PreciseDecimal.from(135)).value,
            PreciseDecimal.from("2.356194490192344928846982537459627163147877049531329365731208444230862304714656748971026119006587801").value
        );
        assertEquals(
            Trigonometry.degToRad(PreciseDecimal.from(180)).value,
            PreciseDecimal.from("3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117068").value
        );
        assertEquals(
            Trigonometry.degToRad(PreciseDecimal.from(225)).value,
            PreciseDecimal.from("3.926990816987241548078304229099378605246461749218882276218680740384770507857761248285043531677646335").value
        );
        assertEquals(
            Trigonometry.degToRad(PreciseDecimal.from(270)).value,
            PreciseDecimal.from("4.712388980384689857693965074919254326295754099062658731462416888461724609429313497942052238013175602").value
        );
        assertEquals(
            Trigonometry.degToRad(PreciseDecimal.from(315)).value,
            PreciseDecimal.from("5.497787143782138167309625920739130047345046448906435186706153036538678711000865747599060944348704869").value
        );
        assertEquals(
            Trigonometry.degToRad(PreciseDecimal.from(360)).value,
            PreciseDecimal.from("6.283185307179586476925286766559005768394338798750211641949889184615632812572417997256069650684234133").value
        );
    }

    @Test
    public final void normalizeAngle() {
        assertEquals(
            Trigonometry.normalizeAngle(PreciseDecimal.from(-100)).value,
            PreciseDecimal.from(260).value
        );
        assertEquals(
            Trigonometry.normalizeAngle(PreciseDecimal.from(-1)).value,
            PreciseDecimal.from(359).value
        );
        assertEquals(
            Trigonometry.normalizeAngle(PreciseDecimal.from(360)).value,
            PreciseDecimal.from(0).value
        );
        assertEquals(
            Trigonometry.normalizeAngle(PreciseDecimal.from(720)).value,
            PreciseDecimal.from(0).value
        );
        assertEquals(
            Trigonometry.normalizeAngle(PreciseDecimal.from(405)).value,
            PreciseDecimal.from(45).value
        );
        assertEquals(
            Trigonometry.normalizeAngle(PreciseDecimal.from(765)).value,
            PreciseDecimal.from(45).value
        );
        assertEquals(
            Trigonometry.normalizeAngle(PreciseDecimal.from(0)).value,
            PreciseDecimal.from(0).value
        );
        assertEquals(
            Trigonometry.normalizeAngle(PreciseDecimal.from(10)).value,
            PreciseDecimal.from(10).value
        );
        assertEquals(
            Trigonometry.normalizeAngle(PreciseDecimal.from(90)).value,
            PreciseDecimal.from(90).value
        );
        assertEquals(
            Trigonometry.normalizeAngle(PreciseDecimal.from("111.11")).value,
            PreciseDecimal.from("111.11").value
        );
    }
}
