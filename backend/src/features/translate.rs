use crate::core::plane::cartesian::cartesian_point::CartesianPoint;
use crate::core::plane::conversions::cartesian_to_polar::cartesian_to_polar;
use crate::core::plane::plane::Plane;
use crate::core::plane::plane_point::PlanePoint;

pub fn translate(point: PlanePoint, factor: CartesianPoint) -> PlanePoint {
    match point.plane_type {
        Plane::CARTESIAN => PlanePoint::from_cartesian(point.to_cartesian() + factor),
        Plane::POLAR => PlanePoint::from_polar(cartesian_to_polar(point.to_cartesian() + factor)),
    }
}

#[cfg(test)]
mod test_translate {
    use crate::core::precise_decimal::PreciseDecimal;

    use super::*;

    #[test]
    fn polar_translate() {
        assert_eq!(
            translate(
                PlanePoint {
                    plane_type: Plane::POLAR,
                    a: "1".to_string(),
                    b: "0".to_string()
                },
                CartesianPoint {
                    x: PreciseDecimal::from_int(-2),
                    y: PreciseDecimal::from_int(0),
                }
            ),
            PlanePoint {
                plane_type: Plane::POLAR,
                a: "1.0000000000000000000000000000".to_string(),
                b: "179.9999999999999863370969626".to_string()
            }
        );
        assert_eq!(
            translate(
                PlanePoint {
                    plane_type: Plane::POLAR,
                    a: "1".to_string(),
                    b: "45".to_string()
                },
                CartesianPoint {
                    x: PreciseDecimal::from_int(1),
                    y: PreciseDecimal::from_int(1),
                }
            ),
            PlanePoint {
                plane_type: Plane::POLAR,
                a: "2.4142135623730950488016887242".to_string(),
                b: "44.99999999999999944906321630".to_string()
            }
        );
    }

    #[test]
    fn cartesian_translate() {
        assert_eq!(
            translate(
                PlanePoint {
                    plane_type: Plane::CARTESIAN,
                    a: "5".to_string(),
                    b: "-1".to_string(),
                },
                CartesianPoint {
                    x: PreciseDecimal::from_int(-2),
                    y: PreciseDecimal::from_int(2),
                }
            ),
            PlanePoint {
                plane_type: Plane::CARTESIAN,
                a: "3".to_string(),
                b: "1".to_string(),
            }
        );
    }
}
