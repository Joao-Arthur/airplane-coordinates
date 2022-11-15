package com.AirplaneCoordinates.Plain.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.PointsInRouteOfCollision.PointInRouteOfCollisionOutputDTO;
import com.AirplaneCoordinates.Plain.Core.Plane.Cartesian.CartesianPointPlain;

public final class PointInRouteOfCollisionOutputDTOPlain {
    public final String a;
    public final String b;
    public final String timeUntilCollision;
    public final CartesianPointPlain collisionPoint;
    public final String timeDifferenceToPoint;

    public PointInRouteOfCollisionOutputDTOPlain(
        final String a,
        final String b,
        final String timeUntilCollision,
        final CartesianPointPlain collisionPoint,
        final String timeDifferenceToPoint
    ) {
        this.a = a;
        this.b = b;
        this.timeUntilCollision = timeUntilCollision;
        this.collisionPoint = collisionPoint;
        this.timeDifferenceToPoint = timeDifferenceToPoint;
    }

    public final PointInRouteOfCollisionOutputDTO toObject() {
        return new PointInRouteOfCollisionOutputDTO(
            this.a,
            this.b,
            PreciseDecimal.from(this.timeUntilCollision),
            this.collisionPoint.toObject(),
            PreciseDecimal.from(this.timeDifferenceToPoint)
        );
    }

    public static final PointInRouteOfCollisionOutputDTOPlain fromObject(final PointInRouteOfCollisionOutputDTO dto) {
        return new PointInRouteOfCollisionOutputDTOPlain(
            dto.a,
            dto.b,
            dto.timeUntilCollision.value,
            CartesianPointPlain.fromObject(dto.collisionPoint),
            dto.timeDifferenceToPoint.value
        );
    }
}
