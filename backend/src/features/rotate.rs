use crate::core::plane::cartesian::cartesian_point::CartesianPoint;
use crate::core::plane::conversions::cartesian_to_polar::cartesian_to_polar;
use crate::core::plane::conversions::polar_to_cartesian::polar_to_cartesian;
use crate::core::plane::plane::Plane;
use crate::core::plane::plane_point::PlanePoint;
use crate::core::plane::polar::rotate::rotate as core_rotate;
use crate::core::precise_decimal::PreciseDecimal;

pub fn rotate(
    point: PlanePoint,
    center_of_rotation: CartesianPoint,
    angle: PreciseDecimal,
) -> PlanePoint {
    match point.plane_type {
        Plane::CARTESIAN => {
            let offset_point = point.to_cartesian() - center_of_rotation.clone();
            let point_as_polar = cartesian_to_polar(offset_point);
            let rotated_point = core_rotate(point_as_polar, angle);
            let point_as_cartesian = polar_to_cartesian(rotated_point);
            let unoffseted_point = point_as_cartesian + center_of_rotation;

            PlanePoint::from_cartesian(unoffseted_point)
        }
        Plane::POLAR => {
            let offset_point = point.to_cartesian() - center_of_rotation.clone();
            let point_as_polar = cartesian_to_polar(offset_point);
            let rotated_point = core_rotate(point_as_polar, angle);
            let point_as_cartesian = polar_to_cartesian(rotated_point);
            let unoffseted_point = point_as_cartesian + center_of_rotation;
            let unoffseted_as_polar = cartesian_to_polar(unoffseted_point);

            PlanePoint::from_polar(unoffseted_as_polar)
        }
    }
}

#[cfg(test)]
mod test_rotate {
    use crate::core::precise_decimal::PreciseDecimal;

    use super::*;

    #[test]
    fn polar_rotate() {
        assert_eq!(
            rotate(
                PlanePoint {
                    plane_type: Plane::POLAR,
                    a: PreciseDecimal::from_str("1.22"),
                    b: PreciseDecimal::from_str("11.11"),
                },
                CartesianPoint {
                    x: PreciseDecimal::from_int(0),
                    y: PreciseDecimal::from_int(0),
                },
                PreciseDecimal::from_str("50"),
            ),
            PlanePoint {
                plane_type: Plane::POLAR,
                a: PreciseDecimal::from_str("1.2199999999993856733934483557"),
                b: PreciseDecimal::from_str("61.10999999998551537151064434"),
            }
        );
        assert_eq!(
            rotate(
                PlanePoint {
                    plane_type: Plane::POLAR,
                    a: PreciseDecimal::from_int(4),
                    b: PreciseDecimal::from_int(90)
                },
                CartesianPoint {
                    x: PreciseDecimal::from_int(4),
                    y: PreciseDecimal::from_int(4),
                },
                PreciseDecimal::from_int(90),
            ),
            PlanePoint {
                plane_type: Plane::POLAR,
                a: PreciseDecimal::from_str("3.999999999999999046149426467"),
                b: PreciseDecimal::from_str("359.99999999999999999999999999")
            }
        );
    }

    #[test]
    fn cartesian_rotate() {
        assert_eq!(
            rotate(
                PlanePoint {
                    plane_type: Plane::CARTESIAN,
                    a: PreciseDecimal::from_int(4),
                    b: PreciseDecimal::from_int(4),
                },
                CartesianPoint {
                    x: PreciseDecimal::from_int(8),
                    y: PreciseDecimal::from_int(0),
                },
                PreciseDecimal::from_int(90),
            ),
            PlanePoint {
                plane_type: Plane::CARTESIAN,
                a: PreciseDecimal::from_str("4.0000000000391914755241257792"),
                b: PreciseDecimal::from_str("-3.9999999993515959027994326119"),
            }
        );
    }
}
