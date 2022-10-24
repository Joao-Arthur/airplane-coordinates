use crate::core::math::MathOperations;
use crate::core::trigonometry::normalize_angle::normalize_angle;
use crate::core::trigonometry::rad_to_deg::rad_to_deg;

use super::super::cartesian::cartesian_point::CartesianPoint;
use super::super::polar::polar_point::PolarPoint;

pub fn cartesian_to_polar(cartesian_point: CartesianPoint) -> PolarPoint {
    PolarPoint {
        r: (cartesian_point.x.square() + cartesian_point.y.square()).sqrt(),
        a: normalize_angle(rad_to_deg(cartesian_point.y.atan(cartesian_point.x))),
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
                a: PreciseDecimal::from_str("89.99999999999999889812643261")
            }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint {
                x: PreciseDecimal::from_int(-1),
                y: PreciseDecimal::from_int(0)
            }),
            PolarPoint {
                r: PreciseDecimal::from_str("1.0000000000000000000000000000"),
                a: PreciseDecimal::from_str("179.9999999999999863370969626")
            }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint {
                x: PreciseDecimal::from_int(0),
                y: PreciseDecimal::from_int(-1)
            }),
            PolarPoint {
                r: PreciseDecimal::from_str("1.0000000000000000000000000000"),
                a: PreciseDecimal::from_str("270.00000000000000110187356739")
            }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint {
                x: PreciseDecimal::from_int(1),
                y: PreciseDecimal::from_int(0)
            }),
            PolarPoint {
                r: PreciseDecimal::from_str("1.0000000000000000000000000000"),
                a: PreciseDecimal::from_str("0")
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
                a: PreciseDecimal::from_str("44.99999999999999944906321630")
            }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint {
                x: PreciseDecimal::from_str("-0.7071067811865475244008443621"),
                y: PreciseDecimal::from_str("0.7071067811865475244008443621")
            }),
            PolarPoint {
                r: PreciseDecimal::from_str("1.0000000000000000000000000000"),
                a: PreciseDecimal::from_str("135.00000000000000407676760022")
            }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint {
                x: PreciseDecimal::from_str("-0.7071067811865475244008443621"),
                y: PreciseDecimal::from_str("-0.7071067811865475244008443621")
            }),
            PolarPoint {
                r: PreciseDecimal::from_str("1.0000000000000000000000000000"),
                a: PreciseDecimal::from_str("224.99999999999999592323239978")
            }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint {
                x: PreciseDecimal::from_str("0.7071067811865475244008443621"),
                y: PreciseDecimal::from_str("-0.7071067811865475244008443621")
            }),
            PolarPoint {
                r: PreciseDecimal::from_str("1.0000000000000000000000000000"),
                a: PreciseDecimal::from_str("315.00000000000000055093678370")
            }
        );
        assert_eq!(
            cartesian_to_polar(CartesianPoint {
                x: PreciseDecimal::from_str("0.7071067811865475244008443621"),
                y: PreciseDecimal::from_str("0.7071067811865475244008443621")
            }),
            PolarPoint {
                r: PreciseDecimal::from_str("1.0000000000000000000000000000"),
                a: PreciseDecimal::from_str("44.99999999999999944906321630")
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
