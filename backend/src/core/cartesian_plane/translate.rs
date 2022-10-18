use super::cartesian_point::CartesianPoint;

pub fn translate(point: CartesianPoint, factor: CartesianPoint) -> CartesianPoint {
    return point + factor;
}
