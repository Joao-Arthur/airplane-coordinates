use super::polar_point::PolarPoint;
use crate::core::trigonometry::normalize_angle::normalize_angle;

pub fn rotate(point: PolarPoint, angle: f64) -> PolarPoint {
    return PolarPoint {
        r: point.r,
        a: normalize_angle(point.a + angle),
    };
}
