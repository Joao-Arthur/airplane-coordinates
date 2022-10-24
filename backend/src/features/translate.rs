use crate::core::plane::cartesian::cartesian_point::CartesianPoint;
use crate::core::plane::plane::Plane;
use crate::core::plane::plane_point::PlanePoint;

pub fn translate(point: PlanePoint, factor: CartesianPoint) -> PlanePoint {
    match point.plane_type {
        Plane::CARTESIAN => point,
        Plane::POLAR => point,
    }
}

#[cfg(test)]
mod test_translate {}
