use crate::core::cartesian_plane::cartesian_point::CartesianPoint;
use crate::core::polar_plane::polar_point::PolarPoint;
use crate::core::trigonometry::deg_to_rad::deg_to_rad;

pub fn polar_to_cartesian(cartesian_point: PolarPoint) -> CartesianPoint {
    return CartesianPoint {
        x: cartesian_point.r * deg_to_rad(cartesian_point.a).cos(),
        y: cartesian_point.r * deg_to_rad(cartesian_point.a).sin(),
    };
}

#[cfg(test)]
mod test_polar_to_cartesian {
    use super::*;

    #[test]
    fn expect_to_transform_polar_to_cartesian_on_the_four_axis() {
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
    fn expect_to_transform_polar_to_cartesian_inbetween_the_four_axis() {
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
    fn expect_to_transform_polar_to_cartesian_at_the_starting_point() {
        assert_eq!(
            polar_to_cartesian(PolarPoint { r: 0.0, a: 0.0 }),
            CartesianPoint { x: 0.0, y: 0.0 }
        );
    }
}
