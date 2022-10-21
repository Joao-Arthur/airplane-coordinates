use super::airplane_point::AirplanePoint;
use super::planes::Planes;
use crate::core::cartesian_plane::cartesian_point::CartesianPoint;
use crate::core::plane_conversions::polar_to_cartesian::polar_to_cartesian;
use crate::core::polar_plane::polar_point::PolarPoint;

pub fn cartesian_point_from_api(point: AirplanePoint) -> CartesianPoint {
    return match point.plane {
        Planes::CARTESIAN => CartesianPoint {
            x: point.a.parse().unwrap(),
            y: point.b.parse().unwrap(),
        },
        Planes::POLAR => polar_to_cartesian(PolarPoint {
            r: point.a.parse::<f64>().unwrap(),
            a: point.b.parse::<f64>().unwrap(),
        }),
    };
}
