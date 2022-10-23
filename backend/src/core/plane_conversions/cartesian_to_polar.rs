use crate::core::cartesian_plane::cartesian_point::{CartesianPoint, NewCartesianPoint};
use crate::core::math::MathOperations;
use crate::core::polar_plane::polar_point::{NewPolarPoint, PolarPoint};
use crate::core::trigonometry::deg_to_rad::{deg_to_rad, new_deg_to_rad};
use crate::core::trigonometry::normalize_angle::{new_normalize_angle, normalize_angle};

pub fn cartesian_to_polar(cartesian_point: CartesianPoint) -> PolarPoint {
    PolarPoint {
        r: (cartesian_point.x.powi(2) + cartesian_point.y.powi(2)).sqrt(),
        a: normalize_angle(deg_to_rad(cartesian_point.y.atan2(cartesian_point.x))),
    }
}

//pub fn new_cartesian_to_polar(cartesian_point: NewCartesianPoint) -> NewPolarPoint {
//    NewPolarPoint {
//        r: (cartesian_point.x.square() + cartesian_point.y.square()).sqrt(),
//        a: new_normalize_angle(new_deg_to_rad(cartesian_point.y.atan2(cartesian_point.x))),
//    }
//}

//#[cfg(test)]
//mod test_cartesian_to_polar {
//    use crate::core::precise_decimal::PreciseDecimal;
//
//    use super::*;
//
//    #[test]
//    fn on_the_four_axis() {
//        assert_eq!(
//            new_cartesian_to_polar(NewCartesianPoint {
//                x: PreciseDecimal::from_int(1),
//                y: PreciseDecimal::from_int(0)
//            }),
//            NewPolarPoint {
//                r: PreciseDecimal::from_int(1),
//                a: PreciseDecimal::from_int(0)
//            }
//        );
//        assert_eq!(
//            new_cartesian_to_polar(NewCartesianPoint {
//                x: PreciseDecimal::from_int(0),
//                y: PreciseDecimal::from_int(1)
//            }),
//            NewPolarPoint {
//                r: PreciseDecimal::from_int(1),
//                a: PreciseDecimal::from_int(90)
//            }
//        );
//        assert_eq!(
//            new_cartesian_to_polar(NewCartesianPoint {
//                x: PreciseDecimal::from_int(-1),
//                y: PreciseDecimal::from_int(0)
//            }),
//            NewPolarPoint {
//                r: PreciseDecimal::from_int(1),
//                a: PreciseDecimal::from_int(180)
//            }
//        );
//        assert_eq!(
//            new_cartesian_to_polar(NewCartesianPoint {
//                x: PreciseDecimal::from_int(0),
//                y: PreciseDecimal::from_int(-1)
//            }),
//            NewPolarPoint {
//                r: PreciseDecimal::from_int(1),
//                a: PreciseDecimal::from_int(270)
//            }
//        );
//        assert_eq!(
//            new_cartesian_to_polar(NewCartesianPoint {
//                x: PreciseDecimal::from_int(1),
//                y: PreciseDecimal::from_int(0)
//            }),
//            NewPolarPoint {
//                r: PreciseDecimal::from_int(1),
//                a: PreciseDecimal::from_int(360)
//            }
//        );
//    }
//
//    #[test]
//    fn inbetween_the_four_axis() {
//        assert_eq!(
//            new_cartesian_to_polar(NewCartesianPoint {
//                x: PreciseDecimal::from_str("0.7071067812"),
//                y: PreciseDecimal::from_str("0.7071067812")
//            }),
//            NewPolarPoint {
//                r: PreciseDecimal::from_int(1),
//                a: PreciseDecimal::from_int(45)
//            }
//        );
//        assert_eq!(
//            new_cartesian_to_polar(NewCartesianPoint {
//                x: PreciseDecimal::from_str("-0.7071067812"),
//                y: PreciseDecimal::from_str("0.7071067812")
//            }),
//            NewPolarPoint {
//                r: PreciseDecimal::from_int(1),
//                a: PreciseDecimal::from_int(135)
//            }
//        );
//        assert_eq!(
//            new_cartesian_to_polar(NewCartesianPoint {
//                x: PreciseDecimal::from_str("-0.7071067812"),
//                y: PreciseDecimal::from_str("-0.7071067812")
//            }),
//            NewPolarPoint {
//                r: PreciseDecimal::from_int(1),
//                a: PreciseDecimal::from_int(225)
//            }
//        );
//        assert_eq!(
//            new_cartesian_to_polar(NewCartesianPoint {
//                x: PreciseDecimal::from_str("0.7071067812"),
//                y: PreciseDecimal::from_str("-0.7071067812")
//            }),
//            NewPolarPoint {
//                r: PreciseDecimal::from_int(1),
//                a: PreciseDecimal::from_int(315)
//            }
//        );
//        assert_eq!(
//            new_cartesian_to_polar(NewCartesianPoint {
//                x: PreciseDecimal::from_str("0.7071067812"),
//                y: PreciseDecimal::from_str("0.7071067812")
//            }),
//            NewPolarPoint {
//                r: PreciseDecimal::from_int(1),
//                a: PreciseDecimal::from_int(405)
//            }
//        );
//    }
//
//    #[test]
//    fn at_the_starting_point() {
//        assert_eq!(
//            new_cartesian_to_polar(NewCartesianPoint {
//                x: PreciseDecimal::from_int(0),
//                y: PreciseDecimal::from_int(0)
//            }),
//            NewPolarPoint {
//                r: PreciseDecimal::from_int(0),
//                a: PreciseDecimal::from_int(0)
//            }
//        );
//    }
//}
//
