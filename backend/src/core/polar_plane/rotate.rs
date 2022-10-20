
pub fn rotate(point: PolarPoint, angle: f64) -> PolarPoint {
    return PolarPoint {
        r: point.radius,
        a: trigonometry.simplify_angle(point.a + angle),
    };
}
