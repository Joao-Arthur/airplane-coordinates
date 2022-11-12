package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Core.LinearFunction.LinearFunction;
import com.AirplaneCoordinates.Core.Mechanics.LinearPoint;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.Trigonometry.Deg;
import com.AirplaneCoordinates.Features.PlanePointWithVector;

public final class PointDTO {
    public final PlanePointWithVector planePoint;
    public final CartesianPoint pointAsCartesian;
    public final boolean isInfiniteTangent;
    public final LinearFunction fx;
    public final PreciseDecimal coefficient;
    public final LinearPoint linearPoint;
    
    private PointDTO(
        final PlanePointWithVector planePoint,
        final CartesianPoint pointAsCartesian,
        final boolean isInfiniteTangent,
        final LinearFunction fx,
        final PreciseDecimal coefficient,
        final LinearPoint linearPoint
    ) {
        this.planePoint = planePoint;
        this.pointAsCartesian = pointAsCartesian;
        this.isInfiniteTangent = isInfiniteTangent;
        this.fx = fx;
        this.coefficient = coefficient;
        this.linearPoint = linearPoint;
    }

    public final PointDTO from(final PlanePointWithVector planePoint) {
        final var pointAsCartesian = planePoint.point.toCartesian();
        final var isInfiniteTangent = Deg
            .from(planePoint.vector.direction)
            .isInfiniteTangent();
        final var fx = LinearFunction.from(
            pointAsCartesian,
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
            pointAsCartesian.x,
            Deg.from(coefficient)
            .getValueInEachQuadrant(
                coefficient.times(planePoint.vector.direction)
            )
        );

        return new PointDTO(
            planePoint,
            pointAsCartesian,
            isInfiniteTangent,
            fx,
            coefficient,
            linearPoint
        );
    }
}
