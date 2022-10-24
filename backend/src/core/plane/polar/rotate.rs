use crate::core::precise_decimal::PreciseDecimal;
use crate::core::trigonometry::normalize_angle::normalize_angle;

use super::polar_point::PolarPoint;

pub fn rotate(point: PolarPoint, angle: PreciseDecimal) -> PolarPoint {
    PolarPoint {
        r: point.r,
        a: normalize_angle(point.a + angle),
    }
}

#[cfg(test)]
mod test_rotate {
    use super::*;

    #[test]
    fn expect_to_rotate() {
        assert_eq!(
            rotate(
                PolarPoint {
                    r: PreciseDecimal::from_str("1"),
                    a: PreciseDecimal::from_str("300")
                },
                PreciseDecimal::from_str("50")
            ),
            PolarPoint {
                r: PreciseDecimal::from_str("1"),
                a: PreciseDecimal::from_str("350")
            }
        );
        assert_eq!(
            rotate(
                PolarPoint {
                    r: PreciseDecimal::from_str("1"),
                    a: PreciseDecimal::from_str("200")
                },
                PreciseDecimal::from_str("50")
            ),
            PolarPoint {
                r: PreciseDecimal::from_str("1"),
                a: PreciseDecimal::from_str("250")
            }
        );
        assert_eq!(
            rotate(
                PolarPoint {
                    r: PreciseDecimal::from_str("1"),
                    a: PreciseDecimal::from_str("111.11")
                },
                PreciseDecimal::from_str("11.40")
            ),
            PolarPoint {
                r: PreciseDecimal::from_str("1"),
                a: PreciseDecimal::from_str("122.51")
            }
        );
        assert_eq!(
            rotate(
                PolarPoint {
                    r: PreciseDecimal::from_str("1"),
                    a: PreciseDecimal::from_str("342")
                },
                PreciseDecimal::from_str("194")
            ),
            PolarPoint {
                r: PreciseDecimal::from_str("1"),
                a: PreciseDecimal::from_str("176")
            }
        );
        assert_eq!(
            rotate(
                PolarPoint {
                    r: PreciseDecimal::from_str("1"),
                    a: PreciseDecimal::from_str("60")
                },
                PreciseDecimal::from_str("-120")
            ),
            PolarPoint {
                r: PreciseDecimal::from_str("1"),
                a: PreciseDecimal::from_str("300")
            }
        );
        assert_eq!(
            rotate(
                PolarPoint {
                    r: PreciseDecimal::from_str("1"),
                    a: PreciseDecimal::from_str("60")
                },
                PreciseDecimal::from_str("-60")
            ),
            PolarPoint {
                r: PreciseDecimal::from_str("1"),
                a: PreciseDecimal::from_str("0")
            }
        );
    }
}
