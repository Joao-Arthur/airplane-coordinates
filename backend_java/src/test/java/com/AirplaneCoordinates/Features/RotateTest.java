package com.AirplaneCoordinates.Features;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class RotateTest {
    @Test
    public final void polarRotate() {
        assertEquals(
            Rotate.execute(
                PlanePoint.from(Plane.POLAR, "1.22", "11.11"),
                CartesianPoint.from(0, 0),
                PreciseDecimal.from(50)
            ).value,
            PlanePoint.from(Plane.POLAR, "1.22", "61.11").value
        );
    }
    
    @Test
    public final void polarRotateOffseted() {
        assertEquals(
            Rotate.execute(
                PlanePoint.from(Plane.POLAR, 4, 90),
                CartesianPoint.from(4, 4),
                PreciseDecimal.from(90)
            ).value,
            PlanePoint.from(Plane.POLAR, 4, 0).value
        );
        assertEquals(
            Rotate.execute(
                PlanePoint.from(Plane.POLAR, 4, 45),
                CartesianPoint.from(8, 8),
                PreciseDecimal.from(180)
            ).value,
            PlanePoint.from(
                Plane.POLAR,
                "18.62741699796952078082701958735516925711475000603116917082687580785171965539371262160620054924226516",
                "45"
            ).value
        );
    }

    @Test
    public final void cartesianRotate() {
        assertEquals(
            Rotate.execute(
                PlanePoint.from(Plane.CARTESIAN, 4, 4),
                CartesianPoint.from(8, 0),
                PreciseDecimal.from(90)
            ).value,
            PlanePoint.from(Plane.CARTESIAN, 4, -4).value
        );
    }

    @Test
    public final void cartesianRotateOffseted() {
        assertEquals(
            Rotate.execute(
                PlanePoint.from(Plane.CARTESIAN, 0, 4),
                CartesianPoint.from(4, 4),
                PreciseDecimal.from(90)
            ).value,
            PlanePoint.from(Plane.CARTESIAN, 4, 0).value
        );
        assertEquals(
            Rotate.execute(
                PlanePoint.from(Plane.CARTESIAN, -4, 4),
                CartesianPoint.from(-8, 4),
                PreciseDecimal.from(270)
            ).value,
            PlanePoint.from(Plane.CARTESIAN, -8, 0).value
        );
    }

    @Test
    public final void rotateBackAndForthCartesian(
    ) {
    }

    @Test
    public final void rotateBackAndForthPolar(
        
    ) {
    }

    @Test
    public final void rotateBackAndForthCartesianOffseted(
       
    ) {
    }

    @Test
    public final void rotateBackAndForthPolarOffseted(
      
    ) {
    }
}
