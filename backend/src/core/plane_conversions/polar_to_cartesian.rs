use crate::core::cartesian_plane::cartesian_point::NewCartesianPoint;
use crate::core::math::MathOperations;
use crate::core::polar_plane::polar_point::NewPolarPoint;
use crate::core::trigonometry::deg_to_rad::new_deg_to_rad;
use crate::core::trigonometry::normalize_angle::new_normalize_angle;

pub fn polar_to_cartesian(cartesian_point: NewPolarPoint) -> NewCartesianPoint {
    NewCartesianPoint {
        x: cartesian_point.r.clone()
            * new_deg_to_rad(new_normalize_angle(cartesian_point.a.clone())).cos(),
        y: cartesian_point.r * new_deg_to_rad(new_normalize_angle(cartesian_point.a)).sin(),
    }
}

#[cfg(test)]
mod test_polar_to_cartesian {
    use super::*;
    use crate::core::precise_decimal::PreciseDecimal;

    #[test]
    fn on_the_four_axis() {
        assert_eq!(
            polar_to_cartesian(NewPolarPoint {
                r: PreciseDecimal::from_int(1),
                a: PreciseDecimal::from_int(0)
            }),
            NewCartesianPoint {
                x: PreciseDecimal::from_int(1),
                y: PreciseDecimal::from_int(0)
            }
        );
        assert_eq!(
            polar_to_cartesian(NewPolarPoint {
                r: PreciseDecimal::from_int(1),
                a: PreciseDecimal::from_int(90)
            }),
            NewCartesianPoint {
                x: PreciseDecimal::from_str("-0.0000000000000000000000000001"),
                y: PreciseDecimal::from_int(1)
            }
        );
        assert_eq!(
            polar_to_cartesian(NewPolarPoint {
                r: PreciseDecimal::from_int(1),
                a: PreciseDecimal::from_int(180)
            }),
            NewCartesianPoint {
                x: PreciseDecimal::from_int(-1),
                y: PreciseDecimal::from_int(0)
            }
        );
        assert_eq!(
            polar_to_cartesian(NewPolarPoint {
                r: PreciseDecimal::from_int(1),
                a: PreciseDecimal::from_int(270)
            }),
            NewCartesianPoint {
                x: PreciseDecimal::from_str("0.0000000000000000000000000001"),
                y: PreciseDecimal::from_int(-1)
            }
        );
        assert_eq!(
            polar_to_cartesian(NewPolarPoint {
                r: PreciseDecimal::from_int(1),
                a: PreciseDecimal::from_int(360)
            }),
            NewCartesianPoint {
                x: PreciseDecimal::from_int(1),
                y: PreciseDecimal::from_int(0)
            }
        );
    }

    #[test]
    fn inbetween_the_four_axis() {
        assert_eq!(
            polar_to_cartesian(NewPolarPoint {
                r: PreciseDecimal::from_int(1),
                a: PreciseDecimal::from_int(45)
            }),
            NewCartesianPoint {
                x: PreciseDecimal::from_str("0.7071067811865475244008443621"),
                y: PreciseDecimal::from_str("0.7071067811865475244008443621")
            }
        );
        assert_eq!(
            polar_to_cartesian(NewPolarPoint {
                r: PreciseDecimal::from_int(1),
                a: PreciseDecimal::from_int(135)
            }),
            NewCartesianPoint {
                x: PreciseDecimal::from_str("-0.7071067811865475244008443621"),
                y: PreciseDecimal::from_str("0.7071067811865475244008443621")
            }
        );
        assert_eq!(
            polar_to_cartesian(NewPolarPoint {
                r: PreciseDecimal::from_int(1),
                a: PreciseDecimal::from_int(225)
            }),
            NewCartesianPoint {
                x: PreciseDecimal::from_str("-0.7071067811865475244008443621"),
                y: PreciseDecimal::from_str("-0.7071067811865475244008443621")
            }
        );
        assert_eq!(
            polar_to_cartesian(NewPolarPoint {
                r: PreciseDecimal::from_int(1),
                a: PreciseDecimal::from_int(315)
            }),
            NewCartesianPoint {
                x: PreciseDecimal::from_str("0.7071067811865475244008443621"),
                y: PreciseDecimal::from_str("-0.7071067811865475244008443621")
            }
        );
        assert_eq!(
            polar_to_cartesian(NewPolarPoint {
                r: PreciseDecimal::from_int(1),
                a: PreciseDecimal::from_int(405)
            }),
            NewCartesianPoint {
                x: PreciseDecimal::from_str("0.7071067811865475244008443621"),
                y: PreciseDecimal::from_str("0.7071067811865475244008443621")
            }
        );
    }

    #[test]
    fn at_the_starting_point() {
        assert_eq!(
            polar_to_cartesian(NewPolarPoint {
                r: PreciseDecimal::from_int(0),
                a: PreciseDecimal::from_int(0)
            }),
            NewCartesianPoint {
                x: PreciseDecimal::from_int(0),
                y: PreciseDecimal::from_int(0)
            }
        );
    }
}
