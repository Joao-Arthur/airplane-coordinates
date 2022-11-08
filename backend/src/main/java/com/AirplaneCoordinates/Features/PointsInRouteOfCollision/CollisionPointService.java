public interface CollisionPointService {
    public final PointsCollisionDTO getCollisionPoint(
        final PlanePointWithVector pointA,
        final PlanePointWithVector pointB
    );
}