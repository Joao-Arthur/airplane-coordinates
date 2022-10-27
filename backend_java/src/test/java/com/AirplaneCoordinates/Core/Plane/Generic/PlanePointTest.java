package com.AirplaneCoordinates.Core.Plane.Generic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Polar.PolarPoint;

public final class PlanePointTest {
    @Test
    public final void toCartesian() {
        assertEquals(
            PlanePoint.from(Plane.CARTESIAN, "4.2948", "-1.6825").toCartesian().value,
            CartesianPoint.from("4.2948", "-1.6825").value
        );
        assertEquals(
            PlanePoint.from(Plane.POLAR, 3, 270).toCartesian().value,
            CartesianPoint.from(0, -3).value
        );
    }

    @Test
    public final void toPolar() {
        assertEquals(
            PlanePoint.from(Plane.CARTESIAN, "4.2948", "-1.6825").toPolar().value,
            PolarPoint.from(
                "4.61260374300676298620867184493562308961867705805857552457014228830712110795667683506908149466422647",
                "338.6070977245781947964007178731211879769458229078057134402590949906681137107292429795719032748935362"
            ).value
        );
        assertEquals(
            PlanePoint.from(Plane.POLAR, 3, 270).toPolar().value,
            PolarPoint.from(3, 270).value
        );
    }
    
    @Test
    public final void fromCartesian() {
        assertEquals(
            PlanePoint.fromCartesian(CartesianPoint.from("4.2948", "-1.6825")).value,
            PlanePoint.from(Plane.CARTESIAN, "4.2948", "-1.6825").value
        );
    }
    
    @Test
    public final void fromPolar() {
        assertEquals(
            PlanePoint.fromPolar(
                PolarPoint.from(
                    "4.61260374300676298620867184493562308961867705805857552457014228830712110795667683506908149466422647",
                    "338.6070977245781947964007178731211879769458229078057134402590949906681137107292429795719032748935362"
                )
            ).value,
            PlanePoint.from(
                Plane.POLAR,
                "4.61260374300676298620867184493562308961867705805857552457014228830712110795667683506908149466422647",
                "338.6070977245781947964007178731211879769458229078057134402590949906681137107292429795719032748935362"
            ).value
        );
    }
}
