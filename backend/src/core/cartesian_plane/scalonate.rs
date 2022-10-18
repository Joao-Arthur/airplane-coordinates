use super::cartesian_point::CartesianPoint;

pub fn scalonate(point: CartesianPoint, factor: CartesianPoint) -> CartesianPoint {
    return point * factor;
}
