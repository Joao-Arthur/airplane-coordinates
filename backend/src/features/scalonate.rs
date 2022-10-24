use crate::core::plane::cartesian::cartesian_point::CartesianPoint;
use crate::core::plane::conversions::cartesian_to_polar::cartesian_to_polar;
use crate::core::plane::plane::Plane;
use crate::core::plane::plane_point::PlanePoint;

pub fn scalonate(point: PlanePoint, factor: CartesianPoint) -> PlanePoint {
    match point.plane_type {
        Plane::CARTESIAN => PlanePoint::from_cartesian(point.to_cartesian() * factor),
        Plane::POLAR => PlanePoint::from_polar(cartesian_to_polar(point.to_cartesian() * factor)),
    }
}

#[cfg(test)]
mod test_scalonate {
    use crate::core::precise_decimal::PreciseDecimal;

    use super::*;

    #[test]
    fn polar_scalonate() {
        assert_eq!(
            scalonate(
                PlanePoint {
                    plane_type: Plane::POLAR,
                    a: PreciseDecimal::from_int(1),
                    b: PreciseDecimal::from_int(0),
                },
                CartesianPoint {
                    x: PreciseDecimal::from_int(-2),
                    y: PreciseDecimal::from_int(0),
                }
            ),
            PlanePoint {
                plane_type: Plane::POLAR,
                a: PreciseDecimal::from_int(2),
                b: PreciseDecimal::from_str("179.9999999999999863370969626"),
            }
        );
        assert_eq!(
            scalonate(
                PlanePoint {
                    plane_type: Plane::POLAR,
                    a: PreciseDecimal::from_int(1),
                    b: PreciseDecimal::from_int(45),
                },
                CartesianPoint {
                    x: PreciseDecimal::from_int(2),
                    y: PreciseDecimal::from_int(2),
                }
            ),
            PlanePoint {
                plane_type: Plane::POLAR,
                a: PreciseDecimal::from_str("2.0000000000000000000000000000"),
                b: PreciseDecimal::from_str("44.99999999999999944906321630"),
            }
        );
    }

    #[test]
    fn cartesian_scalonate() {
        assert_eq!(
            scalonate(
                PlanePoint {
                    plane_type: Plane::CARTESIAN,
                    a: PreciseDecimal::from_int(5),
                    b: PreciseDecimal::from_int(-1),
                },
                CartesianPoint {
                    x: PreciseDecimal::from_int(-2),
                    y: PreciseDecimal::from_int(2),
                }
            ),
            PlanePoint {
                plane_type: Plane::CARTESIAN,
                a: PreciseDecimal::from_int(-10),
                b: PreciseDecimal::from_int(-2),
            }
        );
    }
}
