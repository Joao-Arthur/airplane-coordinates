use crate::core::math::MathOperations;
use crate::core::precise_decimal::PreciseDecimal;

use super::cartesian_point::CartesianPoint;

pub fn distance(a: CartesianPoint, b: CartesianPoint) -> PreciseDecimal {
    let delta_x = a.x - b.x;
    let delta_y = a.y - b.y;

    (delta_x.square() + delta_y.square()).sqrt()
}

#[cfg(test)]
mod test_distance {
    use super::*;

    #[test]
    fn in_the_same_point() {
        assert_eq!(
            distance(
                CartesianPoint {
                    x: PreciseDecimal::from_int(0),
                    y: PreciseDecimal::from_int(0)
                },
                CartesianPoint {
                    x: PreciseDecimal::from_int(0),
                    y: PreciseDecimal::from_int(0)
                },
            ),
            PreciseDecimal::from_int(0)
        );
        assert_eq!(
            distance(
                CartesianPoint {
                    x: PreciseDecimal::from_int(1),
                    y: PreciseDecimal::from_int(1)
                },
                CartesianPoint {
                    x: PreciseDecimal::from_int(1),
                    y: PreciseDecimal::from_int(1)
                },
            ),
            PreciseDecimal::from_int(0)
        );
    }

    #[test]
    fn in_the_x_axis() {
        assert_eq!(
            distance(
                CartesianPoint {
                    x: PreciseDecimal::from_int(-10),
                    y: PreciseDecimal::from_int(5)
                },
                CartesianPoint {
                    x: PreciseDecimal::from_int(20),
                    y: PreciseDecimal::from_int(5)
                },
            ),
            PreciseDecimal::from_str("30.000000000000000000000000000")
        );
    }

    #[test]
    fn in_the_y_axis() {
        assert_eq!(
            distance(
                CartesianPoint {
                    x: PreciseDecimal::from_int(5),
                    y: PreciseDecimal::from_int(10)
                },
                CartesianPoint {
                    x: PreciseDecimal::from_int(5),
                    y: PreciseDecimal::from_int(-20)
                },
            ),
            PreciseDecimal::from_str("30.000000000000000000000000000")
        );
    }

    #[test]
    fn in_the_x_and_y_axis() {
        assert_eq!(
            distance(
                CartesianPoint {
                    x: PreciseDecimal::from_int(0),
                    y: PreciseDecimal::from_int(0)
                },
                CartesianPoint {
                    x: PreciseDecimal::from_int(1),
                    y: PreciseDecimal::from_int(1)
                },
            ),
            PreciseDecimal::from_str("1.4142135623730950488016887242")
        );
        assert_eq!(
            distance(
                CartesianPoint {
                    x: PreciseDecimal::from_int(-1),
                    y: PreciseDecimal::from_int(-1)
                },
                CartesianPoint {
                    x: PreciseDecimal::from_int(1),
                    y: PreciseDecimal::from_int(1)
                },
            ),
            PreciseDecimal::from_str("2.8284271247461900976033774484")
        );
    }
}
