use crate::core::math::MathOperations;
use crate::core::trigonometry::deg_to_rad::deg_to_rad;
use crate::core::trigonometry::normalize_angle::normalize_angle;

use super::super::cartesian::cartesian_point::CartesianPoint;
use super::super::polar::polar_point::PolarPoint;

pub fn polar_to_cartesian(cartesian_point: PolarPoint) -> CartesianPoint {
    CartesianPoint {
        x: cartesian_point.r.clone() * deg_to_rad(normalize_angle(cartesian_point.a.clone())).cos(),
        y: cartesian_point.r * deg_to_rad(normalize_angle(cartesian_point.a)).sin(),
    }
}

#[cfg(test)]
mod test_polar_to_cartesian {
    use super::*;
    use crate::core::precise_decimal::PreciseDecimal;

    #[test]
    fn on_the_four_axis() {
        assert_eq!(
            polar_to_cartesian(PolarPoint {
                r: PreciseDecimal::from_int(1),
                a: PreciseDecimal::from_int(0)
            }),
            CartesianPoint {
                x: PreciseDecimal::from_int(1),
                y: PreciseDecimal::from_int(0)
            }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint {
                r: PreciseDecimal::from_int(1),
                a: PreciseDecimal::from_int(90)
            }),
            CartesianPoint {
                x: PreciseDecimal::from_str("-0.0000000000000000000000000001"),
                y: PreciseDecimal::from_int(1)
            }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint {
                r: PreciseDecimal::from_int(1),
                a: PreciseDecimal::from_int(180)
            }),
            CartesianPoint {
                x: PreciseDecimal::from_int(-1),
                y: PreciseDecimal::from_int(0)
            }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint {
                r: PreciseDecimal::from_int(1),
                a: PreciseDecimal::from_int(270)
            }),
            CartesianPoint {
                x: PreciseDecimal::from_str("0.0000000000000000000000000001"),
                y: PreciseDecimal::from_int(-1)
            }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint {
                r: PreciseDecimal::from_int(1),
                a: PreciseDecimal::from_int(360)
            }),
            CartesianPoint {
                x: PreciseDecimal::from_int(1),
                y: PreciseDecimal::from_int(0)
            }
        );
    }

    #[test]
    fn inbetween_the_four_axis() {
        assert_eq!(
            polar_to_cartesian(PolarPoint {
                r: PreciseDecimal::from_int(1),
                a: PreciseDecimal::from_int(45)
            }),
            CartesianPoint {
                x: PreciseDecimal::from_str("0.7071067811865475244008443621"),
                y: PreciseDecimal::from_str("0.7071067811865475244008443621")
            }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint {
                r: PreciseDecimal::from_int(1),
                a: PreciseDecimal::from_int(135)
            }),
            CartesianPoint {
                x: PreciseDecimal::from_str("-0.7071067811865475244008443621"),
                y: PreciseDecimal::from_str("0.7071067811865475244008443621")
            }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint {
                r: PreciseDecimal::from_int(1),
                a: PreciseDecimal::from_int(225)
            }),
            CartesianPoint {
                x: PreciseDecimal::from_str("-0.7071067811865475244008443621"),
                y: PreciseDecimal::from_str("-0.7071067811865475244008443621")
            }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint {
                r: PreciseDecimal::from_int(1),
                a: PreciseDecimal::from_int(315)
            }),
            CartesianPoint {
                x: PreciseDecimal::from_str("0.7071067811865475244008443621"),
                y: PreciseDecimal::from_str("-0.7071067811865475244008443621")
            }
        );
        assert_eq!(
            polar_to_cartesian(PolarPoint {
                r: PreciseDecimal::from_int(1),
                a: PreciseDecimal::from_int(405)
            }),
            CartesianPoint {
                x: PreciseDecimal::from_str("0.7071067811865475244008443621"),
                y: PreciseDecimal::from_str("0.7071067811865475244008443621")
            }
        );
    }

    #[test]
    fn at_the_starting_point() {
        assert_eq!(
            polar_to_cartesian(PolarPoint {
                r: PreciseDecimal::from_int(0),
                a: PreciseDecimal::from_int(0)
            }),
            CartesianPoint {
                x: PreciseDecimal::from_int(0),
                y: PreciseDecimal::from_int(0)
            }
        );
    }
}
