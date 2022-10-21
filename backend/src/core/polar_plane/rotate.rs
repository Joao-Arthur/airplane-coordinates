use super::polar_point::PolarPoint;
use crate::core::trigonometry::simplify_angle::simplify_angle;

pub fn rotate(point: PolarPoint, angle: f64) -> PolarPoint {
    return PolarPoint {
        r: point.r,
        a: simplify_angle(point.a + angle),
    };
}
