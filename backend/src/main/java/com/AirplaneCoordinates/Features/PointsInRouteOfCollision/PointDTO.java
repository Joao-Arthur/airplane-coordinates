package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Core.LinearFunction.LinearFunction;
import com.AirplaneCoordinates.Core.Mechanics.LinearPoint;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.Trigonometry.Deg;
import com.AirplaneCoordinates.Features.PlanePointWithVector;

public final class PointDTO {
    public final PlanePointWithVector planePoint;
    public final CartesianPoint asCartesian;
    public final boolean isInfiniteTangent;
    public final LinearFunction fx;
    public final PreciseDecimal coefficient;
    public final LinearPoint linearPoint;
    
    private PointDTO(
        final PlanePointWithVector planePoint,
        final CartesianPoint asCartesian,
        final boolean isInfiniteTangent,
        final LinearFunction fx,
        final PreciseDecimal coefficient,
        final LinearPoint linearPoint
    ) {
        this.planePoint = planePoint;
        this.asCartesian = asCartesian;
        this.isInfiniteTangent = isInfiniteTangent;
        this.fx = fx;
        this.coefficient = coefficient;
        this.linearPoint = linearPoint;
    }

    public final static PointDTO from(final PlanePointWithVector planePoint) {
        final var asCartesian = planePoint.point.toCartesian();
        final var isInfiniteTangent = Deg
            .from(planePoint.vector.direction)
            .isInfiniteTangent();
        final var fx = LinearFunction.from(
            asCartesian,
            planePoint.vector.direction
        );
        final var coefficient = isInfiniteTangent
            ? PreciseDecimal.from(0)
            : Deg
                .from(planePoint.vector.direction)
                .toRad()
                .value
                .cos()
                .abs();
        final var linearPoint = LinearPoint.from(
            asCartesian.x,
            Deg
                .from(coefficient)
                .getValueInEachQuadrant(
                    coefficient.times(planePoint.vector.direction)
                )
        );

        return new PointDTO(
            planePoint,
            asCartesian,
            isInfiniteTangent,
            fx,
            coefficient,
            linearPoint
        );
    }
}
