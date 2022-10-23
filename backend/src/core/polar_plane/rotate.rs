use super::polar_point::NewPolarPoint;
use crate::core::precise_decimal::PreciseDecimal;
use crate::core::trigonometry::normalize_angle::new_normalize_angle;

pub fn rotate(point: NewPolarPoint, angle: &str) -> NewPolarPoint {
    return NewPolarPoint {
        r: point.r,
        a: new_normalize_angle(
            PreciseDecimal::from_string(point.a) + PreciseDecimal::from_str(angle),
        )
        .value,
    };
}

#[cfg(test)]
mod test_rotate {
    use super::*;

    #[test]
    fn expect_to_rotate() {
        assert_eq!(
            rotate(
                NewPolarPoint {
                    r: "1".to_string(),
                    a: "300".to_string()
                },
                "50"
            ),
            NewPolarPoint {
                r: "1".to_string(),
                a: "350".to_string()
            }
        );
        assert_eq!(
            rotate(
                NewPolarPoint {
                    r: "1".to_string(),
                    a: "200".to_string()
                },
                "50"
            ),
            NewPolarPoint {
                r: "1".to_string(),
                a: "250".to_string()
            }
        );
        assert_eq!(
            rotate(
                NewPolarPoint {
                    r: "1".to_string(),
                    a: "111.11".to_string()
                },
                "11.40"
            ),
            NewPolarPoint {
                r: "1".to_string(),
                a: "122.51".to_string()
            }
        );
        assert_eq!(
            rotate(
                NewPolarPoint {
                    r: "1".to_string(),
                    a: "342".to_string()
                },
                "194"
            ),
            NewPolarPoint {
                r: "1".to_string(),
                a: "536".to_string()
            }
        );
        assert_eq!(
            rotate(
                NewPolarPoint {
                    r: "1".to_string(),
                    a: "60".to_string()
                },
                "-120"
            ),
            NewPolarPoint {
                r: "1".to_string(),
                a: "300".to_string()
            }
        );
        assert_eq!(
            rotate(
                NewPolarPoint {
                    r: "1".to_string(),
                    a: "60".to_string()
                },
                "-60"
            ),
            NewPolarPoint {
                r: "1".to_string(),
                a: "0".to_string()
            }
        );
    }
}
