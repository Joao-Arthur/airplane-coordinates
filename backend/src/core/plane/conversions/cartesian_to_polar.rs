use super::super::cartesian::cartesian_point::CartesianPoint;
use super::super::polar::polar_point::PolarPoint;
use crate::core::math::MathOperations;
use crate::core::trigonometry::deg_to_rad::deg_to_rad;
use crate::core::trigonometry::normalize_angle::normalize_angle;

pub fn cartesian_to_polar(cartesian_point: CartesianPoint) -> PolarPoint {
    PolarPoint {
        r: (cartesian_point.x.square() + cartesian_point.y.square()).sqrt(),
        a: normalize_angle(deg_to_rad(cartesian_point.y.atan(cartesian_point.x))),
    }
}

#[cfg(test)]
mod test_cartesian_to_polar {
    use crate::core::precise_decimal::PreciseDecimal;

    use super::*;

    #[test]
    fn on_the_four_axis() {
        assert_eq!(
            cartesian_to_polar(CartesianPoint {
                x: PreciseDecimal::from_int(1),
                y: PreciseDecimal::from_int(0)
            }),
            PolarPoint {
                r: PreciseDecimal::from_str("1.0000000000000000000000000000"),
                a: PreciseDecimal::from_int(0)
            }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint {
                x: PreciseDecimal::from_int(0),
                y: PreciseDecimal::from_int(1)
            }),
            PolarPoint {
                r: PreciseDecimal::from_str("1.0000000000000000000000000000"),
                a: PreciseDecimal::from_int(90)
            }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint {
                x: PreciseDecimal::from_int(-1),
                y: PreciseDecimal::from_int(0)
            }),
            PolarPoint {
                r: PreciseDecimal::from_str("1.0000000000000000000000000000"),
                a: PreciseDecimal::from_int(180)
            }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint {
                x: PreciseDecimal::from_int(0),
                y: PreciseDecimal::from_int(-1)
            }),
            PolarPoint {
                r: PreciseDecimal::from_str("1.0000000000000000000000000000"),
                a: PreciseDecimal::from_int(270)
            }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint {
                x: PreciseDecimal::from_int(1),
                y: PreciseDecimal::from_int(0)
            }),
            PolarPoint {
                r: PreciseDecimal::from_str("1.0000000000000000000000000000"),
                a: PreciseDecimal::from_int(360)
            }
        );
    }

    #[test]
    fn inbetween_the_four_axis() {
        assert_eq!(
            cartesian_to_polar(CartesianPoint {
                x: PreciseDecimal::from_str("0.7071067811865475244008443621"),
                y: PreciseDecimal::from_str("0.7071067811865475244008443621")
            }),
            PolarPoint {
                r: PreciseDecimal::from_str("1.0000000000000000000000000000"),
                a: PreciseDecimal::from_int(45)
            }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint {
                x: PreciseDecimal::from_str("-0.7071067811865475244008443621"),
                y: PreciseDecimal::from_str("0.7071067811865475244008443621")
            }),
            PolarPoint {
                r: PreciseDecimal::from_str("1.0000000000000000000000000000"),
                a: PreciseDecimal::from_int(135)
            }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint {
                x: PreciseDecimal::from_str("-0.7071067811865475244008443621"),
                y: PreciseDecimal::from_str("-0.7071067811865475244008443621")
            }),
            PolarPoint {
                r: PreciseDecimal::from_str("1.0000000000000000000000000000"),
                a: PreciseDecimal::from_int(225)
            }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint {
                x: PreciseDecimal::from_str("0.7071067811865475244008443621"),
                y: PreciseDecimal::from_str("-0.7071067811865475244008443621")
            }),
            PolarPoint {
                r: PreciseDecimal::from_str("1.0000000000000000000000000000"),
                a: PreciseDecimal::from_int(315)
            }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint {
                x: PreciseDecimal::from_str("0.7071067811865475244008443621"),
                y: PreciseDecimal::from_str("0.7071067811865475244008443621")
            }),
            PolarPoint {
                r: PreciseDecimal::from_str("1.0000000000000000000000000000"),
                a: PreciseDecimal::from_int(405)
            }
        );
    }

    #[test]
    fn at_the_starting_point() {
        assert_eq!(
            cartesian_to_polar(CartesianPoint {
                x: PreciseDecimal::from_int(0),
                y: PreciseDecimal::from_int(0)
            }),
            PolarPoint {
                r: PreciseDecimal::from_int(0),
                a: PreciseDecimal::from_int(0)
            }
        );
    }
}
