use super::polar_point::NewPolarPoint;
use crate::core::precise_decimal::PreciseDecimal;
use crate::core::trigonometry::normalize_angle::new_normalize_angle;

pub fn rotate(point: NewPolarPoint, angle: &str) -> NewPolarPoint {
    NewPolarPoint {
        r: point.r,
        a: new_normalize_angle(point.a + PreciseDecimal::from_str(angle)),
    }
}

#[cfg(test)]
mod test_rotate {
    use super::*;

    #[test]
    fn expect_to_rotate() {
        assert_eq!(
            rotate(
                NewPolarPoint {
                    r: PreciseDecimal::from_str("1"),
                    a: PreciseDecimal::from_str("300")
                },
                "50"
            ),
            NewPolarPoint {
                r: PreciseDecimal::from_str("1"),
                a: PreciseDecimal::from_str("350")
            }
        );
        assert_eq!(
            rotate(
                NewPolarPoint {
                    r: PreciseDecimal::from_str("1"),
                    a: PreciseDecimal::from_str("200")
                },
                "50"
            ),
            NewPolarPoint {
                r: PreciseDecimal::from_str("1"),
                a: PreciseDecimal::from_str("250")
            }
        );
        assert_eq!(
            rotate(
                NewPolarPoint {
                    r: PreciseDecimal::from_str("1"),
                    a: PreciseDecimal::from_str("111.11")
                },
                "11.40"
            ),
            NewPolarPoint {
                r: PreciseDecimal::from_str("1"),
                a: PreciseDecimal::from_str("122.51")
            }
        );
        assert_eq!(
            rotate(
                NewPolarPoint {
                    r: PreciseDecimal::from_str("1"),
                    a: PreciseDecimal::from_str("342")
                },
                "194"
            ),
            NewPolarPoint {
                r: PreciseDecimal::from_str("1"),
                a: PreciseDecimal::from_str("536")
            }
        );
        assert_eq!(
            rotate(
                NewPolarPoint {
                    r: PreciseDecimal::from_str("1"),
                    a: PreciseDecimal::from_str("60")
                },
                "-120"
            ),
            NewPolarPoint {
                r: PreciseDecimal::from_str("1"),
                a: PreciseDecimal::from_str("300")
            }
        );
        assert_eq!(
            rotate(
                NewPolarPoint {
                    r: PreciseDecimal::from_str("1"),
                    a: PreciseDecimal::from_str("60")
                },
                "-60"
            ),
            NewPolarPoint {
                r: PreciseDecimal::from_str("1"),
                a: PreciseDecimal::from_str("0")
            }
        );
    }
}
