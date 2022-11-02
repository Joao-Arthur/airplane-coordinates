package com.AirplaneCoordinates.Core.Trigonometry;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class RadianTest {
    @Test
    public final void toStringTest() {
        assertEquals(
            Radian.from(
                PreciseDecimal.from("-347")
            ).toString(),
            "-347"
        );
    }

    @Test
    public final void toDeg() {
        assertEquals(
            Radian.from(
                PreciseDecimal.from("0.7853981633974483096156608458198757210492923498437764552437361480769541015715522496570087063355292672")
            ).toDeg().toString(),
            PreciseDecimal.from("45.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001").toString()
        );
        assertEquals(
            Radian.from(
                PreciseDecimal.from("1.570796326794896619231321691639751442098584699687552910487472296153908203143104499314017412671058534")
            ).toDeg().toString(),
            PreciseDecimal.from("89.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999").toString()
        );
        assertEquals(
            Radian.from(
                PreciseDecimal.from("2.356194490192344928846982537459627163147877049531329365731208444230862304714656748971026119006587801")
            ).toDeg().toString(),
            PreciseDecimal.from(135).toString()
        );
        assertEquals(
            Radian.from(
                PreciseDecimal.from("3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117068")
            ).toDeg().toString(),
            PreciseDecimal.from(180).toString()
        );
        assertEquals(
            Radian.from(
                PreciseDecimal.from("3.9269908169872415480783042290993786052464617492188822762186807403847705078577612482850435316776463")
            ).toDeg().toString(),
            PreciseDecimal.from("224.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999998").toString()
        );
        assertEquals(
            Radian.from(
                PreciseDecimal.from("4.712388980384689857693965074919254326295754099062658731462416888461724609429313497942052238013175602")
            ).toDeg().toString(),
            PreciseDecimal.from(270).toString()
        );
        assertEquals(
            Radian.from(
                PreciseDecimal.from("5.497787143782138167309625920739130047345046448906435186706153036538678711000865747599060944348704869")
            ).toDeg().toString(),
            PreciseDecimal.from(315).toString()
        );
        assertEquals(
            Radian.from(
                PreciseDecimal.from("6.283185307179586476925286766559005768394338798750211641949889184615632812572417997256069650684234133")
            ).toDeg().toString(),
            PreciseDecimal.from("359.9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999998").toString()
        );
    }
}
