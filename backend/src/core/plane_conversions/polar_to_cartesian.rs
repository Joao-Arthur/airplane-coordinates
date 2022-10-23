use crate::core::cartesian_plane::cartesian_point::{CartesianPoint, NewCartesianPoint};
use crate::core::math::MathOperations;
use crate::core::polar_plane::polar_point::{NewPolarPoint, PolarPoint};
use crate::core::trigonometry::deg_to_rad::{deg_to_rad, new_deg_to_rad};

pub fn polar_to_cartesian(cartesian_point: PolarPoint) -> CartesianPoint {
    CartesianPoint {
        x: cartesian_point.r * deg_to_rad(cartesian_point.a).cos(),
        y: cartesian_point.r * deg_to_rad(cartesian_point.a).sin(),
    }
}

pub fn new_polar_to_cartesian(cartesian_point: NewPolarPoint) -> NewCartesianPoint {
    let angular_value = new_deg_to_rad(cartesian_point.a);
    let radius_value = cartesian_point.r;

    NewCartesianPoint {
        x: radius_value * angular_value.cos(),
        y: radius_value * angular_value.sin(),
    }
}

#[cfg(test)]
mod test_polar_to_cartesian {
    use super::*;

    #[test]
    fn on_the_four_axis() {
        assert_eq!(
            polar_to_cartesian(PolarPoint { r: 1.0, a: 0.0 }),
            CartesianPoint {
                x: 1.0,
                y: 0.00000000000000006123233995736766
            }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint { r: 1.0, a: 90.0 }),
            CartesianPoint {
                x: 0.00000000000000006123233995736766,
                y: 1.0
            }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint { r: 1.0, a: 180.0 }),
            CartesianPoint {
                x: -1.0,
                y: 0.00000000000000006123233995736766
            }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint { r: 1.0, a: 270.0 }),
            CartesianPoint {
                x: -0.00000000000000018369701987210297,
                y: -1.0
            }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint { r: 1.0, a: 360.0 }),
            CartesianPoint {
                x: 1.0,
                y: 0.00000000000000006123233995736766
            }
        );
    }

    #[test]
    fn inbetween_the_four_axis() {
        assert_eq!(
            polar_to_cartesian(PolarPoint { r: 1.0, a: 45.0 }),
            CartesianPoint {
                x: 0.7071067811865476,
                y: 0.7071067811865475
            }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint { r: 1.0, a: 135.0 }),
            CartesianPoint {
                x: -0.7071067811865475,
                y: 0.7071067811865476
            }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint { r: 1.0, a: 225.0 }),
            CartesianPoint {
                x: -0.7071067811865477,
                y: -0.7071067811865475
            }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint { r: 1.0, a: 315.0 }),
            CartesianPoint {
                x: 0.7071067811865474,
                y: -0.7071067811865477
            }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint { r: 1.0, a: 405.0 }),
            CartesianPoint {
                x: 0.7071067811865483,
                y: 0.7071067811865467
            }
        );
    }

    #[test]
    fn at_the_starting_point() {
        assert_eq!(
            polar_to_cartesian(PolarPoint { r: 0.0, a: 0.0 }),
            CartesianPoint { x: 0.0, y: 0.0 }
        );
    }
}
