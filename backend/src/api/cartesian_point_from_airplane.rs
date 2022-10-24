use super::airplane_point::AirplanePoint;
use super::planes::Planes;
use crate::core::cartesian_plane::cartesian_point::CartesianPoint;
use crate::core::plane_conversions::polar_to_cartesian::polar_to_cartesian;
use crate::core::polar_plane::polar_point::PolarPoint;
use crate::core::precise_decimal::PreciseDecimal;

pub fn cartesian_point_from_api(point: AirplanePoint) -> CartesianPoint {
    match point.plane {
        Planes::CARTESIAN => CartesianPoint {
            x: PreciseDecimal::from_string(point.a),
            y: PreciseDecimal::from_string(point.b),
        },
        Planes::POLAR => polar_to_cartesian(PolarPoint {
            r: PreciseDecimal::from_string(point.a),
            a: PreciseDecimal::from_string(point.b),
        }),
    }
}
