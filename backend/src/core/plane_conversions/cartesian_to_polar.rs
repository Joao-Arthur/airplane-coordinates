use crate::core::cartesian_plane::cartesian_point::CartesianPoint;
use crate::core::polar_plane::polar_point::PolarPoint;
use crate::core::trigonometry::deg_to_rad::deg_to_rad;
use crate::core::trigonometry::normalize_angle::normalize_angle;

pub fn cartesian_to_polar(cartesian_point: CartesianPoint) -> PolarPoint {
    PolarPoint {
        r: (cartesian_point.x.powi(2) + cartesian_point.y.powi(2)).sqrt(),
        a: normalize_angle(deg_to_rad(cartesian_point.y.atan2(cartesian_point.x))),
    }
}

#[cfg(test)]
mod test_cartesian_to_polar {
    use super::*;

    #[test]
    fn on_the_four_axis() {
        assert_eq!(
            cartesian_to_polar(CartesianPoint { x: 1.0, y: 0.0 }),
            PolarPoint { r: 1.0, a: 0.0 }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint { x: 0.0, y: 1.0 }),
            PolarPoint { r: 1.0, a: 90.0 }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint { x: -1.0, y: 0.0 }),
            PolarPoint { r: 1.0, a: 180.0 }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint { x: 0.0, y: -1.0 }),
            PolarPoint { r: 1.0, a: 270.0 }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint { x: 1.0, y: 0.0 }),
            PolarPoint { r: 1.0, a: 360.0 }
        );
    }

    #[test]
    fn inbetween_the_four_axis() {
        assert_eq!(
            cartesian_to_polar(CartesianPoint {
                x: 0.7071067812,
                y: 0.7071067812
            }),
            PolarPoint {
                r: 1.0000000000190246,
                a: 45.0
            }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint {
                x: -0.7071067812,
                y: 0.7071067812
            }),
            PolarPoint {
                r: 1.0000000000190246,
                a: 135.0
            }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint {
                x: -0.7071067812,
                y: -0.7071067812
            }),
            PolarPoint {
                r: 1.0000000000190246,
                a: 225.0
            }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint {
                x: 0.7071067812,
                y: -0.7071067812
            }),
            PolarPoint {
                r: 1.0000000000190246,
                a: 315.0
            }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint {
                x: 0.7071067812,
                y: 0.7071067812
            }),
            PolarPoint {
                r: 1.0000000000190246,
                a: 405.0
            }
        );
    }

    #[test]
    fn at_the_starting_point() {
        assert_eq!(
            cartesian_to_polar(CartesianPoint { x: 0.0, y: 0.0 }),
            PolarPoint { r: 0.0, a: 0.0 }
        );
    }
}
